package dev.nikhi1.eventbrite.onboarding.ui

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import dev.nikhi1.eventbrite.core.BaseViewModel
import dev.nikhi1.eventbrite.core.Result
import dev.nikhi1.eventbrite.core.UIState
import dev.nikhi1.eventbrite.core.ViewState
import dev.nikhi1.eventbrite.core.ViewStateLiveData
import dev.nikhi1.eventbrite.core.exhaustive
import dev.nikhi1.eventbrite.onboarding.data.DataRepository
import dev.nikhi1.eventbrite.onboarding.data.model.SubCategoryResponse
import dev.nikhi1.eventbrite.onboarding.data.model.Subcategory
import dev.nikhi1.eventbrite.onboarding.ui.model.Category
import dev.nikhi1.eventbrite.onboarding.ui.model.CategoryViewType
import kotlinx.coroutines.launch

data class OnboardingViewState(
    val uiState: UIState = UIState.Loading,
    val categories: List<CategoryViewType> = emptyList()
) : ViewState

class OnboardingViewModel(private val categoryPresenter: CategoryPresenter, private val dataRepository: DataRepository) : BaseViewModel<OnboardingViewState>() {

    private val _viewState = ViewStateLiveData(
        OnboardingViewState()
    )

    override val viewState: LiveData<OnboardingViewState> = _viewState

    fun fetchTopics() {

        viewModelScope.launch {

            when (val result = dataRepository.getTopics(null)) {

                is Result.Success -> {
                    val data = result.data ?: SubCategoryResponse.EMPTY
                    if (data.subcategories.isNotEmpty()) {
                        _viewState.value =
                            _viewState.value.copy(uiState = UIState.Content, categories = categoryPresenter.map(groupSubcategoryByParentCategory(data.subcategories)))
                    } else {
                        _viewState.value = _viewState.value.copy(uiState = UIState.Empty)
                    }
                }

                is Result.Failure -> {
                    _viewState.value = _viewState.value.copy(uiState = UIState.Error(result.error))
                }
            }.exhaustive
        }
    }

    @VisibleForTesting
    fun groupSubcategoryByParentCategory(list: List<Subcategory>): List<Category> {
        if (list.isEmpty()) return emptyList()

        //start grouping
        return list.groupBy { it.parent_category }.map {
            val subCategories = it.value.map { subcategory ->
                dev.nikhi1.eventbrite.onboarding.ui.model.Subcategory(subcategory.id, subcategory.name)
            }
            Category(it.key.id, it.key.name, subCategories)
        }
    }
}
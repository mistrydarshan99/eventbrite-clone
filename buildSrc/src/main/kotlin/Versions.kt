

internal object Versions {
    const val kotlin = "1.3.41"
    val androidx = "1.2.0"
    val retrofit = "2.3.0"
    val coreKtx = androidx
    val koin = "2.0.1"
    val junit = "4.12"
    val coroutines = "1.3.2"
    val constrainLayout = "1.1.3"
    val compileSDK = 29
    val minSDK = 21
    val targetSDK = compileSDK
    val buildTools = "29.0.2"
    val mockk = "1.9.3"
    val androidxArch = "2.1.0"
    val coreTesting = androidxArch
    val lifecycle = "2.2.0"
    val material = "1.1.0-rc02"
    val gson = "2.8.6"
    val navigation = "2.3.0-alpha04"
    val playCore = "1.6.5"
}

object Libs {
    val kotlinJDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val appcompat = "androidx.appcompat:appcompat:${Versions.androidx}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constrainLayout}"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val androidCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}"
    val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val material = "com.google.android.material:material:${Versions.material}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val navFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navUi = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val dynamicNav = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
    val playCore = "com.google.android.play:core:${Versions.playCore}"

    val junit = "junit:junit:${Versions.junit}"
    val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    val corountinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"
    val navTest = "androidx.navigation:navigation-testing:${Versions.navigation}"

}
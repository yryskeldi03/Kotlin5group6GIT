object Versions {
    const val APG = "7.3.0"
    const val kotlin = "1.7.20"
    const val androidCore = "1.7.0"
    const val appCompat = "1.5.1"
    const val lifecycle = "2.5.1"
    const val material = "1.7.0"
    const val constraint = "2.1.4"
    const val jUnit = "4.13.2"
    const val androidJUnit = "1.1.3"
    const val espresso = "3.4.0"
    const val fragment = "1.5.4"
    const val daggerHilt = "2.44.2"
    const val roomVersion = "2.4.3"
    const val navigation = "2.5.3"
    const val coroutine = "1.6.4"
    const val viewBindingDelegate = "1.5.6"
}

object Dependencies {

    object UIComponents {
        const val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
        const val jUnit = "junit:junit:${Versions.jUnit}"
        const val androidJUnit = "junit:junit:${Versions.androidJUnit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    }

    object DaggerHilt {
        const val android = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.daggerHilt}"
    }

    object Navigation {
        const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val room = "androidx.room:room-ktx:${Versions.roomVersion}"
        const val compiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    }

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }

    object Coroutines {
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    }

    object ViewBindingDelegate {
        const val delegate =
            "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.viewBindingDelegate}"
    }

    object Javax {
        const val inject = "javax.inject:javax.inject:1"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:4.14.2"
        const val compile = "com.github.bumptech.glide:compiler:4.14.2"
    }

}

object Plugins {

    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
        const val java = "java-library"
    }

    object Kotlin {
        const val kapt = "kotlin-kapt"
        const val kotlin = "org.jetbrains.kotlin.android"
        const val jvm = "org.jetbrains.kotlin.jvm"
    }

    object DaggerHilt {
        const val hilt = "com.google.dagger.hilt.android"
    }

}
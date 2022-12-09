import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.kotlin)
    id(Plugins.DaggerHilt.hilt)
    id(Plugins.Kotlin.kapt)
}

android {
    namespace = "com.yrys.kotlin5group06lesson6multimodule"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.yrys.kotlin5group06lesson6multimodule"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Options.kotlinOptions
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":data"))

    // UI
    implementation(Dependencies.UIComponents.androidCore)
    implementation(Dependencies.UIComponents.appCompat)
    implementation(Dependencies.UIComponents.material)
    implementation(Dependencies.UIComponents.constraint)
    testImplementation(Dependencies.UIComponents.jUnit)
    androidTestImplementation(Dependencies.UIComponents.androidJUnit)
    androidTestImplementation(Dependencies.UIComponents.espresso)
    implementation(Dependencies.UIComponents.fragment)

    // Dagger-Hilt
    implementation(Dependencies.DaggerHilt.android)
    kapt(Dependencies.DaggerHilt.compiler)

    // ViewBindingDelegate
    implementation(Dependencies.ViewBindingDelegate.delegate)

    // Coroutines
    implementation(Dependencies.Coroutines.android)

    // Lifecycle
    implementation(Dependencies.Lifecycle.runtime)
    implementation(Dependencies.Lifecycle.viewModel)

    // Navigation
    implementation(Dependencies.Navigation.navigation)
    implementation(Dependencies.Navigation.navigationUI)

    // Room
    implementation(Dependencies.Room.room)
    implementation(Dependencies.Room.compiler)
    implementation(Dependencies.Room.runtime)

}
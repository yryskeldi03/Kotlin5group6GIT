plugins {
    id(Plugins.AGP.library)
    id(Plugins.Kotlin.kotlin)
}

android {
    namespace = "com.yrys.mylibrary"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
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
}

dependencies {

    implementation(project(":domain"))

    // Android core
    implementation(Dependencies.UIComponents.androidCore)

    // Test
    testImplementation(Dependencies.UIComponents.jUnit)
    androidTestImplementation(Dependencies.UIComponents.androidJUnit)

    // Room
    implementation(Dependencies.Room.compiler)
    implementation(Dependencies.Room.room)
    implementation(Dependencies.Room.runtime)

    // Dagger-Hilt
    implementation(Dependencies.DaggerHilt.compiler)
    implementation(Dependencies.DaggerHilt.android)

    // Coroutines
    implementation(Dependencies.Coroutines.android)

}
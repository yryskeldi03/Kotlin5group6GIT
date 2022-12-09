plugins {
    id(Plugins.AGP.java)
    id(Plugins.Kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Javax.inject)
}
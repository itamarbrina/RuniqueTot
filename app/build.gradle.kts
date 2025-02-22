plugins {
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.runique.android.application)
}

android {
    namespace = "com.example.myapplication"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.core.presentation.designsystem)
    implementation(projects.core.presentation.ui)
    implementation(projects.core.database)

    implementation(projects.auth.domain)
    implementation(projects.auth.presentation)
    implementation(projects.auth.data)

    implementation(projects.run.domain)
    implementation(projects.run.presentation)
    implementation(projects.run.data)
    implementation(projects.run.location)
    implementation(projects.run.network)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
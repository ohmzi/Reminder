// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}

buildscript {
    ext {
        hilt_version = ("2.48.1") // Use the latest stable version
    }
    dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:$hilt_version")
    }
}
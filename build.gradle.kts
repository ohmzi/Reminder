// Plugin management for version catalogs
plugins {
    alias(libs.plugins.android.application) apply false
    id("com.android.library") version "8.2.1" apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
}
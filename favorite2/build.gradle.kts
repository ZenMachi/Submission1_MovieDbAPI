plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

apply(from = "../shared_dependencies.gradle")


android {
    namespace = "com.dokari4.favorite2"
    compileSdk = 33

    lint {
        baseline = file("lint-baseline.xml")
        disable += "OldTargetApi"
        disable += "Typos"
        disable += "Overdraw"
        disable += "UnusedResources"
        disable += "TypographyEllipsis"
        disable += "HardcodedText"
        disable += "RtlHardcoded"
        disable += "GradleDependency"
    }

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":app"))
    implementation(project(":core"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    androidTestImplementation("androidx.annotation:annotation:1.6.0")
}
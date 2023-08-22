plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
}

apply(from = "../shared_dependencies.gradle")


android {
    namespace = "com.dokari4.submission1_pokeapi.core"
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
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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

val roomVersion = rootProject.extra["room_version"]
val retrofitVersion = rootProject.extra["retrofit_version"]
val loggingInterceptorVersion = rootProject.extra["logging_interceptor_version"]

val rxLifecycleVersion = rootProject.extra["rxlifecycle_version"]
val rxAndroidVersion = rootProject.extra["rxandroid_version"]
val rxJavaVersion = rootProject.extra["rxjava_version"]

val fragmentKtxVersion = rootProject.extra["fragment_ktx_version"]
val activityKtxVersion = rootProject.extra["activity_ktx_version"]

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    //Room
    api ("androidx.room:room-runtime:$roomVersion")
    ksp ("androidx.room:room-compiler:$roomVersion")
    androidTestImplementation ("androidx.room:room-testing:$roomVersion")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    //noinspection GradleDependency
    api ("com.squareup.okhttp3:logging-interceptor:$loggingInterceptorVersion")

    //RxJava
    api ("io.reactivex.rxjava2:rxjava:$rxJavaVersion")
    implementation ("io.reactivex.rxjava2:rxandroid:$rxAndroidVersion")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion")
    implementation ("androidx.room:room-rxjava2:$roomVersion")
    //noinspection GradleDependency
    api ("androidx.lifecycle:lifecycle-reactivestreams-ktx:$rxLifecycleVersion")

    //noinspection GradleDependency
    api ("androidx.activity:activity-ktx:$activityKtxVersion")
    //noinspection GradleDependency
    api ("androidx.fragment:fragment-ktx:$fragmentKtxVersion")

    //Database Encryption
    implementation ("net.zetetic:android-database-sqlcipher:4.4.0")
    implementation ("androidx.sqlite:sqlite-ktx:2.1.0")
}
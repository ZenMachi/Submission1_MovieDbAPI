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
        quiet = true
        abortOnError = false
        ignoreWarnings = true
    }

    defaultConfig {
        minSdk = 24
        multiDexEnabled = true
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

    //Room
    api ("androidx.room:room-runtime:$roomVersion")
    ksp ("androidx.room:room-compiler:$roomVersion")
    androidTestImplementation ("androidx.room:room-testing:$roomVersion")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    api ("com.squareup.okhttp3:logging-interceptor:$loggingInterceptorVersion")

    //RxJava
    api ("io.reactivex.rxjava2:rxjava:$rxJavaVersion")
    implementation ("io.reactivex.rxjava2:rxandroid:$rxAndroidVersion")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion")
    implementation ("androidx.room:room-rxjava2:$roomVersion")
    api ("androidx.lifecycle:lifecycle-reactivestreams-ktx:$rxLifecycleVersion")

    api ("androidx.activity:activity-ktx:$activityKtxVersion")
    api ("androidx.fragment:fragment-ktx:$fragmentKtxVersion")
}
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.nandemocatchup"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nandemocatchup"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    flavorDimensions += "plan"

    productFlavors {
        create("free") {
            // 無料版
            dimension = "plan"
            applicationIdSuffix = ".free" // アプリケーションIDが com.example.nandemocatchup.free となり、GooglePlayStoreで別々のアプリとして出せる。
            versionNameSuffix = "-free"
        }

        create("pro") {
            // 有料版
            dimension = "plan"
            applicationIdSuffix = ".pro" // アプリケーションIDが com.example.nandemocatchup.pro となり、GooglePlayStoreで別々のアプリとして出せる。
            versionNameSuffix = "-pro"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
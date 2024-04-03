plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.apollographql.apollo3").version("3.7.3")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

apollo {
    service("service") {
        packageName.set("com.ibuqa")
    }
}

android {
    namespace = "com.ibuqa.screening"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ibuqa.screening"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    hilt {
        enableAggregatingTask = true
    }
}
dependencies {

        implementation("androidx.core:core-ktx:1.7.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
        implementation("androidx.activity:activity-compose:1.3.1")
        implementation ("androidx.compose.material3:material3:1.1.0-alpha04")
        implementation("androidx.compose.ui:ui:1.2.0")
        implementation("androidx.compose.ui:ui-tooling-preview:1.2.0")
        implementation("androidx.compose.material:material:1.2.0")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.2.0")
        debugImplementation("androidx.compose.ui:ui-tooling:1.2.0")
        debugImplementation("androidx.compose.ui:ui-test-manifest:1.2.0")
        implementation ("androidx.compose.material:material-icons-extended:1.3.1")
        implementation("com.apollographql.apollo3:apollo-runtime:3.7.3")
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

        // Dagger Hilt
        implementation ("com.google.dagger:hilt-android:2.44.2")
        kapt ("com.google.dagger:hilt-compiler:2.44.2")
        implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

        implementation("com.squareup.okhttp3:okhttp:4.12.0")
        implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

        implementation("io.coil-kt:coil-compose:2.6.0")




}

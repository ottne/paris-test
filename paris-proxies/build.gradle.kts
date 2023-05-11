plugins {
    id("com.android.library")
    kotlin("android")
    id("com.google.devtools.ksp")
    id("com.jakewharton.butterknife")
    id("kotlin-android")
}

android {
    namespace = "de.danotter.parisproxies"
    compileSdk = 33

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "CONTENT_SCHEME", "\"general\"")
    }

    buildTypes {
        getByName("release") {
            consumerProguardFile("proguard-rules.pro")
        }
        getByName("debug") {
            packagingOptions {
                resources {
                    excludes += setOf("META-INF/AL2.0", "META-INF/LGPL2.1")
                }
            }
        }
    }
    compileOptions {
        targetCompatibility(8)
        sourceCompatibility(8)
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

afterEvaluate {
    tasks.withType<butterknife.plugin.R2Generator> {
        packageName = "de.danotter.parisproxies"
    }
}


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation("com.google.android.material:material:1.9.0")
    implementation("com.airbnb.android:paris:2.0.2")
    ksp("com.airbnb.android:paris-processor:2.0.2")
}

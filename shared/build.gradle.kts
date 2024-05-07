plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.8.0"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }


    sourceSets {
        commonMain.dependencies {
            implementation(libs.koinCoroutinesCore)
            implementation(libs.ktoreClientCore)
            implementation(libs.ktorClientContent)
            implementation(libs.ktorSerializationKotlinxJson)
            implementation("io.ktor:ktor-client-logging:2.3.10")

            //Use api so that the android app can use it as well
            api(libs.koinCore)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)

        }

        //AndroidMain sourceSet
        val androidMain by getting {
            dependencies {
                implementation(libs.ktorClientAndroidVersion)
                api(libs.koinAndroid)
            }
        }

        val iosMain by creating {
            dependencies {
                implementation(libs.ktoriOSVersion)
            }
        }
    }
}

android {
    namespace = "com.kuriotetsuya.epl"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

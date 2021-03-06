plugins {
    android("library")
    kotlin("android")
}

android {
    compileSdkVersion(SDK_TARGET)
    defaultConfig {
        minSdkVersion(SDK_MIN)
        targetSdkVersion(SDK_TARGET)
        versionName = RELEASE_VERSION
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    sourceSets {
        getByName("main") {
            manifest.srcFile("AndroidManifest.xml")
            java.srcDir("src")
            res.srcDir("res")
        }
    }
    libraryVariants.all {
        generateBuildConfigProvider?.configure {
            enabled = false
        }
    }
}

dependencies {
    api(kotlin("stdlib"))
    api(kotlin("test-junit", VERSION_KOTLIN))
    api(material())
    api(androidx("core", "core-ktx"))
    api(androidx("appcompat"))
    api(androidx("coordinatorlayout"))
    api(androidx("test", "core-ktx", VERSION_ANDROIDX_TEST))
    api(androidx("test", "runner", VERSION_ANDROIDX_TEST))
    api(androidx("test", "rules", VERSION_ANDROIDX_TEST))
    api(androidx("test.ext", "junit-ktx", VERSION_ANDROIDX_JUNIT))
    api(androidx("test.ext", "truth", VERSION_ANDROIDX_TRUTH))
    api(androidx("test.espresso", "espresso-core", VERSION_ESPRESSO))
}

plugins {
    id(Plugins.AndroidApplication.ID)
    kotlin(Plugins.KotlinAndroid.ID)
    kotlin(Plugins.KotlinAndroidExtensions.ID)

    id(Plugins.Ktlint.ID)
}

android {
    compileSdkVersion(Android.COMPILE_SDK_VERSION)

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    defaultConfig {
        applicationId = Android.DefaultConfig.APPLICATION_ID
        minSdkVersion(Android.DefaultConfig.MIN_SDK_VERSION)
        targetSdkVersion(Android.DefaultConfig.TARGET_SDK_VERSION)
        versionCode = Android.DefaultConfig.VERSION_CODE
        versionName = Android.DefaultConfig.VERSION_NAME
        testInstrumentationRunner = Android.DefaultConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypes.Debug.isMinifyEnabled
            isTestCoverageEnabled = BuildTypes.Debug.isTestCoverageEnabled
        }
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypes.Release.isMinifyEnabled
            isTestCoverageEnabled = BuildTypes.Release.isTestCoverageEnabled
            proguardFiles(
                getDefaultProguardFile(BuildTypes.Release.Proguard.DEFAULT_FILE),
                BuildTypes.Release.Proguard.FILE
            )
        }
    }

    flavorDimensions(ProductFlavor.Companion.Dimensions.ENVIRONMENT)
    productFlavors {
        create(ProductFlavors.Mock.name) {
            dimension = ProductFlavors.Mock.dimension
            applicationIdSuffix = ProductFlavors.Mock.applicationIdSuffix
            resValue(
                Resources.ApplicationName.type,
                Resources.ApplicationName.name,
                ProductFlavors.Mock.applicationName
            )
        }
        create(ProductFlavors.Dev.name) {
            dimension = ProductFlavors.Dev.dimension
            applicationIdSuffix = ProductFlavors.Dev.applicationIdSuffix
            resValue(
                Resources.ApplicationName.type,
                Resources.ApplicationName.name,
                ProductFlavors.Dev.applicationName
            )
        }
        create(ProductFlavors.Pro.name) {
            dimension = ProductFlavors.Pro.dimension
            applicationIdSuffix = ProductFlavors.Pro.applicationIdSuffix
            resValue(
                Resources.ApplicationName.type,
                Resources.ApplicationName.name,
                ProductFlavors.Pro.applicationName
            )
        }
    }

    lintOptions {
        disable(Android.LintOptions.Disabled.OVERDRAW)
        isWarningsAsErrors = Android.LintOptions.WARNINGS_AS_ERRORS
    }

    sourceSets {
        map { it.java.srcDir(String.format(Android.SourceSet.SRC_DIR, it.name)) }
    }
}

dependencies {
    implementation(Dependencies.KTX)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.CONSTRAINT_LAYOUT)
    implementation(Dependencies.BIOMETRIC)
    implementation(Dependencies.VIEW_PAGER)

    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.COROUTINES)
    implementation(Dependencies.KODEIN)
    implementation(Dependencies.TIMBER)

    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.MAPS)
    implementation(Dependencies.LOCATION)

    implementation(Dependencies.MESSAGING)

    implementation(Dependencies.EMA)
    implementation(Dependencies.EMA_ANDROID)

    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.GSON)
    implementation(Dependencies.SCALARS)
    implementation(Dependencies.COROUTINES_ADAPTER)
    implementation(Dependencies.LOGGING_INTERCEPTOR)

    implementation(Dependencies.PICASSO)
    implementation(Dependencies.LOTTIE)

    testImplementation(Dependencies.ARCH)
    testImplementation(Dependencies.EMA_TESTING)
}

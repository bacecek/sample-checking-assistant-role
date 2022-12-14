import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.gradle.BaseExtension
import dev.bacecek.SampleProperties

extensions.getByName<BaseExtension>("android").apply {
    compileSdkVersion(33)
    defaultConfig {
        targetSdk = 33
        minSdk = 29
    }

    buildTypes {
        named("debug") {
            isMinifyEnabled = false
        }
        named("release") {
            isMinifyEnabled = false
            proguardFiles.add(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFiles.add(file("proguard-rules.pro"))
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

val forcedBuildType = SampleProperties.forcedBuildType
if (forcedBuildType != null) {
    extensions.getByName<AndroidComponentsExtension<*, *, *>>("androidComponents").apply {
        beforeVariants { variant ->
            variant.enable = variant.buildType == forcedBuildType
        }
    }
}
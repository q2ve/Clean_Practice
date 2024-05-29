import com.android.sdklib.AndroidVersion

plugins {
	alias(libs.plugins.application)
	alias(libs.plugins.kotlinAndroid)
	alias(libs.plugins.kapt)
}

android {
	namespace = "com.example.clean_playground"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.example.clean_playground"
		minSdk = 29
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"
	}

	buildTypes {
		debug {
			isMinifyEnabled = false
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		viewBinding = true
	}
}

dependencies {
	implementation(libs.ktx)
	implementation(libs.fragment)
	implementation(libs.dagger2)
	kapt(libs.dagger2compiler)
	implementation(project(":checklist_presentation"))
}
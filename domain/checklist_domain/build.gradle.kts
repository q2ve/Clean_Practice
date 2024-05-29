import com.android.sdklib.AndroidVersion

plugins {
	alias(libs.plugins.library)
	alias(libs.plugins.kotlinAndroid)
	alias(libs.plugins.kapt)
}

android {
	namespace = "com.example.clean_playground"

	compileSdk = AndroidVersion.VersionCodes.UPSIDE_DOWN_CAKE // Android 14, API level 34

	defaultConfig {
		minSdk = AndroidVersion.VersionCodes.O_MR1 // Android 8.1, API level 27
	}

	buildTypes {
		debug {
			isMinifyEnabled = false
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

dependencies {
	implementation(libs.ktx)
	implementation(libs.fragment)
	implementation(libs.recyclerview)
	implementation(libs.dagger2)
	kapt(libs.dagger2compiler)
	implementation(libs.viewmodel)
	implementation(libs.livedata)
	implementation(libs.coroutines)
	implementation(libs.adapterdelegates)
	implementation(libs.kotlinfaker)
	implementation(project(":entities"))
}

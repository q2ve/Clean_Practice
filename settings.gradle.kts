pluginManagement {
	repositories {
		google()
		mavenCentral()
		gradlePluginPortal()
	}
}

buildscript {
	repositories {
		mavenCentral()
	}

	dependencies {
		// Not possible to access "libs" here to use versions catalog.
		@Suppress("UseTomlInstead")
		classpath("org.json:json:20231013")
	}
}

rootProject.name = "Clean_Playground"

include(":app")

include(":checklist_data")
project(":checklist_data").projectDir = File(rootDir, "data/checklist_data")

include(":checklist_domain")
project(":checklist_domain").projectDir = File(rootDir, "domain/checklist_domain")

include(":entities")
project(":entities").projectDir = File(rootDir, "domain/entities")

include(":checklist_presentation")
project(":checklist_presentation").projectDir = File(rootDir, "presentation/checklist_presentation")
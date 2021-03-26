buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
        maven(url = "http://oss.jfrog.org/artifactory/oss-snapshot-local")
    }
    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.20")
//        classpath("com.android.tools.build:gradle:4.2.0-beta06")

        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")
        classpath("com.android.tools.build:gradle:4.0.1")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()

        maven(url = "http://oss.jfrog.org/artifactory/oss-snapshot-local")
    }
}

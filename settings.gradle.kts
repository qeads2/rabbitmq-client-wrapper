pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
        val springVersion = extra["spring.version"] as String
        val springDependencyManagementVersion = extra["spring.dependency-management.version"] as String
        kotlin("jvm").version(kotlinVersion)
        kotlin("plugin.spring").version(kotlinVersion)
        id("org.springframework.boot").version(springVersion)
        id("io.spring.dependency-management").version(springDependencyManagementVersion)
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "rabbitmq-client-wrapper"
include("rabbitmq-sender")
include("rabbitmq-receiver")
include("examples")


plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.spring") apply false
    id("io.spring.dependency-management") apply false
    id("org.springframework.boot") apply false
}

group = "onim.test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "kotlin-spring")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-amqp")
    }
}

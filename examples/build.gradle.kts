plugins {
    kotlin("jvm")
    kotlin("plugin.noarg") version "1.9.21"
}

group = "onim.test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":rabbitmq-receiver"))

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

noArg {
    annotation("onim.test.annotation.NoArg")
}
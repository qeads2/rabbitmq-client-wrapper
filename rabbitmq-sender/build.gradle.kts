group = "onim.test"

repositories {
    mavenCentral()
}

dependencies {
    // spring boot start test
    implementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}

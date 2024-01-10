plugins {
    kotlin("jvm") version "1.9.21"
}

group = "ru.netology"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib")
    implementation ("com.google.firebase:firebase-admin:9.2.0")
    implementation ("org.slf4j:slf4j-simple:2.0.11")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}
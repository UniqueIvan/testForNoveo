import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/io.rest-assured/rest-assured
    implementation("io.rest-assured:rest-assured:5.3.0")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    // https://mvnrepository.com/artifact/org.assertj/assertj-core
    implementation("org.assertj:assertj-core:3.24.2")
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    // https://mvnrepository.com/artifact/com.willowtreeapps.assertk/assertk
    implementation("com.willowtreeapps.assertk:assertk:0.26.1")
    implementation ("log4j:log4j:1.2.17")
    implementation ("io.qameta.allure:allure-junit5:2.14.0")
    implementation ("io.qameta.allure:allure-commandline:2.14.0")
    implementation ("io.qameta.allure:allure-assertj:2.14.0")
    implementation ("io.qameta.allure:allure-rest-assured:2.14.0")
    implementation ("io.qameta.allure:allure-java-commons:2.14.0")
    // https://mvnrepository.com/artifact/org.aspectj/aspectjweaver
    runtimeOnly("org.aspectj:aspectjweaver:1.9.19")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}
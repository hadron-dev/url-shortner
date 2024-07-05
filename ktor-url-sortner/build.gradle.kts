val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.0.0"
    id("io.ktor.plugin") version "2.3.12"
    id("it.nicolasfarabegoli.conventional-commits") version "3.1.3"
}

group = "dev.hadron"
version = "0.0.1"

application {
    mainClass.set("dev.hadron.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

// accepted types: fix, feat, build, chore, ci, docs, style, refactor, perf, test, tmp
// simplified commit format: 'type(scope): message'
// example commit: 'feat(android): Added app widget'
// see link for more details on Conventional Commits
// https://www.conventionalcommits.org/en/v1.0.0/
conventionalCommits {
    types += listOf("tmp")
    scopes += listOf("shortener-service", "android", "ios")
    failureMessage = "The commit message does not meet the Conventional Commit standard"
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-default-headers-jvm")
    implementation("io.ktor:ktor-server-call-logging-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

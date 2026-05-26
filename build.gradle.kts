plugins {
    kotlin("jvm") version "2.3.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven(url = "https://cache-redirector.jetbrains.com/intellij-dependencies")
    maven(url = "https://www.jetbrains.com/intellij-repository/releases")
    maven(url = "https://www.jetbrains.com/intellij-repository/snapshots")
    maven(url = "https://download.jetbrains.com/teamcity-repository")
    maven(url = "https://cache-redirector.jetbrains.com/packages.jetbrains.team/maven/p/grazi/grazie-platform-public")
}

dependencies {

    testImplementation(kotlin("test"))

    val ideStarterVersion = "LATEST-EAP-SNAPSHOT"

    testImplementation("com.jetbrains.intellij.tools:ide-starter-squashed:$ideStarterVersion")
    testImplementation("com.jetbrains.intellij.tools:ide-starter-junit5:$ideStarterVersion")
    testImplementation("com.jetbrains.intellij.tools:ide-starter-driver:$ideStarterVersion")

    testImplementation("com.jetbrains.intellij.tools:ide-starter-product-idea-ultimate:$ideStarterVersion")

    testImplementation("com.jetbrains.intellij.driver:driver-client:$ideStarterVersion")
    testImplementation("com.jetbrains.intellij.driver:driver-sdk:$ideStarterVersion")
    testImplementation("com.jetbrains.intellij.driver:driver-model:$ideStarterVersion")

    testImplementation("org.junit.jupiter:junit-jupiter:5.12.2")
}

kotlin {
    jvmToolchain(25)

}

tasks.test {
    useJUnitPlatform()

    jvmArgs("--add-opens=java.base/sun.nio.fs=ALL-UNNAMED")

}
plugins {
    id("application")
    id("java")
}

group = "dev.cara"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("dev.cara.Main")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
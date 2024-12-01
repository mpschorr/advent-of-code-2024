plugins {
    kotlin("jvm") version "2.0.21"
}

group = "me.jeelzzz"
version = "1.0-SNAPSHOT"

sourceSets {
    main {
        kotlin.srcDir("src")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
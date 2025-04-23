plugins {
    application
    kotlin("jvm") version "1.6.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.12.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    mainClass.set("org.example.App")
}

tasks.register<Jar>("createJar") {
    group = "build"
    description = "Assemble JAR with main classes"
    archiveFileName.set("my-gradle-app.jar")
    destinationDirectory.set(file("$buildDir/libs"))
    from(sourceSets.main.get().output)
    manifest {
        attributes["Main-Class"] = "org.example.App"
    }
}

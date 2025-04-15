plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Kotlin standard library
    implementation(kotlin("stdlib", "1.5.31")) // تأكد من استخدام النسخة الصحيحة
    
    // Guava dependency for the application
    implementation(libs.guava)

    // JUnit Jupiter for testing
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.2")
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use TestNG test framework
            useTestNG("7.5.1")
        }
    }
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(8)
    }
}

application {
    // Define the main class for the application.
    mainClass = "org.example.App"
}

tasks.test {
    useJUnitPlatform()
}

import java.net.URI
import javax.annotation.Nullable

plugins {
    `java-library`
    `maven-publish`
    id("com.diffplug.spotless") version "6.22.0"
}

group = "software.amazon.cryptography"
version = "1.0-SNAPSHOT"
description = "ComAmazonawsKms"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
    sourceSets["main"].java {
        srcDir("src/main/java")
        srcDir("src/main/dafny-generated")
        srcDir("src/main/smithy-generated")
    }
    sourceSets["test"].java {
        srcDir("src/test/dafny-generated")
    }
}

var caUrl: URI? = null
@Nullable
val caUrlStr: String? = System.getenv("CODEARTIFACT_URL_JAVA_CONVERSION")
if (!caUrlStr.isNullOrBlank()) {
    caUrl = URI.create(caUrlStr)
}

var caPassword: String? = null
@Nullable
val caPasswordString: String? = System.getenv("CODEARTIFACT_AUTH_TOKEN")
if (!caPasswordString.isNullOrBlank()) {
    caPassword = caPasswordString
}

repositories {
    mavenCentral()
    mavenLocal()
    if (caUrl != null && caPassword != null) {
        maven {
            name = "CodeArtifact"
            url = caUrl!!
            credentials {
                username = "aws"
                password = caPassword!!
            }
        }
    }
}

dependencies {
    implementation("org.dafny:DafnyRuntime:4.2.0")
    implementation("software.amazon.smithy.dafny:conversion:0.1")
    implementation("software.amazon.cryptography:StandardLibrary:1.0-SNAPSHOT")
    implementation(platform("software.amazon.awssdk:bom:2.19.1"))
    implementation("software.amazon.awssdk:kms")
}

publishing {
    publications.create<MavenPublication>("mavenLocal") {
        groupId = "software.amazon.cryptography"
        artifactId = "ComAmazonawsKms"
        from(components["java"])
    }
    publications.create<MavenPublication>("maven") {
        groupId = "software.amazon.cryptography"
        artifactId = "ComAmazonawsKms"
        from(components["java"])
    }
    repositories { mavenLocal() }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Wrapper>() {
    gradleVersion = "7.6"
}

tasks {
    register("runTests", JavaExec::class.java) {
        mainClass.set("TestsFromDafny")
        classpath = sourceSets["test"].runtimeClasspath
    }
}

// Commented out until the format has been updated
// spotless {
//   java {
//     googleJavaFormat()
//   }
// }

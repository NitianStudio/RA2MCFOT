plugins {
    id("com.github.johnrengelman.shadow")
}

architectury {
    platformSetupLoomIde()
    neoForge()
}

val common by configurations.creating
val shadowBundle by configurations.creating
common.isCanBeConsumed = false
shadowBundle.isCanBeConsumed = false
common.isCanBeResolved = true
shadowBundle.isCanBeResolved = true
configurations.compileClasspath.configure {
    extendsFrom(common)
}
configurations.runtimeClasspath.configure {
    extendsFrom(common)
}
configurations.getByName("developmentNeoForge").extendsFrom(common)

var buildProperties = buildProperties()

repositories {
    maven("https://maven.neoforged.net/releases")
}

dependencies {

    "neoForge"("net.neoforged:neoforge:${buildProperties.getProperty("neoforge.version")}")

    modImplementation("dev.architectury:architectury-neoforge:${buildProperties.getProperty("architectury.api.version")}")

    common(project(path= ":common", configuration = "namedElements")) {
        isTransitive = false
    }
    shadowBundle(project(path= ":common", configuration = "transformProductionNeoForge"))
}

tasks {
    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand("version" to project.version)
        }
    }

    shadowJar {
        configurations = listOf(shadowBundle)
        archiveClassifier= "dev-shadow"
    }

    remapJar {
        inputFile.set(shadowJar.get().archiveFile)
    }
}
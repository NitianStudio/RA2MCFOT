plugins {
    id("com.github.johnrengelman.shadow")
}

val buildProperties = buildProperties()

architectury {
    platformSetupLoomIde()
    fabric()
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
configurations.getByName("developmentFabric").extendsFrom(common)

dependencies {
    modImplementation("net.fabricmc:fabric-loader:${buildProperties.getProperty("fabric.loader.version")}")

    modImplementation("net.fabricmc.fabric-api:fabric-api:${buildProperties.getProperty("fabric.api.version")}")

    modImplementation("dev.architectury:architectury-fabric:${buildProperties.getProperty("architectury.api.version")}")
    common(project(":common", configuration = "namedElements")) {
        isTransitive = false
    }
    shadowBundle(project(path=":common", configuration="transformProductionFabric"))
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
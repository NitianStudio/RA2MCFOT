import java.util.Properties

pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        maven("https://maven.architectury.dev/")
        maven("https://files.minecraftforge.net/maven/")
        gradlePluginPortal()
    }
}

var settingsPropertiesPath = file("gradle/ext/settings.properties")

var settingsProperties = Properties()
if (settingsPropertiesPath.exists().not()) {
    settingsProperties.put("projName", "maven-publish-template")
    settingsPropertiesPath.bufferedWriter(Charsets.UTF_8).use {
        settingsProperties.store(it, "gradle.properties manager")
    }
} else {
    settingsPropertiesPath.bufferedReader(Charsets.UTF_8).use {
        settingsProperties.load(it)
    }
}


rootProject.name = settingsProperties.getProperty("projName")

include("common", "fabric", "neoforge")
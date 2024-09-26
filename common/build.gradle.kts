val buildProperties = buildProperties()

architectury {
    common(buildProperties.getProperty("enabled.platforms").split(","))
}

dependencies {
    modImplementation("net.fabricmc:fabric-loader:${buildProperties.getProperty("fabric.loader.version")}")
    modImplementation("dev.architectury:architectury:${buildProperties.getProperty("architectury.api.version")}")
}

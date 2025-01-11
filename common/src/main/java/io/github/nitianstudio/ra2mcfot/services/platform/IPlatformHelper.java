package io.github.nitianstudio.ra2mcfot.services.platform;

public interface IPlatformHelper {
    /**
     * Get the mod loader name
     * @return name
     */
    String loader();

    /**
     * Check mod is loaded
     * @param modid modid
     * @return true if loaded
     */
    boolean modLoaded(String modid);

    boolean isDevelopmentEnvironment();

    default String getEnvironmentName() {
        return isDevelopmentEnvironment() ? "development" : "production";
    }
}

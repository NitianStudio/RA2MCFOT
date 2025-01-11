package io.github.nitianstudio.ra2mcfot.services;

import com.google.auto.service.AutoService;
import io.github.nitianstudio.ra2mcfot.services.platform.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

@AutoService(IPlatformHelper.class)
public class FabricPlatformHelper implements IPlatformHelper {
    /**
     * Get the mod loader name
     *
     * @return name
     */
    @Override
    public String loader() {
        return "Fabric";
    }

    /**
     * Check mod is loaded
     *
     * @param modid modid
     * @return true if loaded
     */
    @Override
    public boolean modLoaded(String modid) {
        return FabricLoader.getInstance().isModLoaded(modid);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}

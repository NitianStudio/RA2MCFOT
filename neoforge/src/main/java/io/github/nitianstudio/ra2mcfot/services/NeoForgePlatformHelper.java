package io.github.nitianstudio.ra2mcfot.services;

import com.google.auto.service.AutoService;
import io.github.nitianstudio.ra2mcfot.services.platform.IPlatformHelper;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

@AutoService(IPlatformHelper.class)
public class NeoForgePlatformHelper implements IPlatformHelper {
    /**
     * Get the mod loader name
     *
     * @return name
     */
    @Override
    public String loader() {
        return "NeoForge";
    }

    /**
     * Check mod is loaded
     *
     * @param modid modid
     * @return true if loaded
     */
    @Override
    public boolean modLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }
}

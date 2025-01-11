package io.github.nitianstudio.ra2mcfot.services;

import com.google.auto.service.AutoService;
import io.github.nitianstudio.ra2mcfot.services.platform.IPlatformHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

@AutoService(IPlatformHelper.class)
public class ForgePlatformHelper implements IPlatformHelper {
    /**
     * Get the mod loader name
     *
     * @return name
     */
    @Override
    public String loader() {
        return "Forge";
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

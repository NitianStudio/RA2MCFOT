package io.github.nitianstudio.ra2mcfot.fabric;

import io.github.nitianstudio.ra2mcfot.Ra2mcfot;
import net.fabricmc.api.ModInitializer;

public final class Ra2mcfotFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Ra2mcfot.init();
    }
}

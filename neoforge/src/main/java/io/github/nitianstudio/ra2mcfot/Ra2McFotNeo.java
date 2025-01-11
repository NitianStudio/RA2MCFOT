package io.github.nitianstudio.ra2mcfot;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MODID)
public class Ra2McFotNeo {
    public Ra2McFotNeo(IEventBus eventBus) {
        Ra2McFot.init();
    }
}

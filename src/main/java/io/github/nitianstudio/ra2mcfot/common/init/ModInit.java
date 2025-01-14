package io.github.nitianstudio.ra2mcfot.common.init;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;

import static io.github.nitianstudio.ra2mcfot.Ra2McFot.MODID;

public class ModInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister<CreativeModeTab> GROUPS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static void init(IEventBus modBus) {
        try {
            loadClass(
                    modBus,
                    Pair.of(BLOCKS, ModBlocks.class),
                    Pair.of(ITEMS, ModItems.class),
                    Pair.of(GROUPS, ModGroups.class)
            );
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

    }


    @SafeVarargs
    public static void loadClass(IEventBus modBus, Pair<DeferredRegister<?>, Class<?>>... pairs) throws ClassNotFoundException {
        for (Pair<DeferredRegister<?>, Class<?>> pair : pairs) {
            Class.forName(pair.getSecond().getName());
            pair.getFirst().register(modBus);
        }
    }

}

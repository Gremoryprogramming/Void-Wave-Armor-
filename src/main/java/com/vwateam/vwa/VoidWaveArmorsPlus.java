package com.vwateam.vwa;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.vwateam.vwa.core.Init.BLOCKS;
import static com.vwateam.vwa.core.Init.ITEMS;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VoidWaveArmorsPlus.MOD_ID)
public class VoidWaveArmorsPlus
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    // Mod ID Const
    public static final String MOD_ID = "vwa";

    public VoidWaveArmorsPlus() {
        // Get the mod event bus, so we can listen to events
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register(bus);
        BLOCKS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

}

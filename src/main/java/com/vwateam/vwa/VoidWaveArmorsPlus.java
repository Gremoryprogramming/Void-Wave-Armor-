package com.vwateam.vwa;

import com.vwateam.vwa.core.Init;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.vwateam.vwa.core.Init.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VoidWaveArmorsPlus.MOD_ID)
@Mod.EventBusSubscriber(modid =VoidWaveArmorsPlus.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD)
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
        TILE_ENTITY_TYPE.register(bus);
        BLOCKS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


    }
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(ItemGroup.TAB_DECORATIONS))
                    .setRegistryName(block.getRegistryName()));
        });
    }
}

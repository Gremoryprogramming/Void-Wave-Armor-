package com.vwateam.vwa.core;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.vwateam.vwa.VoidWaveArmorsPlus.MOD_ID;

public class Init{
    // ITEM INIT
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create( ForgeRegistries.ITEMS, MOD_ID );

    // BLOCK INIT
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create( ForgeRegistries.BLOCKS, MOD_ID );

    public static final RegistryObject<Block> VOID_WAVE_BLOCK = BLOCKS.register("void_wave_block",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(5f, 6f)));

}

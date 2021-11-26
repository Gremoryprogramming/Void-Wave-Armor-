package com.vwateam.vwa.core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.vwateam.vwa.VoidWaveArmorsPlus.MOD_ID;

public class Init{
    // ITEM INIT
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create( ForgeRegistries.ITEMS, MOD_ID );

    // BLOCK INIT
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create( ForgeRegistries.BLOCKS, MOD_ID );

}

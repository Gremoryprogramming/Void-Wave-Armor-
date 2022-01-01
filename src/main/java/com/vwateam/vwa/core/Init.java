package com.vwateam.vwa.core;

import com.vwateam.vwa.VoidWaveArmorsPlus;
import com.vwateam.vwa.common.block.VoidWaveBlock;
import com.vwateam.vwa.common.te.VoidWaveBlockTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.vwateam.vwa.VoidWaveArmorsPlus.MOD_ID;

public class Init{
    // ITEM INIT
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create( ForgeRegistries.ITEMS, MOD_ID );

    public static final RegistryObject<Item> WAVE_CRYSTAL = ITEMS.register("wave_crystal",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    // BLOCK INIT
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create( ForgeRegistries.BLOCKS, MOD_ID );

    public static final RegistryObject<Block> VOID_WAVE_BLOCK = BLOCKS.register("void_wave_block", () -> new VoidWaveBlock());

    //TILE ENTITY TYPES INIT
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister
            .create(ForgeRegistries.TILE_ENTITIES, VoidWaveArmorsPlus.MOD_ID);

    public static final RegistryObject<TileEntityType<VoidWaveBlockTileEntity>> VOID_WAVE_BLOCK_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
            .register("void_wave_block", () -> TileEntityType.Builder.of(VoidWaveBlockTileEntity::new, Init.VOID_WAVE_BLOCK.get()).build(null));

}

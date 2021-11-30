package com.vwateam.vwa.common.block;

import com.vwateam.vwa.core.Init;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class VoidWaveBlock extends Block {

    public VoidWaveBlock() {
        super(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(15).sound(SoundType.METAL));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return Init.VOID_WAVE_BLOCK_TILE_ENTITY_TYPE.get().create();
    }
}

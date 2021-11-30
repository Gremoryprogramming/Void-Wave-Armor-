package com.vwateam.vwa.common.te;

import com.vwateam.vwa.common.block.VoidWaveBlock;
import com.vwateam.vwa.core.Init;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class VoidWaveBlockTileEntity extends TileEntity implements ITickableTileEntity {

    public VoidWaveBlockTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public VoidWaveBlockTileEntity() {
        this(Init.VOID_WAVE_BLOCK_TILE_ENTITY_TYPE.get());

    }

    @Override
    public void tick() {

    }
}

package com.vwateam.vwa.common.te;

import com.vwateam.vwa.core.Init;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class VoidWaveBlockTileEntity extends LockableTileEntity {

    public VoidWaveBlockTileEntity() {
        this(Init.VOID_WAVE_BLOCK_TILE_ENTITY_TYPE.get());

    }

    @Override
    public void tick() {

    }
    protected VoidWaveBlockTileEntity(TileEntityType<?> typeIn){
            super(typeIn);
    }
}

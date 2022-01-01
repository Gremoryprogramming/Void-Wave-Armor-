package com.vwateam.vwa.common.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

public class VoidWaveBlock extends Block {
    public static final BooleanProperty BLOCKSTATE_CHANGE = BooleanProperty.create("blockstate");
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

    public VoidWaveBlock() {
        super(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(15).sound(SoundType.METAL));
        registerDefaultState(this.defaultBlockState().setValue(BLOCKSTATE_CHANGE, false).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, BLOCKSTATE_CHANGE);
        super.createBlockStateDefinition(builder);
    }


    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

}

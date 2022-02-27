package com.vwateam.vwa.common.block;

import com.vwateam.vwa.common.te.VoidWaveBlockTileEntity;
import com.vwateam.vwa.core.Init;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class VoidWaveBlock extends Block {
    public static final IntegerProperty WAVE_CRYSTAL_LEVEL = IntegerProperty.create( "wave_crystal_level", 0, 4);
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

    public VoidWaveBlock() {
        super(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(15).sound(SoundType.METAL));
        registerDefaultState(this.defaultBlockState().setValue(WAVE_CRYSTAL_LEVEL, 0).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, WAVE_CRYSTAL_LEVEL);
        super.createBlockStateDefinition(builder);
    }


    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        if (pPlayer.getItemInHand(pHand).getItem() == Init.WAVE_CRYSTAL.get() && pState.getValue(WAVE_CRYSTAL_LEVEL) < 4) {
            pPlayer.getItemInHand(pHand).shrink(1);
            pLevel.setBlockAndUpdate(pPos, pState.setValue(WAVE_CRYSTAL_LEVEL, pState.getValue(WAVE_CRYSTAL_LEVEL) + 1));
            return ActionResultType.SUCCESS;
        }
            if (!pLevel.isClientSide()) {
                TileEntity te = pLevel.getBlockEntity(pPos);
                if (te instanceof VoidWaveBlockTileEntity) {
                    NetworkHooks.openGui((ServerPlayerEntity) pPlayer, (INamedContainerProvider) te, pPos);
            }
        }
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }

    }


package com.teamabode.cave_enhancements.common.block;

import com.teamabode.cave_enhancements.common.block.entity.LightningAnchorBlockEntity;
import com.teamabode.cave_enhancements.core.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
public class LightningAnchorBlock extends BaseEntityBlock {
    public LightningAnchorBlock(Properties settings){
        super(settings);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LightningAnchorBlockEntity(pos, state);
    }

    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.LIGHTNING_ANCHOR.get(), (world1, pos, state1, entity) -> LightningAnchorBlockEntity.tick(world1, pos, entity));
    }

    public @NotNull PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.IGNORE;
    }
}

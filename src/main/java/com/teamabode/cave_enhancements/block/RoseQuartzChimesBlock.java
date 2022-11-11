package com.teamabode.cave_enhancements.block;

import com.teamabode.cave_enhancements.block.entity.RoseQuartzChimesBlockEntity;
import com.teamabode.cave_enhancements.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SuppressWarnings("deprecation")
public class RoseQuartzChimesBlock extends BaseEntityBlock {

    public RoseQuartzChimesBlock (Properties properties){
        super(properties);
    }

    public static final VoxelShape COLLISION_SHAPE;
    public static final VoxelShape RAYCAST_SHAPE;

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RoseQuartzChimesBlockEntity(pos, state);
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter world, BlockPos pos) {
        return super.propagatesSkylightDown(state, world, pos);
    }

    public VoxelShape getInteractionShape(BlockState state, BlockGetter world, BlockPos pos) {
        return RAYCAST_SHAPE;
    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return COLLISION_SHAPE;
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.ROSE_QUARTZ_CHIMES.get(), (world1, pos, state1, entity) -> RoseQuartzChimesBlockEntity.tick(world1, pos, entity));
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return Block.canSupportCenter(world, pos.above(), Direction.DOWN) || world.getBlockState(pos.above()).is(BlockTags.LEAVES);
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.UP && !this.canSurvive(state, world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    static {
        COLLISION_SHAPE = box(0,12,0,16,16,16);
        RAYCAST_SHAPE = box(0,0,0,16,16,16);
    }
}

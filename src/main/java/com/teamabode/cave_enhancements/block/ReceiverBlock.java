package com.teamabode.cave_enhancements.block;

import com.teamabode.cave_enhancements.block.entity.ReceiverBlockEntity;
import com.teamabode.cave_enhancements.registry.ModBlocks;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.extensions.IForgeBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ReceiverBlock extends DiodeBlock implements EntityBlock, IForgeBlock {
    public static final BooleanProperty CAN_PASS = BooleanProperty.create("can_pass");
    public WeatheringCopper.WeatherState oxidationLevel;

    public ReceiverBlock(WeatheringCopper.WeatherState oxidationLevel, Properties settings) {
        super(settings);
        this.oxidationLevel = oxidationLevel;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, false).setValue(CAN_PASS, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, CAN_PASS, POWERED);
    }

    protected boolean isAlternateInput(@NotNull BlockState state) {
        return isDiode(state);
    }

    protected int getOutputSignal(@NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull BlockState state) {
        return 15;
    }

    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if (state.getValue(POWERED)) {
            Direction direction = state.getValue(FACING);
            double d = (double)pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D;
            double e = (double)pos.getY() + 0.4D + (random.nextDouble() - 0.5D) * 0.2D;
            double f = (double)pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D;
            float g = -5.0F;
            if (random.nextBoolean()) {
                g = (float)(4 * 2 - 1);
            }

            g /= 16.0F;
            double h = g * (float)direction.getStepX();
            double i = g * (float)direction.getStepZ();
            world.addParticle(DustParticleOptions.REDSTONE, d + h, e, f + i, 0.0D, 0.0D, 0.0D);
        }
    }


    protected int getInputSignal(Level level, BlockPos pos, BlockState state) {
        int i = super.getInputSignal(level, pos, state);
        Direction direction = state.getValue(FACING);
        BlockPos blockPos = pos.relative(direction);
        BlockState blockState = level.getBlockState(blockPos);
        if (blockState.hasAnalogOutputSignal()) {
            i = blockState.getAnalogOutputSignal(level, blockPos);
        } else if (i < 15 && blockState.isRedstoneConductor(level, blockPos)) {
            blockPos = blockPos.relative(direction);
            blockState = level.getBlockState(blockPos);
            int j = Math.max(Integer.MIN_VALUE, blockState.hasAnalogOutputSignal() ? blockState.getAnalogOutputSignal(level, blockPos) : Integer.MIN_VALUE);
            if (j != Integer.MIN_VALUE) {
                i = j;
            }
        }
        return i;
    }

    public int getSignal(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
        if (!state.getValue(CAN_PASS)) {
            return 0;
        } else {
            return state.getValue(FACING) == direction ? getOutputSignal(world, pos, state) : 0;
        }
    }

    public boolean isSignalSource(BlockState state) {
        return state.getValue(CAN_PASS);
    }

    protected int getDelay(BlockState state) {
        return 0;
    }

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState blockState = super.getStateForPlacement(ctx);
        assert blockState != null;
        return blockState.setValue(CAN_PASS, false).setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    public int getMaxPower() {
        return switch (this.oxidationLevel) {
            case UNAFFECTED -> 2;
            case EXPOSED -> 5;
            case WEATHERED -> 10;
            case OXIDIZED -> 20;
        };
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        Direction facing = state.getValue(ReceiverBlock.FACING);
        return facing == direction || facing.getOpposite() == direction;
    }

    // Block Entity
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ReceiverBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemStack = player.getItemInHand(hand);
        Item item = player.getItemInHand(hand).getItem();
        if (item instanceof AxeItem) {
            level.levelEvent(3004, pos, 0);
            level.playSound(null, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);

            switch (this.oxidationLevel) {
                case UNAFFECTED -> {
                    level.setBlock(pos, ModBlocks.REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
                    return InteractionResult.SUCCESS;
                }
                case EXPOSED -> {
                    level.setBlock(pos, ModBlocks.EXPOSED_REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
                    return InteractionResult.SUCCESS;
                }
                case WEATHERED -> {
                    level.setBlock(pos, ModBlocks.WEATHERED_REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
                    return InteractionResult.SUCCESS;
                }
                case OXIDIZED -> {
                    level.setBlock(pos, ModBlocks.OXIDIZED_REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
                    return InteractionResult.SUCCESS;
                }
            }

        }
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if (blockEntity instanceof ReceiverBlockEntity) {
                ((ReceiverBlockEntity) blockEntity).tick(world1, pos, state1);
            }
        };
    }
}

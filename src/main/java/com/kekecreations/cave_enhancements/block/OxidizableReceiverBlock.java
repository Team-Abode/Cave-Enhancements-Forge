package com.kekecreations.cave_enhancements.block;

import com.kekecreations.cave_enhancements.registry.ModBlocks;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class OxidizableReceiverBlock extends ReceiverBlock implements WeatheringCopper {
    public OxidizableReceiverBlock(WeatherState oxidationLevel, Properties settings) {
        super(oxidationLevel, settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, false).setValue(CAN_PASS, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, CAN_PASS, POWERED);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        this.onRandomTick(state, world, pos, random);
    }

    @Override
    public void onRandomTick(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        if (randomSource.nextFloat() < 0.1F) {
            switch (this.oxidationLevel) {
                case UNAFFECTED -> level.setBlock(pos, ModBlocks.EXPOSED_REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
                case EXPOSED -> level.setBlock(pos, ModBlocks.WEATHERED_REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
                case WEATHERED -> level.setBlock(pos, ModBlocks.OXIDIZED_REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
            }
        }
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = player.getItemInHand(hand).getItem();
        if (item instanceof AxeItem) {
            if (this.oxidationLevel == WeatherState.UNAFFECTED) {
                return InteractionResult.FAIL;
            }
            level.levelEvent(3005, pos, 0);
            level.playSound(null, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);

            switch (this.oxidationLevel) {
                case EXPOSED -> {
                    level.setBlock(pos, ModBlocks.REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
                    return InteractionResult.SUCCESS;
                }
                case WEATHERED -> {
                    level.setBlock(pos, ModBlocks.EXPOSED_REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
                    return InteractionResult.SUCCESS;
                }
                case OXIDIZED -> {
                    level.setBlock(pos, ModBlocks.WEATHERED_REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
                    return InteractionResult.SUCCESS;
                }
            }
        } else if (item instanceof HoneycombItem) {
            level.levelEvent(3004, pos, 0);
            level.playSound(null, pos, SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1.0F, 1.0F);

            switch (this.oxidationLevel) {
                case UNAFFECTED -> {
                    level.setBlock(pos, ModBlocks.WAXED_REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
                    return InteractionResult.SUCCESS;
                }
                case EXPOSED -> {
                    level.setBlock(pos, ModBlocks.WAXED_EXPOSED_REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
                    return InteractionResult.SUCCESS;
                }
                case WEATHERED -> {
                    level.setBlock(pos, ModBlocks.WAXED_WEATHERED_REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
                    return InteractionResult.SUCCESS;
                }
                case OXIDIZED -> {
                    level.setBlock(pos, ModBlocks.WAXED_OXIDIZED_REDSTONE_RECEIVER.get().withPropertiesOf(blockState), 3);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        //return WeatheringCopper.getNext(state.getBlock()).isPresent();
        return true;
    }

    @Override
    public WeatherState getAge() {
        return this.oxidationLevel;
    }
}

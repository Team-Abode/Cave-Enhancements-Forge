package com.kekecreations.cave_enhancements.dispenser;

import com.kekecreations.cave_enhancements.block.VolatileGoopBlock;
import com.kekecreations.cave_enhancements.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;

public interface VolatileGoopDispenseBehavior extends DispenseItemBehavior {

    static void register() {
        DispenserBlock.registerBehavior(ModBlocks.VOLATILE_GOOP.get(), new OptionalDispenseItemBehavior() {
            protected ItemStack execute(BlockSource source, ItemStack stack) {
                this.setSuccess(true);
                Level level = source.getLevel();
                Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
                BlockPos blockPos = source.getPos().relative(direction);

                if (level.getBlockState(blockPos).isAir()) {
                    level.setBlockAndUpdate(blockPos, ModBlocks.VOLATILE_GOOP.get().defaultBlockState().setValue(VolatileGoopBlock.FACING, direction));
                    level.gameEvent(null, GameEvent.BLOCK_PLACE, blockPos);
                } else {
                    this.setSuccess(false);
                }
                return stack;
            }
        });
    }
}

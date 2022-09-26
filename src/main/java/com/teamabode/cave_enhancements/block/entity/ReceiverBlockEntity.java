package com.teamabode.cave_enhancements.block.entity;

import com.teamabode.cave_enhancements.block.ReceiverBlock;
import com.teamabode.cave_enhancements.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ReceiverBlockEntity extends BlockEntity {

    public int poweredTicks = 0;

    public ReceiverBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RECEIVER.get(), pos, state);
    }

    public void tick(Level world, BlockPos pos, BlockState state) {
        ReceiverBlock block = (ReceiverBlock) state.getBlock();
        int maxPower = block.getMaxPower();

        if (state.getValue(ReceiverBlock.POWERED)) {
            this.poweredTicks++;
        } else {
            world.setBlockAndUpdate(pos, state.setValue(ReceiverBlock.CAN_PASS, false));
            poweredTicks = 0;
        }
        if (poweredTicks == maxPower) {
            world.setBlockAndUpdate(pos, state.setValue(ReceiverBlock.CAN_PASS, true));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.putInt("PoweredTicks", this.poweredTicks);
        this.setChanged();
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        this.poweredTicks = nbt.getInt("PoweredTicks");
        super.load(nbt);
    }



}

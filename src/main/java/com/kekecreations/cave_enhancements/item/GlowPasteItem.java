package com.kekecreations.cave_enhancements.item;

import com.kekecreations.cave_enhancements.registry.ModBlocks;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.extensions.IForgeItem;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Properties;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GlowPasteItem extends BlockItem implements IForgeItem {
    public GlowPasteItem(Properties settings) {
        super(ModBlocks.GLOW_SPLOTCH.get(), settings);
    }


    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return false;
    }

    @Override
    public InteractionResult place(BlockPlaceContext blockPlaceContext) {
        if (!blockPlaceContext.canPlace()) {
            return InteractionResult.FAIL;
        } else {
            BlockPlaceContext blockPlaceContext2 = this.updatePlacementContext(blockPlaceContext);
            if (blockPlaceContext2 == null) {
                return InteractionResult.FAIL;
            } else {
                BlockState blockState = this.getPlacementState(blockPlaceContext2);
                if (blockState == null) {
                    return InteractionResult.FAIL;
                } else if (!this.placeBlock(blockPlaceContext2, blockState)) {
                    return InteractionResult.FAIL;
                } else {
                    BlockPos blockPos = blockPlaceContext2.getClickedPos();
                    Level level = blockPlaceContext2.getLevel();
                    Player player = blockPlaceContext2.getPlayer();
                    ItemStack itemStack = blockPlaceContext2.getItemInHand();
                    BlockState blockState2 = level.getBlockState(blockPos);
                    if (blockState2.is(blockState.getBlock())) {
                        blockState2.getBlock().setPlacedBy(level, blockPos, blockState2, player, itemStack);
                        if (player instanceof ServerPlayer) {
                            CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, blockPos, itemStack);
                        }
                    }

                    SoundType soundType = blockState2.getSoundType();
                    level.playSound(player, blockPos, this.getPlaceSound(blockState2), SoundSource.BLOCKS, (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);
                    level.gameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.of(player, blockState2));
                    if (player == null || !player.getAbilities().instabuild) {
                        itemStack.hurtAndBreak(1, player, (playerx) -> playerx.broadcastBreakEvent(blockPlaceContext.getHand()));
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }

        }
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }
}

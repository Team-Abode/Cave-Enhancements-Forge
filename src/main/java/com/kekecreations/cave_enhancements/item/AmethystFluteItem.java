package com.kekecreations.cave_enhancements.item;

import com.kekecreations.cave_enhancements.entity.dripstone_tortoise.DripstoneTortoise;
import com.kekecreations.cave_enhancements.registry.ModParticles;
import com.kekecreations.cave_enhancements.registry.ModTags;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
public class AmethystFluteItem extends Item {
    private static final long fearDuration = 40L;
    public AmethystFluteItem(Item.Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        double x = user.getX();
        double y = user.getY();
        double z = user.getZ();
        BlockPos pos = new BlockPos(x, y, z);

        world.playSound(null, pos, SoundEvents.NOTE_BLOCK_FLUTE, SoundSource.PLAYERS, 1.0F, 1.0F);
        user.level.getEntities(user, user.getBoundingBox().inflate(10D)).forEach(entity -> {

            if (!world.isClientSide()) {
                if (entity instanceof Mob mob) {

                    if (!mob.getType().is(ModTags.AMETHYST_FLUTE_IMMUNE)) {
                        if (mob instanceof NeutralMob neutralMob) {
                            neutralMob.stopBeingAngry();
                        }
                    }

                    if (mob instanceof Vex) {
                        mob.kill();
                    }

                    if (mob instanceof Ravager ravager) {
                        ravager.handleEntityEvent((byte)39);
                        ravager.playSound(SoundEvents.RAVAGER_STUNNED, 1.0F, 1.0F);
                        world.broadcastEntityEvent(ravager, (byte)39);
                    }
                }
            }

            if (world.isClientSide()) {
                world.addParticle(ModParticles.SOOTHING_NOTE.get(), x, y + 1.0D, z, 0, 0.2, 0);
                if (entity instanceof Mob mob) {
                    if (!mob.getType().is(ModTags.AMETHYST_FLUTE_IMMUNE) || entity instanceof Vex || entity instanceof Ravager) {
                        world.addParticle(ModParticles.SOOTHING_NOTE.get(), mob.getX(), mob.getY() + 1.0D, mob.getZ(), 0, 0.2, 0);
                    }
                }
            }

        });

        CompoundTag nbt = itemStack.getOrCreateTag();
        nbt.putLong("AmethystFluteScary", world.getGameTime());
        itemStack.setTag(nbt);

        itemStack.hurtAndBreak(1, user, (player) -> player.broadcastBreakEvent(hand));
        user.gameEvent(GameEvent.INSTRUMENT_PLAY);
        user.getCooldowns().addCooldown(this, 400);

        return InteractionResultHolder.success(itemStack);
    }



    @ParametersAreNonnullByDefault
    public static boolean isScary(LivingEntity livingEntity) {
        long scaryTime = 0L;
        if (livingEntity.getMainHandItem().getItem() instanceof AmethystFluteItem) {
            scaryTime = livingEntity.getMainHandItem().getOrCreateTag().getLong("AmethystFluteScary");
        }
        if (livingEntity.getOffhandItem().getItem() instanceof AmethystFluteItem) {
            scaryTime = Math.max(scaryTime, livingEntity.getOffhandItem().getOrCreateTag().getLong("AmethystFluteScary"));
        }
        return scaryTime != 0L && livingEntity.level.getGameTime() - scaryTime <= fearDuration;
    }
}

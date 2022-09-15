package com.kekecreations.cave_enhancements.block.entity;

import java.util.List;

import com.kekecreations.cave_enhancements.registry.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class RoseQuartzChimesBlockEntity extends BlockEntity {

    public int ticks;

    public RoseQuartzChimesBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ROSE_QUARTZ_CHIMES.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, RoseQuartzChimesBlockEntity entity) {
        entity.ticks++;


        AABB box = new AABB(pos).inflate(8);

        List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class, box, (e) -> true);

        LivingEntity otherEntity;
        for (LivingEntity livingEntity : list) {
            otherEntity = livingEntity;

            long timeToChime = level.isRaining() ? 400L : 800L;

            if (level.getGameTime() % timeToChime == 0) {

                applyEffects(level, otherEntity, otherEntity instanceof Monster ? MobEffects.WEAKNESS : MobEffects.REGENERATION);
                level.addParticle(ModParticles.ROSE_CHIMES.get(), entity.getBlockPos().getX() + 0.5D, entity.getBlockPos().getY() + 0.3D, entity.getBlockPos().getZ() + 0.5D, 0D, 0D, 0D);
                level.playSound(null, pos, ModSounds.BLOCK_ROSE_QUARTZ_CHIMES_CHIME.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
            }
        }
    }

    private static void applyEffects(Level level, LivingEntity livingEntity, MobEffect effect) {
        livingEntity.addEffect(new MobEffectInstance(effect, 100, level.isRaining() ? 1 : 0, false, true));
    }
}

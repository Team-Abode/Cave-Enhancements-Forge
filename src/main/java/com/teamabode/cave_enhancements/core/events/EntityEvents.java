package com.teamabode.cave_enhancements.core.events;

import com.teamabnormals.blueprint.common.world.storage.tracking.IDataManager;
import com.teamabode.cave_enhancements.CaveEnhancements;
import com.teamabode.cave_enhancements.common.item.AmethystFluteItem;
import com.teamabode.cave_enhancements.core.registry.ModEffects;
import com.teamabode.cave_enhancements.core.registry.ModSounds;
import com.teamabode.cave_enhancements.core.registry.ModTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CaveEnhancements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EntityEvents {


    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        if ( entity instanceof PathfinderMob mob && (mob instanceof Monster || mob instanceof NeutralMob ) && !mob.getType().is(ModTags.AMETHYST_FLUTE_IMMUNE) )  {
            mob.goalSelector.addGoal(0, new AvoidEntityGoal<>(mob, Player.class, 16.0F, 1.0D, 1.0D, AmethystFluteItem::isScary));

        }
    }

    @SubscribeEvent
    public static void onEntityHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        LivingEntity entity = event.getEntity();
        Entity attacker = source.getDirectEntity();
        IDataManager dataManager = (IDataManager) entity;
        IDataManager attackerDataManager = (IDataManager) attacker;
        float hurtAmount = event.getAmount();

        if (attacker instanceof LivingEntity livingAttacker &&
        livingAttacker.hasEffect(ModEffects.REVERSAL.get()) &&
        attackerDataManager.getValue(CaveEnhancements.REVERSAL_DAMAGE) > 0)
        {
            livingAttacker.level.playSound(null, livingAttacker.blockPosition(), ModSounds.EFFECT_REVERSAL_REVERSE.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
            attackerDataManager.setValue(CaveEnhancements.REVERSAL_DAMAGE, 0);
        }

        if (hurtAmount > 0 && entity.hasEffect(ModEffects.REVERSAL.get())) {
            if (entity.getRandom().nextFloat() < (hurtAmount / 5) ) {
                dataManager.setValue(CaveEnhancements.REVERSAL_DAMAGE, Math.min(dataManager.getValue(CaveEnhancements.REVERSAL_DAMAGE) + 1, 5));
            }
        }
    }
}

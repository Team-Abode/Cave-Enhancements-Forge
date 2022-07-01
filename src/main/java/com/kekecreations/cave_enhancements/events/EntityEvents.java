package com.kekecreations.cave_enhancements.events;


import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.entity.ai.goal.FleeTheFluteGoal;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CaveEnhancements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EntityEvents {

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Creeper creeper) {
            creeper.goalSelector.addGoal(1, new FleeTheFluteGoal<>(creeper, EntitySelector.NO_CREATIVE_OR_SPECTATOR, 8.0F, 1.25D, 1.25D));
        }

    }
}

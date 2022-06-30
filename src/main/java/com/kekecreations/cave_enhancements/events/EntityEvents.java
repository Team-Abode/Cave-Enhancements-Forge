package com.kekecreations.cave_enhancements.events;


import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.entity.Cruncher;
import com.kekecreations.cave_enhancements.entity.DripstonePike;
import com.kekecreations.cave_enhancements.entity.DripstoneTortoise;
import com.kekecreations.cave_enhancements.entity.Goop;
import com.kekecreations.cave_enhancements.registry.ModEntities;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CaveEnhancements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityEvents {

    @SubscribeEvent
    public static void appendAttributes(EntityAttributeCreationEvent event) {

        SpawnPlacements.register(ModEntities.CRUNCHER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Cruncher::checkCruncherSpawnRules);
        SpawnPlacements.register(ModEntities.DRIPSTONE_TORTOISE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, DripstoneTortoise::checkDripstoneTortoiseSpawnRules);

        event.put(ModEntities.GOOP.get(), Goop.createGoopAttributes().build());
        event.put(ModEntities.DRIPSTONE_TORTOISE.get(), DripstoneTortoise.createDripstoneTortoiseAttributes().build());
        event.put(ModEntities.DRIPSTONE_PIKE.get(), DripstonePike.createDripstonePikeAttributes().build());
        event.put(ModEntities.CRUNCHER.get(), Cruncher.createCruncherAttributes().build());
    }
}

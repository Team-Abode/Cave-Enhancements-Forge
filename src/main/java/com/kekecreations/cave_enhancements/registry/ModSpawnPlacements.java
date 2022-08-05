package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.entity.cruncher.Cruncher;
import com.kekecreations.cave_enhancements.entity.dripstone_tortoise.DripstoneTortoise;
import com.kekecreations.cave_enhancements.entity.goop.Goop;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

public class ModSpawnPlacements {

    public static void register() {
        SpawnPlacements.register(ModEntities.CRUNCHER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Cruncher::checkCruncherSpawnRules);
        SpawnPlacements.register(ModEntities.DRIPSTONE_TORTOISE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, DripstoneTortoise::checkDripstoneTortoiseSpawnRules);
        SpawnPlacements.register(ModEntities.GOOP.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, (entityType, levelAccessor, mobSpawnType, blockPos, randomSource) -> Goop.checkGoopSpawnRules(levelAccessor, blockPos));
    }
}

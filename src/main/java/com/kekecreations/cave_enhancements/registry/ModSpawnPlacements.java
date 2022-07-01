package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.entity.Cruncher;
import com.kekecreations.cave_enhancements.entity.DripstoneTortoise;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

public class ModSpawnPlacements {

    public static void register() {
        SpawnPlacements.register(ModEntities.CRUNCHER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Cruncher::checkCruncherSpawnRules);
        SpawnPlacements.register(ModEntities.DRIPSTONE_TORTOISE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, DripstoneTortoise::checkDripstoneTortoiseSpawnRules);
    }
}

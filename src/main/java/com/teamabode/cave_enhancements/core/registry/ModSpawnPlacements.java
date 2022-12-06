package com.teamabode.cave_enhancements.core.registry;

import com.teamabode.cave_enhancements.common.entity.cruncher.Cruncher;
import com.teamabode.cave_enhancements.common.entity.dripstone_tortoise.DripstoneTortoise;
import com.teamabode.cave_enhancements.common.entity.goop.Goop;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

public class ModSpawnPlacements {

    public static void register() {
        SpawnPlacements.register(ModEntities.CRUNCHER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Cruncher::checkCruncherSpawnRules);
        SpawnPlacements.register(ModEntities.DRIPSTONE_TORTOISE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, DripstoneTortoise::checkDripstoneTortoiseSpawnRules);
        SpawnPlacements.register(ModEntities.GOOP.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, Goop::checkGoopSpawnRules);
    }
}

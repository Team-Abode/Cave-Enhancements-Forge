package com.teamabode.cave_enhancements.world;

import com.teamabode.cave_enhancements.registry.ModBiomeModifiers;
import com.teamabode.cave_enhancements.registry.ModEntities;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public class MobSpawners implements BiomeModifier {
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD) {
            if (biome.is(Biomes.LUSH_CAVES)) {
                builder.getMobSpawnSettings().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.CRUNCHER.get(), 10, 1, 1));
            } else if (biome.is(Biomes.DRIPSTONE_CAVES)) {
                builder.getMobSpawnSettings().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.DRIPSTONE_TORTOISE.get(), 50, 1, 1));
            }

        }
    }

    public Codec<? extends BiomeModifier> codec() {
        return ModBiomeModifiers.MOB_SPAWNERS.get();
    }
}

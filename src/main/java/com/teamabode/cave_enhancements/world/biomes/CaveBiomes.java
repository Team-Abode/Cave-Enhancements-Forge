package com.teamabode.cave_enhancements.world.biomes;

import com.teamabode.cave_enhancements.registry.ModEntities;
import com.teamabode.cave_enhancements.registry.ModFeatures;
import com.teamabode.cave_enhancements.registry.ModSounds;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.sounds.Musics;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class CaveBiomes {

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    private static void goopCavesFeatures(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModFeatures.ModPlacedFeatures.GOOP_SPLAT.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModFeatures.ModPlacedFeatures.FLOOR_GOOP_PATCH.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModFeatures.ModPlacedFeatures.CEILING_GOOP_PATCH.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModFeatures.ModPlacedFeatures.GOOP_STRAND.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModFeatures.ModPlacedFeatures.DRIPPING_GOOP.getHolder().get());
    }

    private static void roseQuartzFeatures(BiomeGenerationSettings.Builder builder) {
        builder.addCarver(GenerationStep.Carving.LIQUID, Carvers.CAVE);
        builder.addCarver(GenerationStep.Carving.LIQUID, Carvers.CAVE_EXTRA_UNDERGROUND);
        builder.addCarver(GenerationStep.Carving.LIQUID, Carvers.CANYON);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
    }

    // Goop Caves
    public static Biome goopCaves() {

        // Mob Spawns
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnSettings);
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(ModEntities.GOOP.get(), 50, 1, 1));

        // Features
        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder();
        globalOverworldGeneration(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        goopCavesFeatures(genBuilder);

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.RAIN)
                .temperature(0.5F)
                .downfall(0.5F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x3F76E4).waterFogColor(0x50533).fogColor(0x878787).skyColor(0xC0D8FF).backgroundMusic(Musics.createGameMusic(ModSounds.MUSIC_BIOME_GOOP_CAVES.get())).build())
                .mobSpawnSettings(spawnSettings.build()).generationSettings(genBuilder.build())
                .build();
    }

    // Rose Quartz Caves
    public static Biome roseQuartzCaves() {

        // Mob Spawns
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 50, 4, 6));

        // Features
        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder();
        roseQuartzFeatures(genBuilder);

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.RAIN)
                .temperature(0.9F)
                .downfall(0.6F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x6BC0FF).waterFogColor(0x6BC0FF).fogColor(0xC0D8FF).skyColor(0x9084415).backgroundMusic(Musics.createGameMusic(ModSounds.MUSIC_BIOME_ROSE_QUARTZ_CAVES.get())).build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }
}

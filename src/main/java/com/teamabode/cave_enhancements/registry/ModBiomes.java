package com.teamabode.cave_enhancements.registry;

import com.teamabode.cave_enhancements.CaveEnhancements;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Musics;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBiomes {

    public static void register(IEventBus bus) {
        BIOMES.register(bus);
    }

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, CaveEnhancements.MOD_ID);

    public static final RegistryObject<Biome> GOOP_CAVES = BIOMES.register("goop_caves", ModBiomes::goopCaves);
    public static final RegistryObject<Biome> ROSE_QUARTZ_CAVES = BIOMES.register("rose_quartz_caves", ModBiomes::roseQuartzCaves);

    // Goop Caves
    public static Biome goopCaves() {
        // Spawn Settings
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnSettings);

        // Feature Settings
        BiomeGenerationSettings.Builder featureSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addPlainGrass(featureSettings);
        BiomeDefaultFeatures.addDefaultOres(featureSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(featureSettings);



        // Biome Builder
        return (new Biome.BiomeBuilder())
                .precipitation(Biome.Precipitation.RAIN)
                .temperature(0.5F)
                .downfall(0.5F)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3F76E4)
                        .waterFogColor(0x50533)
                        .fogColor(0x878787)
                        .skyColor(0xC0D8FF)
                        .backgroundMusic(Musics.GAME)
                        .build())
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(featureSettings.build())
                .build();

    }

    // Rose Quartz Caves
    public static Biome roseQuartzCaves() {
        // Spawn Settings
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnSettings);

        // Feature Settings
        BiomeGenerationSettings.Builder featureSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addPlainGrass(featureSettings);
        BiomeDefaultFeatures.addDefaultOres(featureSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(featureSettings);

        return (new Biome.BiomeBuilder())
                .precipitation(Biome.Precipitation.RAIN)
                .temperature(0.9F)
                .downfall(0.6F)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x6BC0FF)
                        .waterFogColor(0x6BC0FF)
                        .fogColor(0xC0D8FF)
                        .skyColor(0x9084415)
                        .backgroundMusic(Musics.GAME)
                        .build())
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(featureSettings.build())
                .build();
    }

}

package com.teamabode.cave_enhancements.core.registry;

import com.teamabode.cave_enhancements.CaveEnhancements;
import com.teamabode.cave_enhancements.common.world.biomes.CaveBiomes;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBiomes {

    public static void register(IEventBus bus) {
        BIOMES.register(bus);
    }

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, CaveEnhancements.MOD_ID);

    public static final RegistryObject<Biome> GOOP_CAVES = BIOMES.register("goop_caves", CaveBiomes::goopCaves);
    public static final RegistryObject<Biome> ROSE_QUARTZ_CAVES = BIOMES.register("rose_quartz_caves", CaveBiomes::roseQuartzCaves);


}

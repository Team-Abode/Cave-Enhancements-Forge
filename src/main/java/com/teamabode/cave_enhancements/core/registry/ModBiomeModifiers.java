package com.teamabode.cave_enhancements.core.registry;

import com.teamabode.cave_enhancements.CaveEnhancements;
import com.teamabode.cave_enhancements.common.world.MobSpawners;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBiomeModifiers {

    public static DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIIFERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, CaveEnhancements.MOD_ID);

    public static final RegistryObject<Codec<? extends BiomeModifier>> MOB_SPAWNERS = BIOME_MODIIFERS.register("mob_spawners", () -> Codec.unit(MobSpawners::new));
}

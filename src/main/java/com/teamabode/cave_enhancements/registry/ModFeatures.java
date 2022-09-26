package com.teamabode.cave_enhancements.registry;

import com.google.common.collect.ImmutableList;
import com.teamabode.cave_enhancements.CaveEnhancements;
import com.teamabode.cave_enhancements.world.feature.TestFeature;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@Mod.EventBusSubscriber(modid = CaveEnhancements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CaveEnhancements.MOD_ID);


    public static final RegistryObject<Feature<NoneFeatureConfiguration>> TEST_FEATURE = FEATURES.register("test_feature", () -> new TestFeature(NoneFeatureConfiguration.CODEC));

    public static final class ConfiguredFeatures {

        public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, CaveEnhancements.MOD_ID);

        public static final RegistryObject<ConfiguredFeature<NoneFeatureConfiguration, ?>> TEST_FEATURE = CONFIGURED_FEATURES.register("test_feature", () -> new ConfiguredFeature<>(ModFeatures.TEST_FEATURE.get(), FeatureConfiguration.NONE));

    }

    public static final class PlacedFeatures {

        public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, CaveEnhancements.MOD_ID);

        public static final RegistryObject<PlacedFeature> TEST_FEATURE = register("test_feature", ConfiguredFeatures.TEST_FEATURE, List.of());

        @SuppressWarnings("unchecked")
        private static RegistryObject<PlacedFeature> register(String name, RegistryObject<? extends ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placementModifiers) {
            return PLACED_FEATURES.register(name, () -> new PlacedFeature((Holder<ConfiguredFeature<?, ?>>) feature.getHolder().get(), ImmutableList.copyOf(placementModifiers)));
        }
    }
}

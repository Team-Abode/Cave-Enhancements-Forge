package com.teamabode.cave_enhancements.registry;

import com.google.common.collect.ImmutableList;
import com.teamabode.cave_enhancements.CaveEnhancements;
import com.teamabode.cave_enhancements.block.DrippingGoopBlock;
import com.teamabode.cave_enhancements.world.feature.GoopStrandFeature;
import com.teamabode.cave_enhancements.world.feature.RoseQuartzCrystalConfiguration;
import com.teamabode.cave_enhancements.world.feature.RoseQuartzCrystalFeature;
import com.teamabode.cave_enhancements.world.feature.TestFeature;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@Mod.EventBusSubscriber(modid = CaveEnhancements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CaveEnhancements.MOD_ID);

    public static final Feature<RoseQuartzCrystalConfiguration> ROSE_QUARTZ_CRYSTAL = new RoseQuartzCrystalFeature();
    public static final Feature<NoneFeatureConfiguration> GOOP_STRAND = new GoopStrandFeature();


    public static final RegistryObject<Feature<NoneFeatureConfiguration>> TEST_FEATURE = FEATURES.register("test_feature", () -> new TestFeature(NoneFeatureConfiguration.CODEC));

    public static final class ConfiguredFeatures {

        public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, CaveEnhancements.MOD_ID);

        public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> NOTHING = new Holder.Direct<>(new ConfiguredFeature<>(Feature.NO_OP, new NoneFeatureConfiguration()));
        public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_GOOP = CONFIGURED_FEATURES.register("ore_goop", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), ModBlocks.GOOP_BLOCK.get().defaultBlockState(), 64)));
        public static final RegistryObject<ConfiguredFeature<?, ?>> GOOP_SPLAT = CONFIGURED_FEATURES.register("goop_splat", () -> new ConfiguredFeature<>(Feature.MULTIFACE_GROWTH, new MultifaceGrowthConfiguration((MultifaceBlock) ModBlocks.GOOP_SPLAT.get(), 35, false, true, true, 0.9F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.DRIPSTONE_BLOCK, Blocks.CALCITE, Blocks.TUFF, Blocks.DEEPSLATE))));
        public static final RegistryObject<ConfiguredFeature<?, ?>> FLOOR_GOOP_PATCH = CONFIGURED_FEATURES.register("floor_goop_patch", () -> new ConfiguredFeature<>(Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.BASE_STONE_OVERWORLD, BlockStateProvider.simple(ModBlocks.GOOP_BLOCK.get()), PlacementUtils.inlinePlaced(NOTHING), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 2, 0.05F, UniformInt.of(8, 10), 0.5F)));
        public static final RegistryObject<ConfiguredFeature<?, ?>> CEILING_GOOP_PATCH = CONFIGURED_FEATURES.register("ceiling_goop_patch", () -> new ConfiguredFeature<>(Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.BASE_STONE_OVERWORLD, BlockStateProvider.simple(ModBlocks.GOOP_BLOCK.get()), PlacementUtils.inlinePlaced(NOTHING), CaveSurface.CEILING, ConstantInt.of(1), 0.0F, 3, 0.05F, UniformInt.of(12, 14), 0.5F)));
        public static final RegistryObject<ConfiguredFeature<?, ?>> DRIPPING_GOOP = CONFIGURED_FEATURES.register("dripping_goop", () -> new ConfiguredFeature<>(Feature.BLOCK_COLUMN, new BlockColumnConfiguration( List.of(BlockColumnConfiguration.layer(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(UniformInt.of(6, 12), 1).add(UniformInt.of(2, 5), 1).add(UniformInt.of(8, 10), 2).build()), BlockStateProvider.simple(ModBlocks.DRIPPING_GOOP.get().defaultBlockState().setValue(DrippingGoopBlock.HANGING, false))), BlockColumnConfiguration.layer(ConstantInt.of(1), BlockStateProvider.simple(ModBlocks.DRIPPING_GOOP.get().defaultBlockState().setValue(DrippingGoopBlock.HANGING, true)))), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, true)));
        //public static final RegistryObject<ConfiguredFeature<NoneFeatureConfiguration, ?>> GOOP_STRAND = CONFIGURED_FEATURES.register("goop_strand", () -> new ConfiguredFeature<>(ModFeatures.GOOP_STRAND, new NoneFeatureConfiguration()));
        //public static final RegistryObject<ConfiguredFeature<RoseQuartzCrystalConfiguration, ?>> ROSE_QUARTZ_CRYSTALS = register("rose_quartz_crystals", () -> new ConfiguredFeature<>(ModFeatures.ROSE_QUARTZ_CRYSTAL, new RoseQuartzCrystalConfiguration(RoseQuartzCrystalFeature.RoseQuartzCrystalFormation.DIAGONAL_DOWN)));
        public static final RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_CALCITE = CONFIGURED_FEATURES.register("ore_calcite", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, Blocks.CALCITE.defaultBlockState(), 64, 1.0F)));
    }
    
    @SuppressWarnings("unchecked")
    public static final class ModPlacedFeatures {

        public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, CaveEnhancements.MOD_ID);

        public static final RegistryObject<PlacedFeature> ORE_GOOP = register("ore_goop", ConfiguredFeatures.ORE_GOOP, List.of(
                CountPlacement.of(60),
                InSquarePlacement.spread(),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                BiomeFilter.biome()
        ));
        public static final RegistryObject<PlacedFeature> GOOP_SPLAT = register("goop_splat", ConfiguredFeatures.GOOP_SPLAT, List.of(
                CountPlacement.of(UniformInt.of(104, 157)),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                InSquarePlacement.spread(),
                SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13),
                BiomeFilter.biome()
        ));
        public static final RegistryObject<PlacedFeature> FLOOR_GOOP_PATCH = register("floor_goop_patch", ConfiguredFeatures.FLOOR_GOOP_PATCH, List.of(
                CountPlacement.of(100),
                InSquarePlacement.spread(),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12),
                RandomOffsetPlacement.vertical(ConstantInt.of(1)),
                BiomeFilter.biome()
        ));
        public static final RegistryObject<PlacedFeature> CEILING_GOOP_PATCH = register("ceiling_goop_patch", ConfiguredFeatures.CEILING_GOOP_PATCH, List.of(
                CountPlacement.of(200),
                InSquarePlacement.spread(),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12),
                RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                BiomeFilter.biome()
        ));
        public static final RegistryObject<PlacedFeature> DRIPPING_GOOP = register("dripping_goop", ConfiguredFeatures.DRIPPING_GOOP, List.of(
                CountPlacement.of(200),
                InSquarePlacement.spread(),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12),
                RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                BiomeFilter.biome()
        ));
        /*public static final RegistryObject<PlacedFeature> GOOP_STRAND = register("goop_strand", ConfiguredFeatures.GOOP_STRAND, List.of(
                CountPlacement.of(70),
                InSquarePlacement.spread(),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12),
                BiomeFilter.biome()
        ));


        public static final RegistryObject<PlacedFeature> ROSE_QUARTZ_CRYSTALS = register("rose_quartz_crystals", ModConfiguredFeatures.ROSE_QUARTZ_CRYSTALS, List.of(
                CountPlacement.of(188),
                InSquarePlacement.spread(),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.matchesBlocks(Blocks.WATER), 12),
                RandomOffsetPlacement.vertical(ConstantInt.of(1)),
                BiomeFilter.biome()
        ));ç
         */


        public static final RegistryObject<PlacedFeature> ORE_CALCITE = register("ore_calcite", ConfiguredFeatures.ORE_CALCITE, List.of(
                CountPlacement.of(25),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.TOP),
                BiomeFilter.biome()
        ));


        private static RegistryObject<PlacedFeature> register(String name, RegistryObject<? extends ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placementModifiers) {
            return PLACED_FEATURES.register(name, () -> new PlacedFeature((Holder<ConfiguredFeature<?, ?>>) feature.getHolder().get(), ImmutableList.copyOf(placementModifiers)));
        }
    }
}

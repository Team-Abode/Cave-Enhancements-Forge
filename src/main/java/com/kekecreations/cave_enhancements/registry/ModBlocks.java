package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.block.*;
import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.ToIntFunction;

@SuppressWarnings({"unused", "deprecation"})
@Mod.EventBusSubscriber(modid = CaveEnhancements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {

        public static final BlockSubRegistryHelper HELPER = CaveEnhancements.REGISTRY_HELPER.getBlockSubHelper();


        public static final RegistryObject<Block> GOOP_BLOCK = HELPER.createBlock("goop_block",
                        () -> new Block(BlockBehaviour.Properties.of(Material.CLAY)
                                        .strength(6f).requiresCorrectToolForDrops().strength(0.5F, 1.0F)
                                        .speedFactor(0.3F).jumpFactor(0.9F).sound(ModSounds.GOOP_BLOCK)),
                        CreativeModeTab.TAB_BUILDING_BLOCKS);


        public static final RegistryObject<Block> DRIPPING_GOOP = HELPER.createBlock("dripping_goop",
                () -> new DrippingGoopBlock(BlockBehaviour.Properties.of(Material.CLAY)
                        .sound(ModSounds.GOOP_DECORATION).noOcclusion().noCollission()
                        .lightLevel((state) -> 2).color(MaterialColor.SAND)),
                CreativeModeTab.TAB_DECORATIONS);

        public static final RegistryObject<Block> GOOP_SPLAT = HELPER.createBlockNoItem("goop_splat",
                        () -> new GoopSplatBlock(BlockBehaviour.Properties.of(Material.CLAY).instabreak()
                                        .sound(ModSounds.GOOP_DECORATION).noCollission().noOcclusion()
                                        .color(MaterialColor.SAND)));

        public static final RegistryObject<Block> GOOP_TRAP = HELPER.createBlock("goop_trap",
                () -> new GoopTrapBlock(BlockBehaviour.Properties.of(Material.VEGETABLE).strength(2.0F, 5.0F)
                        .sound(ModSounds.GOOP_BLOCK).speedFactor(0.01F).jumpFactor(0.3F).friction(0.8F)
                        .color(MaterialColor.SAND)),
                CreativeModeTab.TAB_BUILDING_BLOCKS);

        public static final RegistryObject<Block> VOLATILE_GOOP = HELPER.createBlock("volatile_goop",
                () -> new VolatileGoopBlock(BlockBehaviour.Properties.of(Material.CLAY).strength(2.0F, 5.0F).sound(ModSounds.GOOP_BLOCK).color(MaterialColor.SAND)),
                CreativeModeTab.TAB_REDSTONE);

        public static final RegistryObject<Block> GLOW_SPLOTCH = HELPER.createBlockNoItem("glow_splotch",
                        () -> new GlowSplotchBlock(BlockBehaviour.Properties.of(Material.CLAY).instabreak()
                                        .sound(SoundType.HONEY_BLOCK).noCollission().noOcclusion()
                                        .color(MaterialColor.SAND).lightLevel((state) -> 8)));

        public static final RegistryObject<Block> SPECTACLE_CANDLE = HELPER.createBlock("spectacle_candle",
                        () -> new SpectacleCandleBlock(
                                        BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.CANDLE)
                                                        .lightLevel(CandleBlock.LIGHT_EMISSION).strength(0.1F, 0F)),
                        CreativeModeTab.TAB_DECORATIONS);

        public static final RegistryObject<Block> SPECTACLE_CANDLE_CAKE = HELPER.createBlockNoItem(
                        "spectacle_candle_cake",
                        () -> new SpectacleCandleCakeBlock(ModBlocks.SPECTACLE_CANDLE.get(),
                                        (BlockBehaviour.Properties.of(Material.CAKE).sound(SoundType.CANDLE)
                                                        .lightLevel(litBlockEmission(3)).strength(0.5F, 0F))));


        public static final RegistryObject<Block> ROSE_QUARTZ_BLOCK = HELPER.createBlock("rose_quartz_block",
                        () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.8F, 10)
                                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                                        .sound(SoundType.CALCITE)),
                        CreativeModeTab.TAB_BUILDING_BLOCKS);

        public static final RegistryObject<Block> JAGGED_ROSE_QUARTZ = HELPER.createBlock(
                        "jagged_rose_quartz",
                        () -> new JaggedRoseQuartzBlock(BlockBehaviour.Properties.of(Material.STONE).strength(0.8F, 10)
                                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                                        .sound(SoundType.CALCITE)),
                        CreativeModeTab.TAB_DECORATIONS);

        public static final RegistryObject<Block> POLISHED_ROSE_QUARTZ = HELPER.createBlock("polished_rose_quartz",
                () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10)
                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                        .sound(SoundType.CALCITE)),
                CreativeModeTab.TAB_BUILDING_BLOCKS);

        public static final RegistryObject<Block> POLISHED_ROSE_QUARTZ_SLAB = HELPER.createBlock(
                        "polished_rose_quartz_slab",
                        () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10)
                                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                                        .sound(SoundType.CALCITE)),
                        CreativeModeTab.TAB_BUILDING_BLOCKS);

        public static final RegistryObject<Block> POLISHED_ROSE_QUARTZ_VERTICAL_SLAB = HELPER.createCompatBlock(
                "quark",
                "polished_rose_quartz_vertical_slab",
                () -> new VerticalSlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10)
                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                        .sound(SoundType.CALCITE)),
                CreativeModeTab.TAB_BUILDING_BLOCKS);

        public static final RegistryObject<StairBlock> POLISHED_ROSE_QUARTZ_STAIRS = HELPER.createBlock(
                        "polished_rose_quartz_stairs",
                        () -> new StairBlock(POLISHED_ROSE_QUARTZ.get().defaultBlockState(),
                                        BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10)
                                                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                                                        .sound(SoundType.CALCITE).noOcclusion()),
                        CreativeModeTab.TAB_BUILDING_BLOCKS);

        public static final RegistryObject<Block> POLISHED_ROSE_QUARTZ_WALL = HELPER.createBlock(
                        "polished_rose_quartz_wall",
                        () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10)
                                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                                        .sound(SoundType.CALCITE)),
                        CreativeModeTab.TAB_BUILDING_BLOCKS);

        public static final RegistryObject<Block> ROSE_QUARTZ_TILES = HELPER.createBlock("rose_quartz_tiles",
                        () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10)
                                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                                        .sound(SoundType.CALCITE)),
                        CreativeModeTab.TAB_BUILDING_BLOCKS);

        public static final RegistryObject<Block> ROSE_QUARTZ_TILE_SLAB = HELPER.createBlock("rose_quartz_tile_slab",
                        () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10)
                                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                                        .sound(SoundType.CALCITE)),
                        CreativeModeTab.TAB_BUILDING_BLOCKS);

        public static final RegistryObject<Block> ROSE_QUARTZ_TILE_VERTICAL_SLAB = HELPER.createCompatBlock(
                "quark",
                "rose_quartz_tile_vertical_slab",
                () -> new VerticalSlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10)
                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                        .sound(SoundType.CALCITE)),
                CreativeModeTab.TAB_BUILDING_BLOCKS);

        public static final RegistryObject<Block> ROSE_QUARTZ_TILE_STAIRS = HELPER.createBlock(
                        "rose_quartz_tile_stairs",
                        () -> new StairBlock(ROSE_QUARTZ_TILES.get().defaultBlockState(),
                                        BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10)
                                                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                                                        .sound(SoundType.CALCITE).noOcclusion()),
                        CreativeModeTab.TAB_BUILDING_BLOCKS);

        public static final RegistryObject<Block> ROSE_QUARTZ_TILE_WALL = HELPER.createBlock("rose_quartz_tile_wall",
                        () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10)
                                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                                        .sound(SoundType.CALCITE)),
                        CreativeModeTab.TAB_BUILDING_BLOCKS);

        public static final RegistryObject<Block> ROSE_QUARTZ_LAMP = HELPER.createBlock("rose_quartz_lamp",
                () -> new RoseQuartzLampBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10)
                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                        .sound(SoundType.LANTERN).lightLevel((state) -> 15)),
                CreativeModeTab.TAB_DECORATIONS);

        public static final RegistryObject<Block> SOUL_ROSE_QUARTZ_LAMP = HELPER.createBlock(
                "soul_rose_quartz_lamp",
                () -> new RoseQuartzLampBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10)
                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                        .sound(SoundType.LANTERN).lightLevel((state) -> 15)),
                CreativeModeTab.TAB_DECORATIONS);

        public static final RegistryObject<Block> ROSE_QUARTZ_CHIMES = HELPER.createBlock(
                "rose_quartz_chimes",
                () -> new RoseQuartzChimesBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2F, 10)
                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK)
                        .sound(SoundType.CALCITE).noOcclusion()),
                CreativeModeTab.TAB_DECORATIONS);

        public static final RegistryObject<Block> REDSTONE_RECEIVER = HELPER.createBlock(
                        "redstone_receiver",
                        () -> new OxidizableReceiverBlock(
                                        WeatheringCopper.WeatherState.UNAFFECTED,
                                        BlockBehaviour.Properties.of(Material.METAL)
                                                        .color(MaterialColor.COLOR_ORANGE)
                                                        .sound(SoundType.COPPER)
                                                        .instabreak()),
                        CreativeModeTab.TAB_REDSTONE);

        public static final RegistryObject<Block> EXPOSED_REDSTONE_RECEIVER = HELPER.createBlock(
                        "exposed_redstone_receiver",
                        () -> new OxidizableReceiverBlock(
                                        WeatheringCopper.WeatherState.EXPOSED,
                                        BlockBehaviour.Properties.of(Material.METAL)
                                                        .color(MaterialColor.TERRACOTTA_LIGHT_GRAY)
                                                        .sound(SoundType.COPPER)
                                                        .instabreak()),
                        CreativeModeTab.TAB_REDSTONE);

        public static final RegistryObject<Block> WEATHERED_REDSTONE_RECEIVER = HELPER.createBlock(
                        "weathered_redstone_receiver",
                        () -> new OxidizableReceiverBlock(
                                        WeatheringCopper.WeatherState.WEATHERED,
                                        BlockBehaviour.Properties.of(Material.METAL)
                                                        .color(MaterialColor.TERRACOTTA_LIGHT_GRAY)
                                                        .sound(SoundType.COPPER)
                                                        .instabreak()),
                        CreativeModeTab.TAB_REDSTONE);

        public static final RegistryObject<Block> OXIDIZED_REDSTONE_RECEIVER = HELPER.createBlock(
                        "oxidized_redstone_receiver",
                        () -> new OxidizableReceiverBlock(
                                        WeatheringCopper.WeatherState.OXIDIZED,
                                        BlockBehaviour.Properties.of(Material.METAL)
                                                        .color(MaterialColor.TERRACOTTA_LIGHT_GRAY)
                                                        .sound(SoundType.COPPER)
                                                        .instabreak()),
                        CreativeModeTab.TAB_REDSTONE);

        public static final RegistryObject<Block> WAXED_REDSTONE_RECEIVER = HELPER.createBlock(
                        "waxed_redstone_receiver",
                        () -> new ReceiverBlock(
                                        WeatheringCopper.WeatherState.UNAFFECTED,
                                        BlockBehaviour.Properties.of(Material.METAL)
                                                        .color(MaterialColor.COLOR_ORANGE)
                                                        .sound(SoundType.COPPER)
                                                        .instabreak()),
                        CreativeModeTab.TAB_REDSTONE);

        public static final RegistryObject<Block> WAXED_EXPOSED_REDSTONE_RECEIVER = HELPER.createBlock(
                        "waxed_exposed_redstone_receiver",
                        () -> new ReceiverBlock(
                                        WeatheringCopper.WeatherState.EXPOSED,
                                        BlockBehaviour.Properties.of(Material.METAL)
                                                        .color(MaterialColor.TERRACOTTA_LIGHT_GRAY)
                                                        .sound(SoundType.COPPER)
                                                        .instabreak()),
                        CreativeModeTab.TAB_REDSTONE);

        public static final RegistryObject<Block> WAXED_WEATHERED_REDSTONE_RECEIVER = HELPER.createBlock(
                        "waxed_weathered_redstone_receiver",
                        () -> new ReceiverBlock(
                                        WeatheringCopper.WeatherState.WEATHERED,
                                        BlockBehaviour.Properties.of(Material.METAL)
                                                        .color(MaterialColor.TERRACOTTA_LIGHT_GRAY)
                                                        .sound(SoundType.COPPER)
                                                        .instabreak()),
                        CreativeModeTab.TAB_REDSTONE);

        public static final RegistryObject<Block> WAXED_OXIDIZED_REDSTONE_RECEIVER = HELPER.createBlock(
                        "waxed_oxidized_redstone_receiver",
                        () -> new ReceiverBlock(
                                        WeatheringCopper.WeatherState.OXIDIZED,
                                        BlockBehaviour.Properties.of(Material.METAL)
                                                        .color(MaterialColor.TERRACOTTA_LIGHT_GRAY)
                                                        .sound(SoundType.COPPER)
                                                        .instabreak()),
                        CreativeModeTab.TAB_REDSTONE);

        public static final RegistryObject<Block> LIGHTNING_ANCHOR = HELPER.createBlock("lightning_anchor",
                        () -> new LightningAnchorBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4, 100)
                                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_ORANGE)
                                        .sound(SoundType.COPPER)),
                        CreativeModeTab.TAB_REDSTONE);

        public static final RegistryObject<Block> CHARGED_LIGHTNING_ANCHOR = HELPER.createBlock(
                        "charged_lightning_anchor",
                        () -> new ChargedLightningAnchorBlock(
                                        BlockBehaviour.Properties.of(Material.METAL).strength(4, 100)
                                                        .requiresCorrectToolForDrops().color(MaterialColor.COLOR_ORANGE)
                                                        .sound(SoundType.COPPER).lightLevel((state) -> 15)),
                        CreativeModeTab.TAB_REDSTONE
                );



        private static ToIntFunction<BlockState> litBlockEmission(int i) {
                return (blockState) -> (Boolean) blockState.getValue(BlockStateProperties.LIT) ? i : 0;
        }

}
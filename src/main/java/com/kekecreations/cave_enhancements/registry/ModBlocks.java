package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.block.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CaveEnhancements.MOD_ID);

    //Goop Blocks
    public static final RegistryObject<Block> GOOP_BLOCK = registerBlock("goop_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLAY)
                    .strength(6f).requiresCorrectToolForDrops().strength(0.5F, 1.0F).speedFactor(0.3F).jumpFactor(0.9F).sound(ModSounds.GOOP_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> GOOP_TRAP = registerBlock("goop_trap",
            () -> new GoopTrapBlock(BlockBehaviour.Properties.of(Material.VEGETABLE).strength(2.0F, 5.0F).sound(ModSounds.GOOP_BLOCK).speedFactor(0.01F).jumpFactor(0.3F).friction(0.8F).color(MaterialColor.SAND)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> GOOP_SPLAT = registerBlockwithoutBlockItem("goop_splat",
            () -> new SplatBlock(BlockBehaviour.Properties.of(Material.CLAY).instabreak().sound(ModSounds.GOOP_DECORATION).noCollission().noOcclusion().color(MaterialColor.SAND)));

    public static final RegistryObject<Block> DRIPPING_GOOP = registerBlock("dripping_goop",
            () -> new DrippingGoopBlock(BlockBehaviour.Properties.of(Material.CLAY).sound(ModSounds.GOOP_DECORATION).noOcclusion().noCollission().lightLevel((state) -> 2).color(MaterialColor.SAND)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    //Glow Blocks
    public static final RegistryObject<Block> GLOW_SPLOTCH = registerBlockwithoutBlockItem("glow_splotch",
            () -> new SplatBlock(BlockBehaviour.Properties.of(Material.CLAY).instabreak().sound(SoundType.HONEY_BLOCK).noCollission().noOcclusion().color(MaterialColor.SAND).lightLevel((state) -> 8)));

    public static final RegistryObject<Block> SPECTACLE_CANDLE = registerBlock("spectacle_candle",
            () -> new SpectacleCandleBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.CANDLE).lightLevel(CandleBlock.LIGHT_EMISSION).strength(0.1F, 0F)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> SPECTACLE_CANDLE_CAKE = registerBlockwithoutBlockItem("spectacle_candle_cake",
            () -> new SpectacleCandleCakeBlock(ModBlocks.SPECTACLE_CANDLE.get(), (BlockBehaviour.Properties.of(Material.CAKE).sound(SoundType.CANDLE).lightLevel(litBlockEmission(3)).strength(0.5F, 0F))));


    //Rose Quartz Blocks
    public static final RegistryObject<RoseQuartzChimesBlock> ROSE_QUARTZ_CHIMES = registerBlock("rose_quartz_chimes",
            () -> new RoseQuartzChimesBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2F, 10).requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK).sound(ModSounds.ROSE_QUARTZ).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> ROSE_QUARTZ_BLOCK = registerBlock("rose_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.8F, 10).requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> POLISHED_ROSE_QUARTZ = registerBlock("polished_rose_quartz",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10).requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<JaggedRoseQuartzBlock> JAGGED_ROSE_QUARTZ = registerBlock("jagged_rose_quartz",
            () -> new JaggedRoseQuartzBlock(BlockBehaviour.Properties.of(Material.STONE).strength(0.8F, 10).requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK).noCollission().sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<RoseQuartzLampBlock> ROSE_QUARTZ_LAMP = registerBlock("rose_quartz_lamp",
            () -> new RoseQuartzLampBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10).requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK).sound(SoundType.LANTERN).lightLevel((state) -> 15)), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<RoseQuartzLampBlock> SOUL_ROSE_QUARTZ_LAMP = registerBlock("soul_rose_quartz_lamp",
            () -> new RoseQuartzLampBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10).requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK).sound(SoundType.LANTERN).lightLevel((state) -> 15)), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<SlabBlock> POLISHED_ROSE_QUARTZ_SLAB = registerBlock("polished_rose_quartz_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10).requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<StairBlock> POLISHED_ROSE_QUARTZ_STAIRS = registerBlock("polished_rose_quartz_stairs",
            () -> new StairBlock(POLISHED_ROSE_QUARTZ.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10).requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK).sound(ModSounds.ROSE_QUARTZ).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<WallBlock> POLISHED_ROSE_QUARTZ_WALL = registerBlock("polished_rose_quartz_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10).requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> ROSE_QUARTZ_TILES = registerBlock("rose_quartz_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10).requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<SlabBlock> ROSE_QUARTZ_TILE_SLAB = registerBlock("rose_quartz_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10).requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<StairBlock> ROSE_QUARTZ_TILE_STAIRS = registerBlock("rose_quartz_tile_stairs",
            () -> new StairBlock(ROSE_QUARTZ_TILES.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10).requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK).sound(SoundType.CALCITE).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<WallBlock> ROSE_QUARTZ_TILE_WALL = registerBlock("rose_quartz_tile_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 10).requiresCorrectToolForDrops().color(MaterialColor.COLOR_PINK).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);



    //Registry Stuff
    private static <T extends Block> RegistryObject<T> registerBlockwithoutBlockItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    private static ToIntFunction<BlockState> litBlockEmission(int i) {
        return (blockState) -> (Boolean)blockState.getValue(BlockStateProperties.LIT) ? i : 0;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
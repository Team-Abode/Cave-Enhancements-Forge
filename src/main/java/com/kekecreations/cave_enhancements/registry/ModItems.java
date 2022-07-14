package com.kekecreations.cave_enhancements.registry;


import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.item.AmethystFluteItem;
import com.kekecreations.cave_enhancements.item.GlowPasteItem;
import com.kekecreations.cave_enhancements.item.GoopBucketItem;
import com.kekecreations.cave_enhancements.item.HarmonicArrowItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CaveEnhancements.MOD_ID);

    public static final RegistryObject<Item> BIG_GOOP_DRIP = ITEMS.register("big_goop_drip",
            () -> new Item(new Item.Properties()));

    public static RegistryObject<Item> GOOP_BUCKET = ITEMS.register("goop_bucket",
            () -> new GoopBucketItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1)));

    public static final RegistryObject<BlockItem> GOOP = ITEMS.register("goop",
            () -> new BlockItem(ModBlocks.GOOP_SPLAT.get(), new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<GlowPasteItem> GLOW_PASTE = ITEMS.register("glow_paste",
            () -> new GlowPasteItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(32)));

    public static final RegistryObject<HarmonicArrowItem> HARMONIC_ARROW = ITEMS.register("harmonic_arrow",
            () -> new HarmonicArrowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<AmethystFluteItem> AMETHYST_FLUTE = ITEMS.register("amethyst_flute",
            () -> new AmethystFluteItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(64)));

    public static final RegistryObject<ForgeSpawnEggItem> GOOP_SPAWN_EGG = ITEMS.register("goop_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GOOP, 13946012, 11637089, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<ForgeSpawnEggItem> CRUNCHER_SPAWN_EGG = ITEMS.register("cruncher_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CRUNCHER, 11127234, 5757312, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<ForgeSpawnEggItem> DRIPSTONE_TORTOISE_SPAWN_EGG = ITEMS.register("dripstone_tortoise_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.DRIPSTONE_TORTOISE, 8156236, 6967114, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<BannerPatternItem> GOOP_BANNER_PATTERN = ITEMS.register("goop_banner_pattern",
            () -> new BannerPatternItem(ModTags.GOOP_PATTERN_ITEM,new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> ROSE_QUARTZ = ITEMS.register("rose_quartz",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));








    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

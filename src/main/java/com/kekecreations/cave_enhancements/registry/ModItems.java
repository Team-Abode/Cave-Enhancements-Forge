package com.kekecreations.cave_enhancements.registry;


import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.item.AmethystFluteItem;
import com.kekecreations.cave_enhancements.item.GlowPasteItem;
import com.kekecreations.cave_enhancements.item.GoopBucketItem;
import com.kekecreations.cave_enhancements.item.HarmonicArrowItem;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
@Mod.EventBusSubscriber(modid = CaveEnhancements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

    public static final ItemSubRegistryHelper HELPER = CaveEnhancements.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> BIG_GOOP_DRIP = HELPER.createItem("big_goop_drip",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOOP = HELPER.createItem("goop",
            () -> new BlockItem(ModBlocks.GOOP_SPLAT.get(), new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Item> ROSE_QUARTZ = HELPER.createItem("rose_quartz",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Item> GLOW_PASTE = HELPER.createItem("glow_paste",
            () -> new GlowPasteItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(32)));

    public static final RegistryObject<Item> AMETHYST_FLUTE = HELPER.createItem("amethyst_flute",
            () -> new AmethystFluteItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(64)));

    public static final RegistryObject<Item> HARMONIC_ARROW = HELPER.createItem("harmonic_arrow",
            () -> new HarmonicArrowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static RegistryObject<Item> GOOP_BUCKET = HELPER.createItem("goop_bucket",
            () -> new GoopBucketItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1)));

    public static final RegistryObject<Item> GOOP_BANNER_PATTERN = HELPER.createItem("goop_banner_pattern",
            () -> new BannerPatternItem(ModTags.GOOP_PATTERN_ITEM,new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> GOOP_SPAWN_EGG = HELPER.createItem("goop_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GOOP, 13946012, 11637089, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> CRUNCHER_SPAWN_EGG = HELPER.createItem("cruncher_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CRUNCHER, 11127234, 5757312, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> DRIPSTONE_TORTOISE_SPAWN_EGG = HELPER.createItem("dripstone_tortoise_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.DRIPSTONE_TORTOISE, 8156236, 6967114, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

}

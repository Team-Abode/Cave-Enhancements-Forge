package com.teamabode.cave_enhancements.registry;


import com.teamabode.cave_enhancements.CaveEnhancements;
import com.teamabode.cave_enhancements.item.*;
import com.teamabnormals.blueprint.common.item.BlueprintBannerPatternItem;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
@Mod.EventBusSubscriber(modid = CaveEnhancements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

    public static final ItemSubRegistryHelper HELPER = CaveEnhancements.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> BIG_GOOP_DRIP = HELPER.createItem("big_goop_drip",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOOP = HELPER.createItem("goop",
            () -> new GoopItem(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Item> ROSE_QUARTZ = HELPER.createItem("rose_quartz",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_BREWING)));

    public static final RegistryObject<Item> GLOW_PASTE = HELPER.createItem("glow_paste",
            () -> new GlowPasteItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(32)));

    public static final RegistryObject<Item> AMETHYST_FLUTE = HELPER.createItem("amethyst_flute",
            () -> new AmethystFluteItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(64)));

    public static final RegistryObject<Item> HARMONIC_ARROW = HELPER.createItem("harmonic_arrow",
            () -> new HarmonicArrowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static RegistryObject<Item> GOOP_BUCKET = HELPER.createItem("goop_bucket",
            () -> new GoopBucketItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1)));

    public static final RegistryObject<Item> GOOP_BANNER_PATTERN = HELPER.createItem("goop_banner_pattern",
            () -> new BlueprintBannerPatternItem(ModTags.GOOP_PATTERN_ITEM,new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> GOOP_SPAWN_EGG = HELPER.createItem("goop_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GOOP, 13946012, 11637089, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> CRUNCHER_SPAWN_EGG = HELPER.createItem("cruncher_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CRUNCHER, 11127234, 5757312, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> DRIPSTONE_TORTOISE_SPAWN_EGG = HELPER.createItem("dripstone_tortoise_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.DRIPSTONE_TORTOISE, 8156236, 6967114, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> GLOW_BERRY_JUICE = HELPER.createItem("glow_berry_juice",
            () -> new GlowBerryJuiceItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(16).food(new FoodProperties.Builder().saturationMod(0.6F).nutrition(4).build())));
}

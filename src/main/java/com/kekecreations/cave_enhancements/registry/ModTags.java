package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;

public class ModTags {


    public static final TagKey<BannerPattern> GOOP_PATTERN_ITEM = TagKey.create(Registry.BANNER_PATTERN_REGISTRY, new ResourceLocation(CaveEnhancements.MOD_ID, "goop_pattern_item"));


    // Block Tags
    public static final TagKey<Block> RECEIVERS = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(CaveEnhancements.MOD_ID, "receivers"));
    public static final TagKey<Block> PIKE_DESTROYABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(CaveEnhancements.MOD_ID, "pike_destroyables"));
    public static final TagKey<Block> CRUNCHER_CONSUMABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(CaveEnhancements.MOD_ID, "cruncher_consumables"));
    public static final TagKey<Block> CRUNCHERS_SPAWNABLE_ON = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(CaveEnhancements.MOD_ID, "crunchers_spawnable_on"));
}

package com.teamabode.cave_enhancements.core.data.server;

import com.teamabode.cave_enhancements.CaveEnhancements;
import com.teamabode.cave_enhancements.core.registry.ModBlocks;
import com.teamabode.cave_enhancements.core.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {

    public RecipeGenerator(DataGenerator pGenerator) {
        super(pGenerator);
    }

    protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> exporter) {
        createPackedRecipe(ModItems.GOOP.get(), ModBlocks.GOOP_BLOCK.get(), exporter);

        ShapedRecipeBuilder.shaped(ModBlocks.DRIPPING_GOOP.get())
        .define('X', ModItems.GOOP.get())
        .pattern("X")
        .pattern("X")
        .pattern("X")
        .unlockedBy("has_goop", has(ModItems.GOOP.get()))
        .save(exporter);

        ShapedRecipeBuilder.shaped(ModItems.HARMONIC_ARROW.get(), 2)
        .define('#', Items.STICK)
        .define('X', Items.AMETHYST_SHARD)
        .define('Y', Items.FEATHER)
        .pattern("X")
        .pattern("#")
        .pattern("Y")
        .unlockedBy("has_feather", has(Items.FEATHER))
        .unlockedBy("has_flint", has(Items.FLINT))
        .unlockedBy("has_amethyst_shard", has(Items.AMETHYST_SHARD))
        .save(exporter);

        ShapedRecipeBuilder.shaped(ModItems.GLOW_PASTE.get())
        .define('G', Items.GLOW_INK_SAC)
        .define('X', Items.IRON_INGOT)
        .pattern("X ")
        .pattern(" G")
        .unlockedBy("has_glow_ink_sac", has(Items.GLOW_INK_SAC))
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(exporter);

        ShapedRecipeBuilder.shaped(ModBlocks.SPECTACLE_CANDLE.get())
        .define('S', Items.STRING)
        .define('H', Items.HONEYCOMB)
        .define('G', Items.GLOW_INK_SAC)
        .pattern("S")
        .pattern("H")
        .pattern("G")
        .unlockedBy("has_string", has(Items.STRING))
        .unlockedBy("has_honeycomb", has(Items.HONEYCOMB))
        .unlockedBy("has_glow_ink_sac", has(Items.GLOW_INK_SAC))
        .save(exporter);

        ShapedRecipeBuilder.shaped(ModItems.AMETHYST_FLUTE.get())
        .define('#', Items.AMETHYST_SHARD)
        .pattern("  #")
        .pattern(" # ")
        .pattern("#  ")
        .unlockedBy("has_amethyst_shard", has(Items.AMETHYST_SHARD))
        .save(exporter);

        generateRoseQuartzRecipes(exporter);
        generateShapelessRecipe(exporter, new Item[]{Items.GLOW_BERRIES, Items.SUGAR, Items.GLASS_BOTTLE}, ModItems.GLOW_BERRY_JUICE.get());
        generateShapelessRecipe(exporter, new Item[]{ModItems.GOOP.get(), Items.PAPER}, ModItems.GOOP_BANNER_PATTERN.get());

        createRedstoneReceiver(Items.COPPER_BLOCK, ModBlocks.REDSTONE_RECEIVER.get(), exporter);
        createRedstoneReceiver(Items.EXPOSED_COPPER, ModBlocks.EXPOSED_REDSTONE_RECEIVER.get(), exporter);
        createRedstoneReceiver(Items.WEATHERED_COPPER, ModBlocks.WEATHERED_REDSTONE_RECEIVER.get(), exporter);
        createRedstoneReceiver(Items.OXIDIZED_COPPER, ModBlocks.OXIDIZED_REDSTONE_RECEIVER.get(), exporter);
        createWaxedReceiver(ModBlocks.REDSTONE_RECEIVER.get(), Items.WAXED_COPPER_BLOCK, ModBlocks.WAXED_REDSTONE_RECEIVER.get(), exporter);
        createWaxedReceiver(ModBlocks.EXPOSED_REDSTONE_RECEIVER.get(), Items.WAXED_EXPOSED_COPPER, ModBlocks.WAXED_EXPOSED_REDSTONE_RECEIVER.get(), exporter);
        createWaxedReceiver(ModBlocks.WEATHERED_REDSTONE_RECEIVER.get(), Items.WAXED_WEATHERED_COPPER, ModBlocks.WAXED_WEATHERED_REDSTONE_RECEIVER.get(), exporter);
        createWaxedReceiver(ModBlocks.OXIDIZED_REDSTONE_RECEIVER.get(), Items.WAXED_OXIDIZED_COPPER, ModBlocks.WAXED_OXIDIZED_REDSTONE_RECEIVER.get(), exporter);
    }

    private void generateShapelessRecipe(Consumer<FinishedRecipe> exporter, Item[] ingredients, Item result) {
        ShapelessRecipeBuilder recipeBuilder = ShapelessRecipeBuilder.shapeless(result);
        for (Item ingredient : ingredients) {
            recipeBuilder.requires(ingredient)
                    .unlockedBy(getHasName(ingredient), has(ingredient));
        }
        recipeBuilder.save(exporter);
    }

    private void generateRoseQuartzRecipes(Consumer<FinishedRecipe> exporter) {
        createPackedRecipe(ModItems.ROSE_QUARTZ.get(), ModBlocks.ROSE_QUARTZ_BLOCK.get(), exporter);
        polishRecipe(ModBlocks.ROSE_QUARTZ_BLOCK.get(), ModBlocks.POLISHED_ROSE_QUARTZ.get(), exporter);
        polishRecipe(ModBlocks.POLISHED_ROSE_QUARTZ.get(), ModBlocks.ROSE_QUARTZ_TILES.get(), exporter);
        cutRoseQuartz(exporter, ModBlocks.POLISHED_ROSE_QUARTZ.get(), ModBlocks.ROSE_QUARTZ_BLOCK.get());
        cutRoseQuartz(exporter, ModBlocks.POLISHED_ROSE_QUARTZ_SLAB.get(), ModBlocks.ROSE_QUARTZ_BLOCK.get());
        cutRoseQuartz(exporter, ModBlocks.POLISHED_ROSE_QUARTZ_STAIRS.get(), ModBlocks.ROSE_QUARTZ_BLOCK.get());
        cutRoseQuartz(exporter, ModBlocks.POLISHED_ROSE_QUARTZ_WALL.get(), ModBlocks.ROSE_QUARTZ_BLOCK.get());

        cutRoseQuartz(exporter, ModBlocks.POLISHED_ROSE_QUARTZ_SLAB.get(), ModBlocks.POLISHED_ROSE_QUARTZ.get());
        cutRoseQuartz(exporter, ModBlocks.POLISHED_ROSE_QUARTZ_STAIRS.get(), ModBlocks.POLISHED_ROSE_QUARTZ.get());
        cutRoseQuartz(exporter, ModBlocks.POLISHED_ROSE_QUARTZ_WALL.get(), ModBlocks.POLISHED_ROSE_QUARTZ.get());

        cutRoseQuartz(exporter, ModBlocks.ROSE_QUARTZ_TILES.get(), ModBlocks.ROSE_QUARTZ_BLOCK.get());
        cutRoseQuartz(exporter, ModBlocks.ROSE_QUARTZ_TILE_SLAB.get(), ModBlocks.ROSE_QUARTZ_BLOCK.get());
        cutRoseQuartz(exporter, ModBlocks.ROSE_QUARTZ_TILE_STAIRS.get(), ModBlocks.ROSE_QUARTZ_BLOCK.get());
        cutRoseQuartz(exporter, ModBlocks.ROSE_QUARTZ_TILE_WALL.get(), ModBlocks.ROSE_QUARTZ_BLOCK.get());

        cutRoseQuartz(exporter, ModBlocks.ROSE_QUARTZ_TILES.get(), ModBlocks.POLISHED_ROSE_QUARTZ.get());
        cutRoseQuartz(exporter, ModBlocks.ROSE_QUARTZ_TILE_SLAB.get(), ModBlocks.POLISHED_ROSE_QUARTZ.get());
        cutRoseQuartz(exporter, ModBlocks.ROSE_QUARTZ_TILE_STAIRS.get(), ModBlocks.POLISHED_ROSE_QUARTZ.get());
        cutRoseQuartz(exporter, ModBlocks.ROSE_QUARTZ_TILE_WALL.get(), ModBlocks.POLISHED_ROSE_QUARTZ.get());

        cutRoseQuartz(exporter, ModBlocks.ROSE_QUARTZ_TILE_SLAB.get(), ModBlocks.ROSE_QUARTZ_TILES.get());
        cutRoseQuartz(exporter, ModBlocks.ROSE_QUARTZ_TILE_STAIRS.get(), ModBlocks.ROSE_QUARTZ_TILES.get());
        cutRoseQuartz(exporter, ModBlocks.ROSE_QUARTZ_TILE_WALL.get(), ModBlocks.ROSE_QUARTZ_TILES.get());

        RecipeProvider.slab(exporter, ModBlocks.POLISHED_ROSE_QUARTZ_SLAB.get(), ModBlocks.POLISHED_ROSE_QUARTZ.get());
        stairs(exporter, ModBlocks.POLISHED_ROSE_QUARTZ_STAIRS.get().asItem(), ModBlocks.POLISHED_ROSE_QUARTZ.get().asItem());
        RecipeProvider.wall(exporter, ModBlocks.POLISHED_ROSE_QUARTZ_WALL.get(), ModBlocks.POLISHED_ROSE_QUARTZ.get());

        RecipeProvider.slab(exporter, ModBlocks.ROSE_QUARTZ_TILE_SLAB.get(), ModBlocks.ROSE_QUARTZ_TILES.get());
        stairs(exporter, ModBlocks.ROSE_QUARTZ_TILE_STAIRS.get(), ModBlocks.ROSE_QUARTZ_TILES.get());
        RecipeProvider.wall(exporter, ModBlocks.ROSE_QUARTZ_TILE_WALL.get(), ModBlocks.ROSE_QUARTZ_TILES.get());

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHTNING_ANCHOR.get())
        .define('C', Items.COPPER_BLOCK)
        .define('R', ModItems.ROSE_QUARTZ.get())
        .pattern("CCC")
        .pattern("CRC")
        .pattern("CCC")
        .unlockedBy("has_copper_block", has(Items.COPPER_BLOCK))
        .unlockedBy("has_rose_quartz", has(ModItems.ROSE_QUARTZ.get()))
        .save(exporter);

        createRoseQuartzLamp(Items.TORCH, ModBlocks.ROSE_QUARTZ_LAMP.get(), exporter);
        createRoseQuartzLamp(Items.SOUL_TORCH, ModBlocks.SOUL_ROSE_QUARTZ_LAMP.get(), exporter);
        createRoseQuartzChimes(exporter);
    }

    private void createPackedRecipe(ItemLike ingredient, ItemLike result, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(result)
        .define('#', ingredient)
        .pattern("##").pattern("##")
        .unlockedBy(getHasName(ingredient), has(ingredient))
        .save(exporter);
    }

    private void stairs(Consumer<FinishedRecipe> exporter, ItemLike stairs, ItemLike material) {
        ShapedRecipeBuilder.shaped(stairs, 4)
        .define('#', material)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy(getHasName(material), has(material))
        .save(exporter);
    }

    private void polishRecipe(ItemLike ingredient, ItemLike result, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(result, 4)
        .define('#', ingredient)
        .pattern("##")
        .pattern("##")
        .unlockedBy(getHasName(ingredient), has(ingredient))
        .save(exporter);
    }

    private void createRoseQuartzLamp(ItemLike torchIngredient, ItemLike result, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(result, 1)
        .define('r', ModItems.ROSE_QUARTZ.get())
        .define('i', Items.IRON_NUGGET)
        .define('t', torchIngredient)
        .pattern(" r ")
        .pattern("iti")
        .pattern(" i ")
        .unlockedBy(getHasName(torchIngredient), has(torchIngredient))
        .unlockedBy("has_rose_quartz", has(ModItems.ROSE_QUARTZ.get()))
        .save(exporter);
    }

    private void createRoseQuartzChimes(Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(ModBlocks.ROSE_QUARTZ_CHIMES.get())
        .define('s', Items.STONE_BRICKS)
        .define('g', Items.GHAST_TEAR)
        .define('t', Items.STRING)
        .define('r', ModItems.ROSE_QUARTZ.get())
        .pattern("sgs")
        .pattern("t t")
        .pattern("r r")
        .unlockedBy("has_rose_quartz", has(ModItems.ROSE_QUARTZ.get()))
        .save(exporter);
    }

    private void createRedstoneReceiver(ItemLike copperBlock, ItemLike result, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(result)
        .define('r', Items.REDSTONE)
        .define('C', copperBlock)
        .define('T', Items.REDSTONE_TORCH)
        .pattern("rTr")
        .pattern("CCC")
        .unlockedBy("has_redstone", has(Items.REDSTONE))
        .unlockedBy(getHasName(copperBlock), has(copperBlock))
        .unlockedBy("has_redstone_torch", has(Items.REDSTONE_TORCH))
        .save(exporter);
    }

    private void createWaxedReceiver(ItemLike receiverType, ItemLike copperBlock, ItemLike result, Consumer<FinishedRecipe> exporter) {
        ShapelessRecipeBuilder.shapeless(result)
        .requires(receiverType).requires(Items.HONEYCOMB)
        .unlockedBy(getHasName(receiverType), has(receiverType))
        .unlockedBy("has_honeycomb", has(Items.HONEYCOMB))
        .save(exporter, new ResourceLocation(CaveEnhancements.MOD_ID, ForgeRegistries.ITEMS.getKey(result.asItem()).getPath() + "_from_honeycomb"));
        createRedstoneReceiver(copperBlock, result, exporter);
    }

    protected static void cutRoseQuartz(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pResult, ItemLike pMaterial) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(pMaterial), pResult, 1).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer, new ResourceLocation(CaveEnhancements.MOD_ID, getConversionRecipeName(pResult, pMaterial) + "_stonecutting"));
    }
}

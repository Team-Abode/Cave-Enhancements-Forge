package com.teamabode.cave_enhancements.core.data.server;

import com.teamabode.cave_enhancements.CaveEnhancements;
import com.teamabode.cave_enhancements.core.registry.ModBlocks;
import com.teamabode.cave_enhancements.core.registry.ModEntities;
import com.teamabode.cave_enhancements.core.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class TagGenerator {

    public static class BlockTagGenerator extends BlockTagsProvider {

        public BlockTagGenerator(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
            super(pGenerator, CaveEnhancements.MOD_ID, existingFileHelper);
        }

        protected void addTags() {
            appendPickaxeMineable();
            appendHoeMineable();
            appendStoneTool();
            appendWallBlocks();
            this.tag(BlockTags.CANDLES).replace(false).add(ModBlocks.SPECTACLE_CANDLE.get());
            this.tag(BlockTags.CANDLE_CAKES).replace(false).add(ModBlocks.SPECTACLE_CANDLE_CAKE.get());
            this.tag(BlockTags.FALL_DAMAGE_RESETTING).replace(false).add(ModBlocks.DRIPPING_GOOP.get());
        }

        private void appendPickaxeMineable() {
            this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .replace(false)
            .add(ModBlocks.LIGHTNING_ANCHOR.get())
            .add(ModBlocks.CHARGED_LIGHTNING_ANCHOR.get())
            .add(ModBlocks.ROSE_QUARTZ_BLOCK.get())
            .add(ModBlocks.JAGGED_ROSE_QUARTZ.get())
            .add(ModBlocks.POLISHED_ROSE_QUARTZ.get())
            .add(ModBlocks.POLISHED_ROSE_QUARTZ_SLAB.get())
            .add(ModBlocks.POLISHED_ROSE_QUARTZ_STAIRS.get())
            .add(ModBlocks.POLISHED_ROSE_QUARTZ_WALL.get())
            .add(ModBlocks.ROSE_QUARTZ_TILES.get())
            .add(ModBlocks.ROSE_QUARTZ_TILE_SLAB.get())
            .add(ModBlocks.ROSE_QUARTZ_TILE_STAIRS.get())
            .add(ModBlocks.ROSE_QUARTZ_TILE_WALL.get())
            .add(ModBlocks.ROSE_QUARTZ_CHIMES.get())
            .add(ModBlocks.ROSE_QUARTZ_LAMP.get())
            .add(ModBlocks.SOUL_ROSE_QUARTZ_LAMP.get());
        }

        private void appendHoeMineable() {
            this.tag(BlockTags.MINEABLE_WITH_HOE)
            .replace(false)
            .add(ModBlocks.GOOP_BLOCK.get())
            .add(ModBlocks.GOOP_TRAP.get())
            .add(ModBlocks.VOLATILE_GOOP.get());
        }

        private void appendStoneTool() {
            this.tag(BlockTags.NEEDS_STONE_TOOL)
            .replace(false)
            .add(ModBlocks.LIGHTNING_ANCHOR.get())
            .add(ModBlocks.CHARGED_LIGHTNING_ANCHOR.get())
            .add(ModBlocks.ROSE_QUARTZ_BLOCK.get())
            .add(ModBlocks.JAGGED_ROSE_QUARTZ.get())
            .add(ModBlocks.POLISHED_ROSE_QUARTZ.get())
            .add(ModBlocks.POLISHED_ROSE_QUARTZ_SLAB.get())
            .add(ModBlocks.POLISHED_ROSE_QUARTZ_STAIRS.get())
            .add(ModBlocks.POLISHED_ROSE_QUARTZ_WALL.get())
            .add(ModBlocks.ROSE_QUARTZ_TILES.get())
            .add(ModBlocks.ROSE_QUARTZ_TILE_SLAB.get())
            .add(ModBlocks.ROSE_QUARTZ_TILE_STAIRS.get())
            .add(ModBlocks.ROSE_QUARTZ_TILE_WALL.get())
            .add(ModBlocks.ROSE_QUARTZ_CHIMES.get())
            .add(ModBlocks.ROSE_QUARTZ_LAMP.get())
            .add(ModBlocks.SOUL_ROSE_QUARTZ_LAMP.get());
        }

        private void appendWallBlocks() {
            this.tag(BlockTags.WALLS)
            .replace(false)
            .add(ModBlocks.POLISHED_ROSE_QUARTZ_WALL.get())
            .add(ModBlocks.ROSE_QUARTZ_TILE_WALL.get());
        }
    }

    public static class ItemGenerator extends ItemTagsProvider {

        public ItemGenerator(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(pGenerator, pBlockTagsProvider, CaveEnhancements.MOD_ID, existingFileHelper);
        }

        protected void addTags() {
            this.tag(ItemTags.ARROWS).replace(false).add(ModItems.HARMONIC_ARROW.get());
            this.tag(ItemTags.CANDLES).replace(false).add(ModBlocks.SPECTACLE_CANDLE.get().asItem());
        }
    }

    public static class EntityTypeGenerator extends EntityTypeTagsProvider {

        public EntityTypeGenerator(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
            super(pGenerator, CaveEnhancements.MOD_ID, existingFileHelper);
        }

        protected void addTags() {
            this.tag(EntityTypeTags.FROG_FOOD).replace(false).add(ModEntities.GOOP.get());
        }
    }
}

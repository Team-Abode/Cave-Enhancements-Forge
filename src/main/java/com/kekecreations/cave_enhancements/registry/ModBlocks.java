package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.block.DrippingGoopBlock;
import com.kekecreations.cave_enhancements.block.GoopTrapBlock;
import com.kekecreations.cave_enhancements.block.SplatBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CaveEnhancements.MOD_ID);

    public static final RegistryObject<Block> GOOP_BLOCK = registerBlock("goop_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLAY)
                    .strength(6f).requiresCorrectToolForDrops().strength(0.5F, 1.0F).speedFactor(0.3F).jumpFactor(0.9F).sound(ModSounds.GOOP_BLOCK)));

    public static final RegistryObject<Block> GOOP_TRAP = registerBlock("goop_trap",
            () -> new GoopTrapBlock(BlockBehaviour.Properties.of(Material.VEGETABLE).strength(2.0F, 5.0F).sound(ModSounds.GOOP_BLOCK).speedFactor( 0.01F).jumpFactor(0.3F).friction(0.8F).color(MaterialColor.SAND)));

    public static final RegistryObject<Block> GOOP_SPLAT = registerBlock("goop_splat",
            () -> new SplatBlock(BlockBehaviour.Properties.of(Material.CLAY).instabreak().sound(ModSounds.GOOP_DECORATION).noCollission().noOcclusion().color(MaterialColor.SAND)));

    public static final RegistryObject<Block> DRIPPING_GOOP = registerBlock("dripping_goop",
            () -> new DrippingGoopBlock(BlockBehaviour.Properties.of(Material.CLAY).sound(ModSounds.GOOP_DECORATION).noOcclusion().noCollission().lightLevel((state) -> 2).color(MaterialColor.SAND)));




    public static void registerClient() {
    }



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

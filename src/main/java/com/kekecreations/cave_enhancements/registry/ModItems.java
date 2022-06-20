package com.kekecreations.cave_enhancements.registry;


import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.GoopBucketItem;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.level.material.Fluids;
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
            () -> new GoopBucketItem(ModEntities.GOOP, Fluids.EMPTY, SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

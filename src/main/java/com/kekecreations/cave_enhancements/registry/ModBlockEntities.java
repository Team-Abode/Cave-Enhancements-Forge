package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.block.entity.RoseQuartzChimesBlockEntity;
import com.kekecreations.cave_enhancements.block.entity.SpectacleCandleBlockEntity;
import com.kekecreations.cave_enhancements.block.entity.SpectacleCandleCakeBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CaveEnhancements.MOD_ID);

    public static final RegistryObject<BlockEntityType<SpectacleCandleBlockEntity>> SPECTACLE_CANDLE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("spectacle_candle_block_entity", () ->
                    BlockEntityType.Builder.of(SpectacleCandleBlockEntity::new,
                            ModBlocks.SPECTACLE_CANDLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<SpectacleCandleCakeBlockEntity>> SPECTACLE_CANDLE_CAKE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("spectacle_candle_cake_block_entity", () ->
                    BlockEntityType.Builder.of(SpectacleCandleCakeBlockEntity::new,
                            ModBlocks.SPECTACLE_CANDLE_CAKE.get()).build(null));

    public static final RegistryObject<BlockEntityType<RoseQuartzChimesBlockEntity>> ROSE_QUARTZ_CHIMES_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("rose_quartz_chimes_block_entity", () ->
                    BlockEntityType.Builder.of(RoseQuartzChimesBlockEntity::new,
                            ModBlocks.ROSE_QUARTZ_CHIMES.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}

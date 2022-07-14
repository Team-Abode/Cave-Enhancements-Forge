package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.block.entity.ReceiverBlockEntity;
import com.kekecreations.cave_enhancements.block.entity.LightningAnchorBlockEntity;
import com.kekecreations.cave_enhancements.block.entity.RoseQuartzChimesBlockEntity;
import com.kekecreations.cave_enhancements.block.entity.SpectacleCandleBlockEntity;
import com.kekecreations.cave_enhancements.block.entity.SpectacleCandleCakeBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

        public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
                        .create(ForgeRegistries.BLOCK_ENTITY_TYPES, CaveEnhancements.MOD_ID);

        public static final RegistryObject<BlockEntityType<SpectacleCandleBlockEntity>> SPECTACLE_CANDLE_BLOCK_ENTITY = BLOCK_ENTITIES
                        .register("spectacle_candle", () -> BlockEntityType.Builder.of(SpectacleCandleBlockEntity::new,
                                        ModBlocks.SPECTACLE_CANDLE.get()).build(null));

        public static final RegistryObject<BlockEntityType<SpectacleCandleCakeBlockEntity>> SPECTACLE_CANDLE_CAKE_BLOCK_ENTITY = BLOCK_ENTITIES
                        .register("spectacle_candle_cake",
                                        () -> BlockEntityType.Builder.of(SpectacleCandleCakeBlockEntity::new,
                                                        ModBlocks.SPECTACLE_CANDLE_CAKE.get()).build(null));

        public static final RegistryObject<BlockEntityType<RoseQuartzChimesBlockEntity>> ROSE_QUARTZ_CHIMES_BLOCK_ENTITY = BLOCK_ENTITIES
                        .register("rose_quartz_chimes",
                                        () -> BlockEntityType.Builder.of(RoseQuartzChimesBlockEntity::new,
                                                        ModBlocks.ROSE_QUARTZ_CHIMES.get()).build(null));

        public static final RegistryObject<BlockEntityType<ReceiverBlockEntity>> RECEIVER_BLOCK_ENTITY = BLOCK_ENTITIES
                        .register("redstone_receiver", () -> BlockEntityType.Builder.of(ReceiverBlockEntity::new,
                                        ModBlocks.REDSTONE_RECEIVER.get(),
                                        ModBlocks.EXPOSED_REDSTONE_RECEIVER.get(),
                                        ModBlocks.WEATHERED_REDSTONE_RECEIVER.get(),
                                        ModBlocks.OXIDIZED_REDSTONE_RECEIVER.get(),
                                        ModBlocks.WAXED_REDSTONE_RECEIVER.get(),
                                        ModBlocks.WAXED_EXPOSED_REDSTONE_RECEIVER.get(),
                                        ModBlocks.WAXED_WEATHERED_REDSTONE_RECEIVER.get(),
                                        ModBlocks.WAXED_OXIDIZED_REDSTONE_RECEIVER.get()).build(null));

        public static final RegistryObject<BlockEntityType<LightningAnchorBlockEntity>> LIGHTNING_ANCHOR = BLOCK_ENTITIES
                        .register("lightning_anchor",
                                        () -> BlockEntityType.Builder.of(LightningAnchorBlockEntity::new,
                                                        ModBlocks.LIGHTNING_ANCHOR.get()).build(null));

        public static void register(IEventBus eventBus) {
                BLOCK_ENTITIES.register(eventBus);
        }
}

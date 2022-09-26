package com.teamabode.cave_enhancements.registry;

import com.teamabode.cave_enhancements.CaveEnhancements;
import com.teamabode.cave_enhancements.block.entity.*;
import com.teamabnormals.blueprint.core.util.registry.BlockEntitySubRegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = CaveEnhancements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlockEntities {

        public static final BlockEntitySubRegistryHelper HELPER = CaveEnhancements.REGISTRY_HELPER.getBlockEntitySubHelper();

        public static final RegistryObject<BlockEntityType<SpectacleCandleBlockEntity>> SPECTACLE_CANDLE = HELPER.createBlockEntity(
                "spectacle_candle",
                SpectacleCandleBlockEntity::new,
                () -> new Block[]{
                        ModBlocks.SPECTACLE_CANDLE.get()
                }
        );

        public static final RegistryObject<BlockEntityType<SpectacleCandleCakeBlockEntity>> SPECTACLE_CANDLE_CAKE = HELPER.createBlockEntity(
                "spectacle_candle_cake",
                SpectacleCandleCakeBlockEntity::new,
                () -> new Block[]{
                        ModBlocks.SPECTACLE_CANDLE_CAKE.get()
                }
        );

        public static final RegistryObject<BlockEntityType<RoseQuartzChimesBlockEntity>> ROSE_QUARTZ_CHIMES = HELPER.createBlockEntity(
                "rose_quartz_chimes",
                RoseQuartzChimesBlockEntity::new,
                () -> new Block[]{
                        ModBlocks.ROSE_QUARTZ_CHIMES.get()
                }
        );

        public static final RegistryObject<BlockEntityType<ReceiverBlockEntity>> RECEIVER = HELPER.createBlockEntity(
                "receiver",
                ReceiverBlockEntity::new,
                () -> new Block[]{
                        ModBlocks.REDSTONE_RECEIVER.get(),
                        ModBlocks.EXPOSED_REDSTONE_RECEIVER.get(),
                        ModBlocks.WEATHERED_REDSTONE_RECEIVER.get(),
                        ModBlocks.OXIDIZED_REDSTONE_RECEIVER.get(),
                        ModBlocks.WAXED_REDSTONE_RECEIVER.get(),
                        ModBlocks.WAXED_EXPOSED_REDSTONE_RECEIVER.get(),
                        ModBlocks.WAXED_WEATHERED_REDSTONE_RECEIVER.get(),
                        ModBlocks.WAXED_OXIDIZED_REDSTONE_RECEIVER.get(),
                }
        );

        public static final RegistryObject<BlockEntityType<LightningAnchorBlockEntity>> LIGHTNING_ANCHOR = HELPER.createBlockEntity(
                "lightning_anchor",
                LightningAnchorBlockEntity::new,
                () -> new Block[]{
                        ModBlocks.LIGHTNING_ANCHOR.get()
                }
        );
}

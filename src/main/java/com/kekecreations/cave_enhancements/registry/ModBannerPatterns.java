package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModBannerPatterns {

    public static final DeferredRegister<BannerPattern> BANNER_PATTERNS = DeferredRegister.create(Registry.BANNER_PATTERN_REGISTRY, CaveEnhancements.MOD_ID);

    public static final RegistryObject<BannerPattern> GOOP = BANNER_PATTERNS.register("goop", () -> new BannerPattern("goop"));

    public static void register(IEventBus event) {
        BANNER_PATTERNS.register(event);
    }
}

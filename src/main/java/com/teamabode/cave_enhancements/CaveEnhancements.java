package com.teamabode.cave_enhancements;

import com.teamabode.cave_enhancements.dispenser.*;
import com.teamabode.cave_enhancements.registry.*;
import com.mojang.logging.LogUtils;
import com.teamabnormals.blueprint.common.world.storage.tracking.DataProcessors;
import com.teamabnormals.blueprint.common.world.storage.tracking.TrackedData;
import com.teamabnormals.blueprint.common.world.storage.tracking.TrackedDataManager;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CaveEnhancements.MOD_ID)
@Mod.EventBusSubscriber(modid = CaveEnhancements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CaveEnhancements
{
    public static final String MOD_ID = "cave_enhancements";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final TrackedData<Integer> REVERSAL_DAMAGE = TrackedData.Builder.create(DataProcessors.INT, () -> 0).enableSaving().build();

    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

    public CaveEnhancements()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        REGISTRY_HELPER.register(modEventBus);

        ModBannerPatterns.register(modEventBus);

        ModEntities.register(modEventBus);

        ModParticles.register(modEventBus);
        ModSounds.register(modEventBus);

        ModFeatures.FEATURES.register(modEventBus);
        ModFeatures.ConfiguredFeatures.CONFIGURED_FEATURES.register(modEventBus);
        ModFeatures.ModPlacedFeatures.PLACED_FEATURES.register(modEventBus);

        ModBiomes.register(modEventBus);
        ModBiomeModifiers.BIOME_MODIIFERS.register(modEventBus);

        ModPotions.register(modEventBus);
        ModEffects.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        TrackedDataManager.INSTANCE.registerData(new ResourceLocation(CaveEnhancements.MOD_ID, "reversal_damage"), REVERSAL_DAMAGE);
        event.enqueueWork(() -> {
            HarmonicArrowDispenseBehavior.register();
            GoopDispenseBehavior.register();
            VolatileGoopDispenseBehavior.register();
            ModSpawnPlacements.register();
            ModPotions.registerRecipes();
        });
    }
}

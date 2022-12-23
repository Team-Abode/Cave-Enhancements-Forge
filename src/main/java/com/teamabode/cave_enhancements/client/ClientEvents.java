package com.teamabode.cave_enhancements.client;

import com.teamabode.cave_enhancements.CaveEnhancements;
import com.teamabode.cave_enhancements.client.model.CruncherModel;
import com.teamabode.cave_enhancements.client.model.DripstonePikeModel;
import com.teamabode.cave_enhancements.client.model.DripstoneTortoiseModel;
import com.teamabode.cave_enhancements.client.model.GoopModel;
import com.teamabode.cave_enhancements.client.particle.*;
import com.teamabode.cave_enhancements.client.renderer.block.RoseQuartzChimesRenderer;
import com.teamabode.cave_enhancements.client.renderer.entity.*;
import com.teamabode.cave_enhancements.core.registry.ModBlockEntities;
import com.teamabode.cave_enhancements.core.registry.ModBlocks;
import com.teamabode.cave_enhancements.core.registry.ModEntities;
import com.teamabode.cave_enhancements.core.registry.ModParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.HugeExplosionParticle;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
@Mod.EventBusSubscriber(modid = CaveEnhancements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GOOP_SPLAT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRIPPING_GOOP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLOW_SPLOTCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.JAGGED_ROSE_QUARTZ.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.REDSTONE_RECEIVER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.REDSTONE_RECEIVER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_REDSTONE_RECEIVER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_REDSTONE_RECEIVER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OXIDIZED_REDSTONE_RECEIVER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_REDSTONE_RECEIVER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_REDSTONE_RECEIVER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_REDSTONE_RECEIVER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_OXIDIZED_REDSTONE_RECEIVER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROSE_QUARTZ_CHIMES.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.SMALL_GOOP_DRIP.get(),
                SmallGoopDripParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.HARMONIC_WAVE.get(),
                HarmonicWaveParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.SOOTHING_NOTE.get(),
                SoothingNoteParticle.SoothingNoteFactory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.SHIMMER.get(),
                ShimmerParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.STAGNANT_SHIMMER.get(),
                StagnantParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.ROSE_CHIME.get(),
                RoseChimeParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.SHOCKWAVE.get(),
                ShockwaveParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.CHARGE.get(),
                StagnantParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.GOOP_EXPLOSION.get(),
                HugeExplosionParticle.Provider::new);
    }


    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Entity Renderers
        event.registerEntityRenderer(ModEntities.GOOP.get(), GoopRenderer::new);
        event.registerEntityRenderer(ModEntities.HARMONIC_ARROW.get(), HarmonicArrowRenderer::new);
        event.registerEntityRenderer(ModEntities.BIG_GOOP_DRIP.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntities.DRIPSTONE_TORTOISE.get(), DripstoneTortoiseRenderer::new);
        event.registerEntityRenderer(ModEntities.DRIPSTONE_PIKE.get(), DripstonePikeRenderer::new);
        event.registerEntityRenderer(ModEntities.CRUNCHER.get(), CruncherRenderer::new);
        event.registerEntityRenderer(ModEntities.THROWN_GOOP.get(), ThrownItemRenderer::new);

        // Block Entity Renderers
        event.registerBlockEntityRenderer(ModBlockEntities.ROSE_QUARTZ_CHIMES.get(), RoseQuartzChimesRenderer::new);

    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // Entity Layers
        event.registerLayerDefinition(GoopModel.ENTITY_MODEL_LAYER, GoopModel::getTexturedModelData);
        event.registerLayerDefinition(DripstonePikeModel.LAYER_LOCATION, DripstonePikeModel::getTexturedModelData);
        event.registerLayerDefinition(DripstoneTortoiseModel.LAYER_LOCATION, DripstoneTortoiseModel::createBodyLayer);
        event.registerLayerDefinition(CruncherModel.LAYER_LOCATION, CruncherModel::createBodyLayer);

        // Block Entity Layers
        event.registerLayerDefinition(RoseQuartzChimesRenderer.LAYER_LOCATION, RoseQuartzChimesRenderer::createLayer);

    }
}

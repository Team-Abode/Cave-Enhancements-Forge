package com.kekecreations.cave_enhancements.client;

import com.kekecreations.cave_enhancements.client.model.CruncherModel;
import com.kekecreations.cave_enhancements.client.model.DripstonePikeModel;
import com.kekecreations.cave_enhancements.client.model.DripstoneTortoiseModel;
import com.kekecreations.cave_enhancements.client.model.GoopModel;
import com.kekecreations.cave_enhancements.client.renderer.blockentity.RoseQuartzChimesBlockEntityRenderer;
import com.kekecreations.cave_enhancements.client.renderer.entity.*;
import com.kekecreations.cave_enhancements.entity.DripstonePike;
import com.kekecreations.cave_enhancements.particle.*;
import com.kekecreations.cave_enhancements.registry.ModBlockEntities;
import com.kekecreations.cave_enhancements.registry.ModBlocks;
import com.kekecreations.cave_enhancements.registry.ModEntities;
import com.kekecreations.cave_enhancements.registry.ModParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@Mod.EventBusSubscriber(modid = "cave_enhancements", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {


    @SubscribeEvent
    @ParametersAreNonnullByDefault
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GOOP_SPLAT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRIPPING_GOOP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLOW_SPLOTCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.JAGGED_ROSE_QUARTZ.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.SMALL_GOOP_DRIP.get(),
                SmallGoopDripParticle.SmallGoopDripFactory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.HOVERING_NOTE.get(),
                HoveringNoteParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.AMETHYST_BLAST.get(),
                AmethystBlastParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.SOOTHING_NOTE.get(),
                SoothingNoteParticle.SoothingNoteFactory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.ROSE_QUARTZ_AURA.get(),
                RoseQuartzAuraParticle.RoseQuartzFactory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.ROSE_CHIMES.get(),
                RoseChimesParticle.RoseChimesFactory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.SHOCKWAVE.get(),
                ShockwaveParticle.Factory::new);
    }


    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // ENTITIES
        event.registerEntityRenderer(ModEntities.GOOP.get(), GoopRenderer::new);
        event.registerEntityRenderer(ModEntities.HARMONIC_ARROW.get(), HarmonicArrowRenderer::new);
        event.registerEntityRenderer(ModEntities.BIG_GOOP_DRIP_PROJECTILE_ENTITY.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntities.DRIPSTONE_TORTOISE.get(), DripstoneTortoiseRenderer::new);
        event.registerEntityRenderer(ModEntities.DRIPSTONE_PIKE.get(), DripstonePikeRenderer::new);
        event.registerEntityRenderer(ModEntities.CRUNCHER.get(), CruncherRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.ROSE_QUARTZ_CHIMES_BLOCK_ENTITY.get(), RoseQuartzChimesBlockEntityRenderer::new);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(GoopModel.ENTITY_MODEL_LAYER, GoopModel::getTexturedModelData);
        event.registerLayerDefinition(DripstonePikeModel.ENTITY_MODEL_LAYER, DripstonePikeModel::getTexturedModelData);
        event.registerLayerDefinition(DripstoneTortoiseModel.ENTITY_MODEL_LAYER, DripstoneTortoiseModel::getTexturedModelData);
        event.registerLayerDefinition(CruncherModel.ENTITY_MODEL_LAYER, CruncherModel::getTexturedModelData);
        event.registerLayerDefinition(RoseQuartzChimesBlockEntityRenderer.LAYER_LOCATION, RoseQuartzChimesBlockEntityRenderer::getTexturedModelData);

    }
}

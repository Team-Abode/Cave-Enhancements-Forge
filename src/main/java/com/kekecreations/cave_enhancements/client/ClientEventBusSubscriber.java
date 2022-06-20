package com.kekecreations.cave_enhancements.client;

import com.kekecreations.cave_enhancements.client.model.GoopModel;
import com.kekecreations.cave_enhancements.client.renderer.entity.GoopRenderer;
import com.kekecreations.cave_enhancements.particle.SmallGoopDripParticle;
import com.kekecreations.cave_enhancements.registry.ModBlocks;
import com.kekecreations.cave_enhancements.registry.ModEntities;
import com.kekecreations.cave_enhancements.registry.ModParticles;
import net.minecraft.client.Minecraft;
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
        ModBlocks.registerClient();
        ModParticles.registerClient();
    }

    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.SMALL_GOOP_DRIP.get(),
                SmallGoopDripParticle.SmallGoopDripFactory::new);
    }


    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // ENTITIES
        event.registerEntityRenderer(ModEntities.GOOP.get(), GoopRenderer::new);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(GoopModel.ENTITY_MODEL_LAYER, GoopModel::getTexturedModelData);

    }
}

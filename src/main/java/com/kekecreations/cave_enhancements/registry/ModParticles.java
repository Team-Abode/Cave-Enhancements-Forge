package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.particle.SmallGoopDripParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, CaveEnhancements.MOD_ID);

    public static final RegistryObject<SimpleParticleType> SMALL_GOOP_DRIP =
            PARTICLE_TYPES.register("small_goop_drip", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> AMETHYST_BLAST =
            PARTICLE_TYPES.register("amethyst_blast", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SOOTHING_NOTE =
            PARTICLE_TYPES.register("soothing_note", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> HOVERING_NOTE =
            PARTICLE_TYPES.register("hovering_note", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> ROSE_QUARTZ_AURA =
            PARTICLE_TYPES.register("rose_quartz_aura", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SHOCKWAVE =
            PARTICLE_TYPES.register("shockwave", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> ROSE_CHIMES =
            PARTICLE_TYPES.register("rose_chimes", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> GOOP_EXPLOSION =
            PARTICLE_TYPES.register("goop_explosion", () -> new SimpleParticleType(true));



    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }

}

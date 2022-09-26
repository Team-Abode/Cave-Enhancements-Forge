package com.teamabode.cave_enhancements.registry;

import com.teamabode.cave_enhancements.CaveEnhancements;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, CaveEnhancements.MOD_ID);

    public static final RegistryObject<SimpleParticleType> SMALL_GOOP_DRIP =
            PARTICLE_TYPES.register("small_goop_drip", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> HARMONIC_WAVE =
            PARTICLE_TYPES.register("harmonic_wave", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SOOTHING_NOTE =
            PARTICLE_TYPES.register("soothing_note", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> HARMONIC_NOTE =
            PARTICLE_TYPES.register("harmonic_note", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SHIMMER =
            PARTICLE_TYPES.register("shimmer", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> STAGNANT_SHIMMER =
            PARTICLE_TYPES.register("stagnant_shimmer", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SHOCKWAVE =
            PARTICLE_TYPES.register("shockwave", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> CHARGE =
            PARTICLE_TYPES.register("charge", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> ROSE_CHIME =
            PARTICLE_TYPES.register("rose_chime", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> GOOP_EXPLOSION =
            PARTICLE_TYPES.register("goop_explosion", () -> new SimpleParticleType(true));



    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }

}

package com.teamabode.cave_enhancements.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.ParametersAreNonnullByDefault;

public class SoothingNoteParticle extends SimpleAnimatedParticle {


    public SoothingNoteParticle(ClientLevel world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteSet spriteProvider) {
        super(world, x, y, z, spriteProvider, 0.0F);
        this.xd = velocityX;
        this.yd = velocityY;
        this.zd = velocityZ;
        this.quadSize = 0.25F;
        this.hasPhysics = false;
        this.gravity = 0.1F;
        this.lifetime = 30;
        this.setSpriteFromAge(spriteProvider);

    }

    @ParametersAreNonnullByDefault
    @OnlyIn(Dist.CLIENT)
    public static class SoothingNoteFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteProvider;

        public SoothingNoteFactory(SpriteSet spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType defaultParticleType, ClientLevel clientWorld, double d, double e, double f, double g, double h, double i) {
            return new SoothingNoteParticle(clientWorld, d, e, f, g, h, i, this.spriteProvider);
        }
    }
}

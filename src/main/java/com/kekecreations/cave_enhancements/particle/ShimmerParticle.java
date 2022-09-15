package com.kekecreations.cave_enhancements.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ShimmerParticle extends SimpleAnimatedParticle {
    double velX = -1;
    double velY = -1;
    double velZ = -1;

    ShimmerParticle(ClientLevel world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteSet spriteProvider) {
        super(world, x, y, z, spriteProvider, 0.0F);
        velX = velocityX;
        velY = velocityY;
        velZ = velocityZ;
        this.xd = velX;
        this.yd = velY;
        this.zd = velZ;
        this.quadSize *= 1.5F;
        this.hasPhysics = false;
        this.gravity = 0.0F;
        this.lifetime = 25 * 10;
        this.setSpriteFromAge(spriteProvider);
    }

    @Override
    public void tick() {
        super.tick();

        xd = velX;
        yd = velY;
        zd = velZ;

        float magnitude = 1F;
        float smoothness = 300;

        velX += random.nextIntBetweenInclusive((int) -magnitude, (int) magnitude) / smoothness;
        velY += random.nextIntBetweenInclusive((int) -magnitude, (int) magnitude) / smoothness;
        velZ += random.nextIntBetweenInclusive((int) -magnitude, (int) magnitude) / smoothness;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteProvider;

        public Factory(SpriteSet spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType defaultParticleType, ClientLevel clientWorld, double d, double e, double f, double g, double h, double i) {
            ShimmerParticle glowParticle = new ShimmerParticle(clientWorld, d, e, f, g, h, i, this.spriteProvider);

            return glowParticle;
        }
    }
}

package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.entity.BigGoopDripProjectile;
import com.kekecreations.cave_enhancements.entity.Goop;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, CaveEnhancements.MOD_ID);

    public static final RegistryObject<EntityType<BigGoopDripProjectile>> BIG_GOOP_DRIP_PROJECTILE_ENTITY =
            ENTITY_TYPES.register("big_goop_drip",
                    () -> EntityType.Builder.<BigGoopDripProjectile>of(BigGoopDripProjectile::new, MobCategory.CREATURE)
                            .sized(0.25f, 0.25f)
                            .setTrackingRange(4)
                            .setUpdateInterval(10)
                            .build(new ResourceLocation(CaveEnhancements.MOD_ID, "big_goop_drip").toString()));


    public static final RegistryObject<EntityType<Goop>> GOOP =
            ENTITY_TYPES.register("goop",
                    () -> EntityType.Builder.of(Goop::new, MobCategory.CREATURE)
                            .sized(0.6f, 0.9f)
                            .build(new ResourceLocation(CaveEnhancements.MOD_ID, "goop").toString()));




    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

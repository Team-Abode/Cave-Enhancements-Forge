package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.entity.HarmonicArrow;
import com.kekecreations.cave_enhancements.entity.cruncher.Cruncher;
import com.kekecreations.cave_enhancements.entity.dripstone_tortoise.DripstonePike;
import com.kekecreations.cave_enhancements.entity.dripstone_tortoise.DripstoneTortoise;
import com.kekecreations.cave_enhancements.entity.goop.BigGoopDripProjectile;
import com.kekecreations.cave_enhancements.entity.goop.Goop;
import com.kekecreations.cave_enhancements.entity.goop.ThrownGoop;
import com.teamabnormals.blueprint.core.util.registry.EntitySubRegistryHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = CaveEnhancements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {

    public static final EntitySubRegistryHelper HELPER = CaveEnhancements.REGISTRY_HELPER.getEntitySubHelper();

    public static final RegistryObject<EntityType<Goop>> GOOP = HELPER.createLivingEntity("goop", Goop::new, MobCategory.AMBIENT, 0.6f, 0.9f);
    public static final RegistryObject<EntityType<DripstoneTortoise>> DRIPSTONE_TORTOISE = HELPER.createLivingEntity("dripstone_tortoise", DripstoneTortoise::new, MobCategory.MONSTER,1.3F, 0.8F);
    public static final RegistryObject<EntityType<Cruncher>> CRUNCHER = HELPER.createLivingEntity("cruncher", Cruncher::new, MobCategory.CREATURE, 0.8F, 0.8F);

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CaveEnhancements.MOD_ID);


    public static final RegistryObject<EntityType<BigGoopDripProjectile>> BIG_GOOP_DRIP =
            ENTITY_TYPES.register("big_goop_drip",
                    () -> EntityType.Builder.<BigGoopDripProjectile>of(BigGoopDripProjectile::new, MobCategory.CREATURE)
                            .sized(0.25f, 0.25f)
                            .clientTrackingRange(4)
                            .setUpdateInterval(10)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(CaveEnhancements.MOD_ID, "big_goop_drip").toString()));


    public static final RegistryObject<EntityType<HarmonicArrow>> HARMONIC_ARROW =
            ENTITY_TYPES.register("harmonic_arrow",
                    () -> EntityType.Builder.<HarmonicArrow>of(HarmonicArrow::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(CaveEnhancements.MOD_ID, "harmonic_arrow").toString()));

    public static final RegistryObject<EntityType<DripstonePike>> DRIPSTONE_PIKE =
            ENTITY_TYPES.register("dripstone_pike",
                    () -> EntityType.Builder.of(DripstonePike::new, MobCategory.MISC)
                            .sized(0.3f, 0.3f)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(CaveEnhancements.MOD_ID, "dripstone_pike").toString()));

    public static final RegistryObject<EntityType<ThrownGoop>> THROWN_GOOP =
            ENTITY_TYPES.register("thrown_goop",
                    () -> EntityType.Builder.<ThrownGoop>of(ThrownGoop::new, MobCategory.MISC)
                            .sized(0.3F, 0.3F)
                            .clientTrackingRange(4)
                            .setUpdateInterval(10)
                            .build(new ResourceLocation(CaveEnhancements.MOD_ID, "thrown_goop").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    @SubscribeEvent
    public static void appendAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GOOP.get(), Goop.createGoopAttributes().build());
        event.put(ModEntities.DRIPSTONE_TORTOISE.get(), DripstoneTortoise.createDripstoneTortoiseAttributes().build());
        event.put(ModEntities.DRIPSTONE_PIKE.get(), DripstonePike.createDripstonePikeAttributes().build());
        event.put(ModEntities.CRUNCHER.get(), Cruncher.createCruncherAttributes().build());
    }
}

package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.effect.StickingMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CaveEnhancements.MOD_ID);

    public static final RegistryObject<MobEffect> VISCOUS = MOB_EFFECTS.register("viscous",
            () -> new StickingMobEffect(MobEffectCategory.HARMFUL, 0xf0dead).addAttributeModifier(Attributes.MOVEMENT_SPEED, "89266f72-4f61-4151-ac06-104ea9a17f22", -0.5F, AttributeModifier.Operation.MULTIPLY_TOTAL));




    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}

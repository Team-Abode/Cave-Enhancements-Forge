package com.teamabode.cave_enhancements.core.registry;

import com.teamabode.cave_enhancements.CaveEnhancements;
import com.teamabode.cave_enhancements.common.effect.ReversalMobEffect;
import com.teamabode.cave_enhancements.common.effect.ViscousMobEffect;
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

    public static final RegistryObject<MobEffect> STICKY = MOB_EFFECTS.register("sticky",
            () -> new ViscousMobEffect(MobEffectCategory.HARMFUL, 0xf0dead).addAttributeModifier(Attributes.MOVEMENT_SPEED, "89266f72-4f61-4151-ac06-104ea9a17f22", -0.15F, AttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(Attributes.ATTACK_SPEED, "202186ab-317b-4064-a731-135065f562c8", -0.15F, AttributeModifier.Operation.MULTIPLY_TOTAL));

    public static final RegistryObject<MobEffect> REVERSAL = MOB_EFFECTS.register("reversal",
            () -> new ReversalMobEffect(MobEffectCategory.BENEFICIAL, 0xf7addc));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}

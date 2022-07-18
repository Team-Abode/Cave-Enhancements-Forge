package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.effect.EasingStatusEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CaveEnhancements.MOD_ID);

    public static final RegistryObject<MobEffect> EASING = MOB_EFFECTS.register("easing",
            () -> new EasingStatusEffect(MobEffectCategory.BENEFICIAL, 0xf7addc));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}

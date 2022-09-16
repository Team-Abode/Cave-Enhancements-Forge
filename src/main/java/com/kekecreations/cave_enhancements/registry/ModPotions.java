package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.teamabnormals.blueprint.core.util.DataUtil;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ModPotions {

    public static void registerRecipes() {
        DataUtil.addMix(Potions.AWKWARD, ModItems.ROSE_QUARTZ.get(), REVERSAL.get());
        DataUtil.addMix(REVERSAL.get(), Items.REDSTONE, LONG_REVERSAL.get());
    }

    public static void register(IEventBus bus) {
        POTIONS.register(bus);
    }

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, CaveEnhancements.MOD_ID);

    public static final RegistryObject<Potion> REVERSAL = POTIONS.register("reversal", () -> new Potion(new MobEffectInstance(ModEffects.REVERSAL.get(), 1800)));
    public static final RegistryObject<Potion> LONG_REVERSAL = POTIONS.register("long_reversal", () -> new Potion(new MobEffectInstance(ModEffects.REVERSAL.get(), 3600)));


}

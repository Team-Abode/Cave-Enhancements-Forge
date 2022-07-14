package com.kekecreations.cave_enhancements.registry;

import com.teamabnormals.blueprint.core.util.DataUtil;
import net.minecraft.world.item.alchemy.Potions;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ModBrewingRecipes {

    public static void register() {
        DataUtil.addMix(Potions.AWKWARD, ModItems.GOOP.get(), Potions.SLOWNESS);
    }

}

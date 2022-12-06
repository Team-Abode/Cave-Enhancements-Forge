package com.teamabode.cave_enhancements.common.item;

import com.teamabode.cave_enhancements.common.entity.HarmonicArrow;
import com.teamabnormals.blueprint.core.util.item.filling.TargetedItemCategoryFiller;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class HarmonicArrowItem extends ArrowItem {
    private static final TargetedItemCategoryFiller FILLER = new TargetedItemCategoryFiller(() -> Items.SPECTRAL_ARROW);

    public HarmonicArrowItem(Properties settings) {
        super(settings);
    }

    public void fillItemCategory(CreativeModeTab pCategory, NonNullList<ItemStack> pItems) {
        FILLER.fillItem(this, pCategory, pItems);
    }

    @Override
    public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity shooter) {
        return new HarmonicArrow(world, shooter);
    }
}

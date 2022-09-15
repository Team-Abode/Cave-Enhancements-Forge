package com.kekecreations.cave_enhancements.dispenser;

import com.kekecreations.cave_enhancements.entity.HarmonicArrow;
import com.kekecreations.cave_enhancements.registry.ModItems;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import org.jetbrains.annotations.NotNull;

public interface HarmonicArrowDispenseBehavior extends DispenseItemBehavior {

    static void register() {
        DispenserBlock.registerBehavior(ModItems.HARMONIC_ARROW.get(), new AbstractProjectileDispenseBehavior() {

            @Override
            protected @NotNull Projectile getProjectile(Level worldIn, Position position, ItemStack stackIn) {
                AbstractArrow arrow = new HarmonicArrow(worldIn, position.x(), position.y(), position.z());
                arrow.pickup = AbstractArrow.Pickup.ALLOWED;
                return arrow;
            }
            @Override
            protected float getPower() {
                return 1.0F;
            }
        });
    }
}

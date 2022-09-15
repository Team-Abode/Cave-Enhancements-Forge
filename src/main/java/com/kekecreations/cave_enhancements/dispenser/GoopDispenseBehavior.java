package com.kekecreations.cave_enhancements.dispenser;

import com.kekecreations.cave_enhancements.entity.goop.ThrownGoop;
import com.kekecreations.cave_enhancements.registry.ModItems;
import net.minecraft.Util;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import org.jetbrains.annotations.NotNull;

public interface GoopDispenseBehavior {

    static void register() {
        DispenserBlock.registerBehavior(ModItems.GOOP.get(), new AbstractProjectileDispenseBehavior() {

            @Override
            protected @NotNull Projectile getProjectile(Level worldIn, Position position, ItemStack stackIn) {
                return Util.make(new ThrownGoop(worldIn, position.x(), position.y(), position.z()), (goop) -> goop.setItem(stackIn));
            }
            @Override
            protected float getPower() {
                return 1.0F;
            }
        });
    }
}

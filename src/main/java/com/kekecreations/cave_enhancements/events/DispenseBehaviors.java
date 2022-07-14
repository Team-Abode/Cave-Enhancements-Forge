package com.kekecreations.cave_enhancements.events;

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

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface DispenseBehaviors extends DispenseItemBehavior {

    static void register() {
        DispenserBlock.registerBehavior(ModItems.HARMONIC_ARROW.get(), new AbstractProjectileDispenseBehavior() {
            /**
             * Return the projectile entity spawned by this dispense behavior.
             */
            @Override
            protected @NotNull Projectile getProjectile(Level worldIn, Position position, ItemStack stackIn) {
                AbstractArrow abstractarrowentity = new HarmonicArrow(worldIn, position.x(), position.y(), position.z());
                abstractarrowentity.pickup = AbstractArrow.Pickup.ALLOWED;
                return abstractarrowentity;
            }
                @Override
                protected float getPower() {
                    return 0.5F;
                }
            });
        }
    }

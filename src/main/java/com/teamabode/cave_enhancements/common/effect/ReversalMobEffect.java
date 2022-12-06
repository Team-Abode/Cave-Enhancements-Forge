package com.teamabode.cave_enhancements.common.effect;

import com.teamabode.cave_enhancements.CaveEnhancements;
import com.teamabnormals.blueprint.common.world.storage.tracking.IDataManager;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;

import java.util.Map;

public class ReversalMobEffect extends MobEffect {
    public ReversalMobEffect(MobEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "b0675f38-b536-4dda-b068-dfc145c2016d", 0.0F, AttributeModifier.Operation.ADDITION);
    }

    public MobEffect addAttributeModifier(Attribute attribute, String uuid, double amount, AttributeModifier.Operation operation) {
        return super.addAttributeModifier(attribute, uuid, amount, operation);
    }

    public void addAttributeModifiers(LivingEntity livingEntity, AttributeMap attributeMap, int amplifier) {
        if (!livingEntity.level.isClientSide) {

            for (Map.Entry<Attribute, AttributeModifier> entry : this.getAttributeModifiers().entrySet()) {
                AttributeInstance attributeInstance = attributeMap.getInstance(entry.getKey());

                IDataManager dataManager = (IDataManager) livingEntity;
                int amount = dataManager.getValue(CaveEnhancements.REVERSAL_DAMAGE);

                if (attributeInstance != null) {
                    AttributeModifier attributemodifier = entry.getValue();
                    attributeInstance.removeModifier(attributemodifier);
                    attributeInstance.addPermanentModifier(new AttributeModifier(attributemodifier.getId(), "Reversal Boost", amount, attributemodifier.getOperation()));
                }
            }
        }
    }

    public void applyEffectTick(LivingEntity entity, int amplifier) {
        this.addAttributeModifiers(entity, entity.getAttributes(), amplifier);
    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

}

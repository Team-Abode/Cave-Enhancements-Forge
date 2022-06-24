package com.kekecreations.cave_enhancements.client.renderer.entity;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.entity.HarmonicArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class HarmonicArrowRenderer extends ArrowRenderer<HarmonicArrow> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(CaveEnhancements.MOD_ID, "textures/entity/harmonic_arrow.png");

    public HarmonicArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(HarmonicArrow entity) {
        return TEXTURE;
    }
}

package com.kekecreations.cave_enhancements.client.renderer.entity;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.client.model.GoopModel;
import com.kekecreations.cave_enhancements.entity.Goop;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GoopRenderer extends MobRenderer<Goop, GoopModel<Goop>> {
    public GoopRenderer(EntityRendererProvider.Context context) {
        super(context, new GoopModel<>(context.bakeLayer(GoopModel.ENTITY_MODEL_LAYER)), 0.5f);
    }

    public static final ResourceLocation TEXTURE = new ResourceLocation(CaveEnhancements.MOD_ID, "textures/entity/goop.png");

    @Override
    public ResourceLocation getTextureLocation(Goop entity) {
        return TEXTURE;
    }
}

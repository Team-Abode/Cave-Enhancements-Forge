package com.kekecreations.cave_enhancements.client.renderer.entity;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.client.model.CruncherModel;
import com.kekecreations.cave_enhancements.client.renderer.entity.layers.CruncherHeldItemLayer;
import com.kekecreations.cave_enhancements.entity.cruncher.Cruncher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CruncherRenderer extends MobRenderer<Cruncher, CruncherModel<Cruncher>> {
    public CruncherRenderer(EntityRendererProvider.Context context) {
        super(context, new CruncherModel<>(context.bakeLayer(CruncherModel.ENTITY_MODEL_LAYER)), 0.5f);
        this.addLayer(new CruncherHeldItemLayer(this, context.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(@NotNull Cruncher entity) {
        return new ResourceLocation(CaveEnhancements.MOD_ID, "textures/entity/cruncher/cruncher.png");
    }
}

package com.kekecreations.cave_enhancements.client.model;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import com.kekecreations.cave_enhancements.client.animation.DripstoneTortoiseAnimation;
import com.kekecreations.cave_enhancements.entity.dripstone_tortoise.DripstonePike;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class DripstonePikeModel<T extends DripstonePike> extends HierarchicalModel<T> {
    public static final ModelLayerLocation ENTITY_MODEL_LAYER = new ModelLayerLocation(new ResourceLocation(CaveEnhancements.MOD_ID, "dripstone_pike"), "main");
    private final ModelPart root;
    private final ModelPart pike;

    public DripstonePikeModel(ModelPart root) {
        this.root = root.getChild("root");
        this.pike = this.root.getChild("pike");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition pike = root.addOrReplaceChild("pike", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = pike.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 48.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r2 = pike.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 48.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 48);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }


    @Override
    public void setupAnim(T entity, float f, float g, float h, float i, float j) {
        this.root.getAllParts().forEach(ModelPart::resetPose);
        this.animate(entity.risingAnimationState, DripstoneTortoiseAnimation.RISING, h);
    }
}

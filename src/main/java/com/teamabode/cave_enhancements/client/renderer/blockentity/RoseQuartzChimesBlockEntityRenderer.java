package com.teamabode.cave_enhancements.client.renderer.blockentity;

import com.teamabode.cave_enhancements.CaveEnhancements;
import com.teamabode.cave_enhancements.block.entity.RoseQuartzChimesBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class RoseQuartzChimesBlockEntityRenderer implements BlockEntityRenderer<RoseQuartzChimesBlockEntity> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(CaveEnhancements.MOD_ID, "entity/rose_quartz_chimes/chime");

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(CaveEnhancements.MOD_ID, "rose_quartz_chimes"), "main");
    private final ModelPart chimes;
    private final ModelPart chime0;
    private final ModelPart chime1;
    private final ModelPart chime2;
    private final ModelPart chime3;
    private final ModelPart chime4;
    private final ModelPart chime5;

    public RoseQuartzChimesBlockEntityRenderer(Context ctx) {
        ModelPart modelPart = ctx.bakeLayer(LAYER_LOCATION);
        this.chimes = modelPart.getChild("chimes");
        this.chime0 = this.chimes.getChild("chime0");
        this.chime1 = this.chimes.getChild("chime1");
        this.chime2 = this.chimes.getChild("chime2");
        this.chime3 = this.chimes.getChild("chime3");
        this.chime4 = this.chimes.getChild("chime4");
        this.chime5 = this.chimes.getChild("chime5");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition chimes = partdefinition.addOrReplaceChild("chimes", CubeListBuilder.create(), PartPose.offset(8.0F, 12.0F, 8.0F));

        PartDefinition chime0 = chimes.addOrReplaceChild("chime0", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(0.0F, 0.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, -5.0F));

        PartDefinition chime1 = chimes.addOrReplaceChild("chime1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(0.0F, 0.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 0.0F));

        PartDefinition chime2 = chimes.addOrReplaceChild("chime2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(0.0F, 0.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 5.0F));

        PartDefinition chime3 = chimes.addOrReplaceChild("chime3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(0.0F, 0.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 0.0F, -5.0F));

        PartDefinition chime4 = chimes.addOrReplaceChild("chime4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(0.0F, 0.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 0.0F, 0.0F));

        PartDefinition chime5 = chimes.addOrReplaceChild("chime5", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(0.0F, 0.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 0.0F, 5.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    public void render(RoseQuartzChimesBlockEntity entity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        this.chimes.xRot = 3.141592653589793F;
        float age = entity.ticks + (tickDelta / 10);

        float rot = Mth.sin(age / 3.1415927F) / 15F;


        this.chime0.zRot = rot;
        this.chime1.zRot = rot;
        this.chime2.zRot = rot;
        this.chime3.zRot = rot;
        this.chime4.zRot = rot;
        this.chime5.zRot = rot;



        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderType.entityCutoutNoCull(TEXTURE));
        this.chimes.render(matrices, vertexConsumer, light, overlay);
    }
}

package net.oliver259.tutorialmod.entity.client;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.oliver259.tutorialmod.TutorialMod;
import net.oliver259.tutorialmod.entity.custom.SnowmanEntity;

// Snowman model and animations were made by following the tutorial by MoreByKev https://www.youtube.com/watch?v=7nZx5hqr_1s
public class SnowmanModel<T extends SnowmanEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "snowman"), "main");
	private final ModelPart root;
	private final ModelPart base;
	private final ModelPart middle;
	private final ModelPart left_arm;
	private final ModelPart left_elbow;
	private final ModelPart left_hand;
	private final ModelPart left_thumb;
	private final ModelPart left_thum_tip;
	private final ModelPart left_pointy;
	private final ModelPart left_pointy_tip;
	private final ModelPart left_pinkie;
	private final ModelPart left_pinkie_tip;
	private final ModelPart right_arm;
	private final ModelPart right_elbow;
	private final ModelPart right_hand;
	private final ModelPart right_thumb;
	private final ModelPart right_thum_tip;
	private final ModelPart right_pointy;
	private final ModelPart right_pointy_tip;
	private final ModelPart right_pinkie;
	private final ModelPart right_pinkie_tip;
	private final ModelPart head;
	private final ModelPart carrot_nose;
	private final ModelPart tophat;
	private final ModelPart bottom_tophat;
	private final ModelPart base_tophat;
	private final ModelPart top_tophat;

	public SnowmanModel(ModelPart root) {
		this.root = root.getChild("root");
		this.base = this.root.getChild("base");
		this.middle = this.base.getChild("middle");
		this.left_arm = this.middle.getChild("left_arm");
		this.left_elbow = this.left_arm.getChild("left_elbow");
		this.left_hand = this.left_elbow.getChild("left_hand");
		this.left_thumb = this.left_hand.getChild("left_thumb");
		this.left_thum_tip = this.left_thumb.getChild("left_thum_tip");
		this.left_pointy = this.left_hand.getChild("left_pointy");
		this.left_pointy_tip = this.left_pointy.getChild("left_pointy_tip");
		this.left_pinkie = this.left_hand.getChild("left_pinkie");
		this.left_pinkie_tip = this.left_pinkie.getChild("left_pinkie_tip");
		this.right_arm = this.middle.getChild("right_arm");
		this.right_elbow = this.right_arm.getChild("right_elbow");
		this.right_hand = this.right_elbow.getChild("right_hand");
		this.right_thumb = this.right_hand.getChild("right_thumb");
		this.right_thum_tip = this.right_thumb.getChild("right_thum_tip");
		this.right_pointy = this.right_hand.getChild("right_pointy");
		this.right_pointy_tip = this.right_pointy.getChild("right_pointy_tip");
		this.right_pinkie = this.right_hand.getChild("right_pinkie");
		this.right_pinkie_tip = this.right_pinkie.getChild("right_pinkie_tip");
		this.head = this.middle.getChild("head");
		this.carrot_nose = this.head.getChild("carrot_nose");
		this.tophat = this.head.getChild("tophat");
		this.bottom_tophat = this.tophat.getChild("bottom_tophat");
		this.base_tophat = this.tophat.getChild("base_tophat");
		this.top_tophat = this.tophat.getChild("top_tophat");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition base = root.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 66).addBox(-6.0F, -13.0F, -7.0F, 12.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 86).addBox(-4.0F, -11.0F, -8.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 86).addBox(-4.0F, -11.0F, 7.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 70).addBox(-6.0F, -13.0F, 6.0F, 12.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-7.0F, -13.0F, -6.0F, 14.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(52, 70).mirror().addBox(7.0F, -11.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 70).mirror().addBox(-8.0F, -11.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 24).addBox(-6.0F, -14.0F, -6.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 37).addBox(-6.0F, -1.0F, -6.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(86.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition middle = base.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(48, 24).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(70, 70).addBox(-6.0F, -9.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(36, 95).addBox(6.0F, -7.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(36, 95).mirror().addBox(-7.0F, -7.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 79).addBox(5.0F, -9.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(72, 86).addBox(-4.0F, -9.0F, 5.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(88, 20).addBox(-4.0F, -9.0F, -6.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(76, 95).addBox(-2.0F, -7.0F, -7.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 7).addBox(-2.0F, -7.0F, 6.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 0.0F));

		PartDefinition left_arm = middle.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(36, 83).addBox(0.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -8.0F, 0.0F));

		PartDefinition left_elbow = left_arm.addOrReplaceChild("left_elbow", CubeListBuilder.create().texOffs(92, 65).addBox(0.0F, -0.5F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 0.0F, 0.5F));

		PartDefinition left_hand = left_elbow.addOrReplaceChild("left_hand", CubeListBuilder.create().texOffs(10, 95).addBox(0.0F, -0.5F, -1.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 0.0F, -0.5F));

		PartDefinition left_thumb = left_hand.addOrReplaceChild("left_thumb", CubeListBuilder.create().texOffs(18, 79).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, -1.5F));

		PartDefinition left_thum_tip = left_thumb.addOrReplaceChild("left_thum_tip", CubeListBuilder.create().texOffs(10, 99).addBox(-0.5F, -0.6245F, -4.0578F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.1245F, -2.9422F));

		PartDefinition left_pointy = left_hand.addOrReplaceChild("left_pointy", CubeListBuilder.create().texOffs(20, 99).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.0F));

		PartDefinition left_pointy_tip = left_pointy.addOrReplaceChild("left_pointy_tip", CubeListBuilder.create().texOffs(100, 12).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

		PartDefinition left_pinkie = left_hand.addOrReplaceChild("left_pinkie", CubeListBuilder.create().texOffs(100, 16).addBox(0.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.0F, 0.0F));

		PartDefinition left_pinkie_tip = left_pinkie.addOrReplaceChild("left_pinkie_tip", CubeListBuilder.create().texOffs(100, 14).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 0.0F, 0.0F));

		PartDefinition right_arm = middle.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(36, 83).mirror().addBox(-6.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -8.0F, 0.0F));

		PartDefinition right_elbow = right_arm.addOrReplaceChild("right_elbow", CubeListBuilder.create().texOffs(92, 65).mirror().addBox(-6.0157F, -0.5601F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.975F, 0.0F, 0.0F));

		PartDefinition right_hand = right_elbow.addOrReplaceChild("right_hand", CubeListBuilder.create().texOffs(10, 95).mirror().addBox(-2.0F, -0.5F, -1.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0157F, -0.0601F, 0.0F));

		PartDefinition right_thumb = right_hand.addOrReplaceChild("right_thumb", CubeListBuilder.create().texOffs(18, 79).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 0.0F, -1.5F));

		PartDefinition right_thum_tip = right_thumb.addOrReplaceChild("right_thum_tip", CubeListBuilder.create().texOffs(10, 99).mirror().addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition right_pointy = right_hand.addOrReplaceChild("right_pointy", CubeListBuilder.create().texOffs(20, 99).mirror().addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, -1.0F));

		PartDefinition right_pointy_tip = right_pointy.addOrReplaceChild("right_pointy_tip", CubeListBuilder.create().texOffs(100, 12).mirror().addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.6762F, 0.0232F, 0.0F));

		PartDefinition right_pinkie = right_hand.addOrReplaceChild("right_pinkie", CubeListBuilder.create().texOffs(100, 16).mirror().addBox(-3.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 0.0F, 0.0F));

		PartDefinition right_pinkie_tip = right_pinkie.addOrReplaceChild("right_pinkie_tip", CubeListBuilder.create().texOffs(100, 14).mirror().addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, 0.0F, 0.0F));

		PartDefinition head = middle.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 50).addBox(-4.0F, -8.9696F, -3.6527F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(76, 13).addBox(-3.0F, -0.9696F, -2.6527F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(84, 0).addBox(-3.0F, -9.9696F, -2.6527F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 52).addBox(-3.0F, -7.9696F, -4.6527F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(92, 67).addBox(-3.0F, -6.9696F, -5.6527F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 50).addBox(-3.0F, -7.9696F, 4.3473F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(88, 29).addBox(4.0F, -7.9696F, -2.6527F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(88, 29).mirror().addBox(-5.0F, -7.9696F, -2.6527F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition carrot_nose = head.addOrReplaceChild("carrot_nose", CubeListBuilder.create().texOffs(76, 20).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.9696F, -4.6527F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r1 = carrot_nose.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(30, 99).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(0.0F, 0.9F, -3.8F, 0.6109F, 0.0F, 0.0F));

		PartDefinition cube_r2 = carrot_nose.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(26, 66).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -2.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition tophat = head.addOrReplaceChild("tophat", CubeListBuilder.create(), PartPose.offset(0.0F, -8.699F, -0.9896F));

		PartDefinition bottom_tophat = tophat.addOrReplaceChild("bottom_tophat", CubeListBuilder.create().texOffs(48, 44).addBox(-9.5163F, -2.3289F, -6.0F, 10.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5163F, 1.0583F, 1.3369F));

		PartDefinition cube_r3 = bottom_tophat.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(32, 57).mirror().addBox(-4.0F, -2.0F, -6.0F, 3.0F, 1.0F, 12.0F, new CubeDeformation(-0.001F)).mirror(false), PartPose.offsetAndRotation(-9.0326F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r4 = bottom_tophat.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(32, 57).addBox(1.0F, -2.0F, -6.0F, 3.0F, 1.0F, 12.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition base_tophat = tophat.addOrReplaceChild("base_tophat", CubeListBuilder.create().texOffs(52, 0).addBox(-3.0F, -6.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(52, 0).addBox(-3.0F, -6.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(84, 7).addBox(-2.0F, -6.0F, -5.0F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(92, 59).addBox(-2.0F, -6.0F, 4.0F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(90, 82).addBox(5.0F, -6.0F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 41).addBox(-4.0F, -6.0F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -0.2706F, 1.3369F));

		PartDefinition top_tophat = tophat.addOrReplaceChild("top_tophat", CubeListBuilder.create().texOffs(90, 93).addBox(-4.0F, -6.0F, -8.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(52, 13).addBox(-3.0F, -6.0F, -9.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(56, 95).addBox(-2.0F, -6.0F, -10.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 95).addBox(3.0F, -6.0F, -8.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(66, 95).addBox(-2.0F, -6.0F, -3.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.2706F, 7.3369F, 0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 112, 112);
	}

	@Override
	public void setupAnim(SnowmanEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.head.yRot += netHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot += headPitch * ((float)Math.PI / 180F);
		this.animate(entity.idleAnimationState, SnowmanAnimations.ANIM_SNOWMAN_IDLE, ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	@Override
	public ModelPart root() {return root;}
}
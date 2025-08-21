package net.oliver259.tutorialmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.oliver259.tutorialmod.TutorialMod;
import net.oliver259.tutorialmod.entity.custom.SnowmanEntity;

public class SnowmanRenderer extends MobRenderer<SnowmanEntity, SnowmanModel<SnowmanEntity>> {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/snowman/snowman.png");

    public SnowmanRenderer(EntityRendererProvider.Context context) {
        super(context, new SnowmanModel<>(context.bakeLayer(SnowmanModel.LAYER_LOCATION)), 0.5f); // 0.5f is shadow size
    }

    @Override
    public ResourceLocation getTextureLocation(SnowmanEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(SnowmanEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        // Optional: scaling
        poseStack.scale(1.0f, 1.0f, 1.0f);
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
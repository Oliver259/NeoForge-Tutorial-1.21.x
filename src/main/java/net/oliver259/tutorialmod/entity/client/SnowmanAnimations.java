package net.oliver259.tutorialmod.entity.client;// Save this class in your mod and generate all required imports

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

/**
 * Made with Blockbench 4.12.5
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author Author
 */

// Snowman model and animations were made by following the tutorial by MoreByKev https://www.youtube.com/watch?v=7nZx5hqr_1s
public class SnowmanAnimations {
	public static final AnimationDefinition ANIM_SNOWMAN_IDLE = AnimationDefinition.Builder.withLength(4.0F).looping()
		.addAnimation("base", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.5735F, 2.4999F, 0.025F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(2.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(3.2917F, KeyframeAnimations.degreeVec(3.1284F, -0.1326F, 0.8103F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(4.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, -10.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-27.5F, 7.5713F, -19.9753F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(4.0F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, -10.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("left_elbow", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 37.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("left_hand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("left_thumb", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 17.5F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("left_thum_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.4F, -32.3108F, 66.4252F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, -12.67F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(4.0F, KeyframeAnimations.degreeVec(-5.4F, -32.3108F, 66.4252F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("left_pointy", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 25.0F, -10.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-19.089F, 27.6674F, -2.3005F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(3.2917F, KeyframeAnimations.degreeVec(-11.8133F, 25.5186F, -8.5031F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(3.625F, KeyframeAnimations.degreeVec(-24.4218F, 25.4367F, -8.7394F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 25.0F, -10.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("left_pointy_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("left_pinkie", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -17.5F, 20.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("left_pinkie_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 87.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 17.5F, 87.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.7083F, KeyframeAnimations.degreeVec(0.0F, 2.5F, 87.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 20.0F, 87.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-4.5043F, 19.5064F, 74.2254F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 87.5F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 7.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-26.767F, 13.3486F, 34.6177F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(4.0F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 7.5F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("right_elbow", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("right_hand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -12.5F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("right_thum_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(32.5F, 10.0F, -25.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.375F, KeyframeAnimations.degreeVec(18.705F, 17.2732F, -20.1003F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.5833F, KeyframeAnimations.degreeVec(33.8876F, 18.3752F, -19.3579F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.6667F, KeyframeAnimations.degreeVec(32.7634F, 12.1055F, -23.6265F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.75F, KeyframeAnimations.degreeVec(33.8876F, 18.3752F, -19.3579F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.8333F, KeyframeAnimations.degreeVec(32.7634F, 12.1055F, -23.6265F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(4.0F, KeyframeAnimations.degreeVec(32.5F, 10.0F, -25.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("right_pointy", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("right_pointy_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -50.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -22.5F, -50.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 30.0F, -50.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -50.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("right_pointy_tip", new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("right_pinkie", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -37.5F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("right_pinkie_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -17.5F, -27.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-19.0405F, -14.6721F, -22.5771F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-32.5F, -15.2083F, -27.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-27.6828F, -20.7455F, -38.9227F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(2.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(4.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("carrot_nose", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("tophat", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.9811F, 0.4352F, -4.9811F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("tophat", new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.9848F, -0.1736F), AnimationChannel.Interpolations.LINEAR)
		))
		.build();
}
package net.oliver259.tutorialmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

// Climbing Effect by SameDifferent: https://github.com/samedifferent/TrickOrTreat/blob/master/LICENSE
// Distributed under MIT
public class SlimeyEffect extends MobEffect {

    public SlimeyEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    // If the living entity is touching a wall and is crouching stick to the wall
    // (player must be still moving towards the wall while crouching to stick to it)
    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if(livingEntity.horizontalCollision) {
            if(!livingEntity.isCrouching()) {
                Vec3 initialVec = livingEntity.getDeltaMovement();
                Vec3 climbVec = new Vec3(initialVec.x, 0.2D, initialVec.z);
                livingEntity.setDeltaMovement(climbVec.scale(0.96D));
            } else {
                Vec3 stoppedVec = new Vec3(livingEntity.getDeltaMovement().x, 0.0D, livingEntity.getDeltaMovement().z);
                livingEntity.setDeltaMovement(stoppedVec);
            }
            return true;
        }

        return super.applyEffectTick(livingEntity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}

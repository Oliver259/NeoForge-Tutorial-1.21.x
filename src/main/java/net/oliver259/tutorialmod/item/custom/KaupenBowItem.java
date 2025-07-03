package net.oliver259.tutorialmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KaupenBowItem extends BowItem {
    public KaupenBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.tutorialmod.kaupen_bow.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    protected Projectile createProjectile(Level level, LivingEntity shooter, ItemStack weapon, ItemStack ammo, boolean isCrit) {
        Projectile projectile = super.createProjectile(level, shooter, weapon, ammo, isCrit);

        if (projectile instanceof AbstractArrow arrow) {
            arrow.setBaseDamage(arrow.getBaseDamage() + 2.5); // Add 2.5 extra damage (5 half-hearts)
            arrow.setCritArrow(isCrit);

            arrow.addTag("kaupen_glow_arrow");
        }
        return projectile;
    }
}

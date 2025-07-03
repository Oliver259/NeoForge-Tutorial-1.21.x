package net.oliver259.tutorialmod.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.oliver259.tutorialmod.TutorialMod;
import net.oliver259.tutorialmod.component.ModDataComponents;
import net.oliver259.tutorialmod.item.ModItems;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "used"),
                (stack, level, entity, seed) -> stack.get(ModDataComponents.COORDINATES) != null ? 1f : 0f);
    }
}

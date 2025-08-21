package net.oliver259.tutorialmod.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.oliver259.tutorialmod.TutorialMod;
import net.oliver259.tutorialmod.entity.custom.GeckoEntity;
import net.oliver259.tutorialmod.entity.custom.SnowmanEntity;
import net.oliver259.tutorialmod.entity.custom.TomahawkProjectileEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, TutorialMod.MOD_ID);

    public static final Supplier<EntityType<GeckoEntity>> GECKO =
            ENTITY_TYPES.register("gecko", () -> EntityType.Builder.of(GeckoEntity::new, MobCategory.CREATURE)
                    .sized(0.70f, 0.35f).build("gecko"));

    public static final Supplier<EntityType<TomahawkProjectileEntity>> TOMMAHAWK =
            ENTITY_TYPES.register("tomahawk", () -> EntityType.Builder.<TomahawkProjectileEntity>of(TomahawkProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build("tomahawk"));

    public static final Supplier<EntityType<SnowmanEntity>> SNOWMAN =
            ENTITY_TYPES.register("snowman", () -> EntityType.Builder.of(SnowmanEntity::new, MobCategory.MONSTER)
                    .sized(0.9f, 2.8f).build("snowman"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

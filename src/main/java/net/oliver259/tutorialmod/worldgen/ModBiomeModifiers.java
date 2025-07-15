package net.oliver259.tutorialmod.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.oliver259.tutorialmod.TutorialMod;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_BISMUTH_ORE = registerKey("add_bismuth_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_BISMUTH_ORE = registerKey("add_nether_bismuth_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_BISMUTH_ORE = registerKey("add_end_bismuth_ore");

    public static final ResourceKey<BiomeModifier> ADD_TREE_BLOODWOOD = registerKey("add_tree_bloodwood");

    public static final ResourceKey<BiomeModifier> ADD_GOJI_BERRY_BUSH = registerKey("add_goji_berry_bush");
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        // Configured Features -> Placed Features -> Biome Modifiers
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_BISMUTH_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BISMUTH_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

//        // Example for individual biomes
//        context.register(ADD_BISMUTH_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SAVANNA)),
//                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BISMUTH_ORE_PLACED_KEY)),
//                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_BISMUTH_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_BISMUTH_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));


        context.register(ADD_END_BISMUTH_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_BISMUTH_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_TREE_BLOODWOOD, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SAVANNA)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BLOODWOOD_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_GOJI_BERRY_BUSH, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.GOJI_BERRY_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }
}

package net.oliver259.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.oliver259.tutorialmod.TutorialMod;
import net.oliver259.tutorialmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(getAllBismuthBlocks());

        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get());

        tag(BlockTags.FENCES).add(ModBlocks.BISMUTH_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.BISMUTH_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.BISMUTH_WALL.get());
    }

    /**
     * Automatically collects all Bismuth-related blocks from ModBlocks.
     */
    private Block[] getAllBismuthBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream()
                .map(entry -> (Block) entry.get()) // Explicit cast to Block
                .filter(block -> block.getName().getString().toLowerCase().contains("bismuth")) // Use getName() instead
                .toArray(Block[]::new); // Correct array conversion
    }

}
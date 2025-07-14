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
import net.oliver259.tutorialmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(getAllBismuthBlocks());
        tag(BlockTags.NEEDS_IRON_TOOL).add(getAllBismuthBlocks());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.FENCES).add(ModBlocks.BISMUTH_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.BISMUTH_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.BISMUTH_WALL.get());

        tag(ModTags.Blocks.NEEDS_BISMUTH_TOOL)
                .add(ModBlocks.BISMUTH_LAMP.get())
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_BISMUTH_TOOL);

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLOODWOOD_LOG.get())
                .add(ModBlocks.BLOODWOOD_WOOD.get())
                .add(ModBlocks.STRIPPED_BLOODWOOD_LOG.get())
                .add(ModBlocks.STRIPPED_BLOODWOOD_WOOD.get());
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
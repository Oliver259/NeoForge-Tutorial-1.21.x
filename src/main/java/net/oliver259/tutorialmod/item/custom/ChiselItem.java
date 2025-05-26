package net.oliver259.tutorialmod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.oliver259.tutorialmod.block.ModBlocks;

import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.ofEntries(
                    // COBBLESTONE
                    Map.entry(Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE),
                    Map.entry(Blocks.MOSSY_COBBLESTONE, Blocks.COBBLESTONE),
                    // STONE
                    Map.entry(Blocks.STONE, Blocks.STONE_BRICKS),
                    Map.entry(Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS),
                    Map.entry(Blocks.MOSSY_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS),
                    Map.entry(Blocks.CHISELED_STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS),
                    Map.entry(Blocks.CRACKED_STONE_BRICKS, Blocks.STONE),
                    // END STONE
                    Map.entry(Blocks.END_STONE, Blocks.END_STONE_BRICKS),
                    Map.entry(Blocks.END_STONE_BRICKS, Blocks.END_STONE),
                    // DEEPSLATE
                    Map.entry(Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS),
                    Map.entry(Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS),
                    Map.entry(Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.CHISELED_DEEPSLATE),
                    Map.entry(Blocks.CHISELED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE),
                    Map.entry(Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_TILES),
                    Map.entry(Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES),
                    Map.entry(Blocks.CRACKED_DEEPSLATE_TILES, Blocks.REINFORCED_DEEPSLATE),
                    Map.entry(Blocks.REINFORCED_DEEPSLATE, Blocks.DEEPSLATE),
                    // MUD
                    Map.entry(Blocks.MUD, Blocks.MUD_BRICKS),
                    Map.entry(Blocks.MUD_BRICKS, Blocks.MUD),
                    // NETHERRACK
                    Map.entry(Blocks.NETHERRACK, Blocks.NETHER_BRICKS),
                    Map.entry(Blocks.NETHER_BRICKS, Blocks.CHISELED_NETHER_BRICKS),
                    Map.entry(Blocks.CHISELED_NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS),
                    Map.entry(Blocks.CRACKED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS),
                    Map.entry(Blocks.RED_NETHER_BRICKS, Blocks.NETHERRACK),
                    // BLACKSTONE
                    Map.entry(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE),
                    Map.entry(Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS),
                    Map.entry(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CHISELED_POLISHED_BLACKSTONE),
                    Map.entry(Blocks.CHISELED_POLISHED_BLACKSTONE, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS),
                    Map.entry(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE),
                    // PRISMARINE
                    Map.entry(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS),
                    Map.entry(Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE),
                    // TUFF
                    Map.entry(Blocks.TUFF, Blocks.TUFF_BRICKS),
                    Map.entry(Blocks.TUFF_BRICKS, Blocks.CHISELED_TUFF),
                    Map.entry(Blocks.CHISELED_TUFF, Blocks.POLISHED_TUFF),
                    Map.entry(Blocks.POLISHED_TUFF, Blocks.TUFF),
                    // GRANITE
                    Map.entry(Blocks.GRANITE, Blocks.POLISHED_GRANITE),
                    Map.entry(Blocks.POLISHED_GRANITE, Blocks.GRANITE),
                    // DIORITE
                    Map.entry(Blocks.DIORITE, Blocks.POLISHED_DIORITE),
                    Map.entry(Blocks.POLISHED_DIORITE, Blocks.DIORITE),
                    // ANDESITE
                    Map.entry(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE),
                    Map.entry(Blocks.POLISHED_ANDESITE, Blocks.ANDESITE),
                    // SANDSTONE
                    Map.entry(Blocks.SANDSTONE, Blocks.SMOOTH_SANDSTONE),
                    Map.entry(Blocks.SMOOTH_SANDSTONE, Blocks.CUT_SANDSTONE),
                    Map.entry(Blocks.CUT_SANDSTONE, Blocks.CHISELED_SANDSTONE),
                    Map.entry(Blocks.CHISELED_SANDSTONE, Blocks.SANDSTONE),
                    // RED SANDSTONE
                    Map.entry(Blocks.RED_SANDSTONE, Blocks.SMOOTH_SANDSTONE),
                    Map.entry(Blocks.SMOOTH_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE),
                    Map.entry(Blocks.CUT_RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE),
                    Map.entry(Blocks.CHISELED_RED_SANDSTONE, Blocks.RED_SANDSTONE),

                    Map.entry(Blocks.ANCIENT_DEBRIS, ModBlocks.BISMUTH_BLOCK.get())
            );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    private Block getReversedBlock(Block block) {
        for (Map.Entry<Block, Block> entry : CHISEL_MAP.entrySet()) {
            if (entry.getValue() == block) {
                return entry.getKey();
            }
        }
        return null; // No reverse mapping found
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        boolean isCrouching = context.getPlayer() != null && context.getPlayer().isShiftKeyDown();

        // Reverse map lookup if crouching
        Block newBlock = isCrouching ? getReversedBlock(clickedBlock) : CHISEL_MAP.get(clickedBlock);

        if (newBlock != null) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), newBlock.defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.SUCCESS;
    }
//    // To make an item drinkable
//    @Override
//    public UseAnim getUseAnimation(ItemStack stack) {
//        return UseAnim.DRINK;
//    }
}

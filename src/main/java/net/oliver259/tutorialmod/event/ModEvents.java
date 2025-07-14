package net.oliver259.tutorialmod.event;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundEntityEventPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.oliver259.tutorialmod.TutorialMod;
import net.oliver259.tutorialmod.item.custom.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.oliver259.tutorialmod.potion.ModPotions;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos.equals(initialBlockPos) || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void onArrowHit(LivingDamageEvent.Post event) {
        if (event.getSource().getDirectEntity() instanceof AbstractArrow arrow &&
                arrow.getTags().contains("kaupen_glow_arrow") &&
                event.getEntity() instanceof LivingEntity target) {
            target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 0)); // 10 seconds
        }
    }

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre event) {
        if(event.getEntity() instanceof LivingEntity target && event.getSource().getDirectEntity() instanceof Player player) {
            ItemStack mainHandItem = getMainHandItem(player);
            if(mainHandItem.getItem() == Items.FLINT_AND_STEEL) {
                if(event.getEntity() instanceof Creeper creeper) {
                    creeper.ignite();
                } else {
                    target.setRemainingFireTicks(100);
                }

                // Increase damage by 1
                if(!player.isCreative()) {
                int newDamage = mainHandItem.getDamageValue() + 1;

                if (newDamage >= mainHandItem.getMaxDamage()) {
                    // Play item break sound
                    player.level().playSound(
                            null,
                            player.getX(), player.getY(), player.getZ(),
                            SoundEvents.ITEM_BREAK,
                            SoundSource.PLAYERS
                    );

                    // Show break animation
                    player.level().broadcastEntityEvent(player, EntityEvent.MAINHAND_BREAK);

                    // Remove the item
                    player.setItemInHand(player.getUsedItemHand(), ItemStack.EMPTY);
                } else {
                    mainHandItem.setDamageValue(newDamage);
                }

//                player.sendSystemMessage(Component.literal(player.getName().getString() + " ignited " + target.getName().getString() + " with Flint and Steel"));
                }
            }
        }
    }

    private static @NotNull ItemStack getMainHandItem(Player player) {
        return player.getMainHandItem();
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
    }
}
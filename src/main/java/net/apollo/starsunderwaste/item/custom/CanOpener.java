package net.apollo.starsunderwaste.item.custom;


import net.apollo.starsunderwaste.item.ModItems;
import net.apollo.starsunderwaste.util.ModTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = "starsunderwaste", value = Dist.CLIENT)

public class CanOpener extends Item {

    private static final Random RAND = new Random();


    public CanOpener(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pUsedHand != InteractionHand.OFF_HAND) {
            return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
        }


        if (!pLevel.isClientSide) {

            ItemStack mainHandStack = pPlayer.getMainHandItem();
            Item mainHandItem = mainHandStack.getItem();

            if (mainHandItem.builtInRegistryHolder().is(ModTags.Items.MRE_TYPES)) {
                TagKey<Item> rewardTag = getRewardTagForMRE(mainHandItem);
                if (rewardTag != null) {
                    ItemStack reward = getRandomMREItemFromTag(rewardTag);
                    if (!reward.isEmpty()) {
                        if (!pPlayer.getInventory().add(reward)) {
                            pPlayer.drop(reward, false);
                        }
                    }
                }

                ItemStack offhand = pPlayer.getItemInHand(pUsedHand);
                offhand.hurt(1, RandomSource.create(), null);

                if (!mainHandStack.isEmpty()) {
                    mainHandStack.shrink(1);
                }

                pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                        SoundEvents.ITEM_BREAK, SoundSource.PLAYERS,
                        1.0F, 1.0F + RAND.nextFloat() * 0.4F);
            } else {
                return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
            }
        }

        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }

    public ItemStack getRandomMREItemFromTag(TagKey<Item> tag) {
        List<Item> items = BuiltInRegistries.ITEM.stream().filter(item -> item.builtInRegistryHolder()
                .is(tag)).toList();

        if (items.isEmpty()) {
            return ItemStack.EMPTY;
        }

        return new ItemStack(items.get(RAND.nextInt(items.size())));
    }

    public TagKey<Item> getRewardTagForMRE(Item mreItem) {

        if (mreItem == ModItems.PRESERVED_MRE.get()) {
            return ModTags.Items.BASIC_MRE_ITEMS;
        } else if (mreItem == ModItems.ADVANCED_MRE.get()) {
            return ModTags.Items.ADVANCED_MRE_ITEMS;
        } else if (mreItem == ModItems.ROTTEN_MRE.get()) {
            return ModTags.Items.ROTTEN_MRE_ITEMS;
        }

        return null;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.starsunderwaste.can_opener.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

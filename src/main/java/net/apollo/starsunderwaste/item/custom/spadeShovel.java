package net.apollo.starsunderwaste.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

import static net.apollo.starsunderwaste.util.OreTransformations.ORE_TO_BASE_MAP;
import static net.apollo.starsunderwaste.util.OreTransformations.ORE_TO_DROP_MAP;
import static net.minecraft.world.item.Tiers.NETHERITE;

public class spadeShovel extends ShovelItem {

    public spadeShovel(Item.Properties properties) {
        super(NETHERITE, 1.5f, -3.0f, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        ItemStack toolStack = context.getItemInHand();

        if (!level.isClientSide) {
            BlockState oldState = level.getBlockState(pos);
            Block oldBlock = oldState.getBlock();

            Supplier<Block> baseBlockSupplier = ORE_TO_BASE_MAP.get(oldBlock);
            Supplier<Item> dropItemSupplier = ORE_TO_DROP_MAP.get(oldBlock);

            if (baseBlockSupplier != null) {
                // Replace the block
                Block replacementBlock = baseBlockSupplier.get();
                level.setBlock(pos, replacementBlock.defaultBlockState(), 3);

                // Drop the reward item
                if (dropItemSupplier != null) {
                    int dropAmount = ThreadLocalRandom.current().nextInt(2, 5); // 2 to 4 items
                    ItemStack dropStack = new ItemStack(dropItemSupplier.get(), dropAmount);

                    Vec3 center = Vec3.atCenterOf(pos);
                    ItemEntity itemEntity = new ItemEntity(level, center.x, center.y, center.z, dropStack);
                    level.addFreshEntity(itemEntity);
                }

                // Sound & tool durability
                level.playSound(null, pos, SoundEvents.GRAVEL_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                toolStack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

                return InteractionResult.SUCCESS;
            }

            return InteractionResult.PASS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.starsunderwaste.spade_shovel.tooltip"));
        super.appendHoverText(stack, level, tooltip, flag);
    }
}

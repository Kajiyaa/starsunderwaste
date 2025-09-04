package net.apollo.starsunderwaste.util;

import net.apollo.starsunderwaste.block.ModBlocks;
import net.apollo.starsunderwaste.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;
import java.util.function.Supplier;

public class OreTransformations {

    //adds the base ore block and the resulting changed block, in order

    public static final Map<Block, Supplier<Block>> ORE_TO_BASE_MAP = Map.ofEntries(
            Map.entry(ModBlocks.LIME_SAND_NULLITE_ORE.get(), ModBlocks.LIME_SAND),
            Map.entry(ModBlocks.IRON_GRAVEL_ORE.get(), () -> Blocks.GRAVEL),
            Map.entry(ModBlocks.HARDENED_LIME_SAND_NULLITE_ORE.get(), ModBlocks.HARDENED_LIME_SAND)
    );
    public static final Map<Block, Supplier<Item>> ORE_TO_DROP_MAP = Map.ofEntries(
            Map.entry(ModBlocks.LIME_SAND_NULLITE_ORE.get(), ModItems.NULLITE),
            Map.entry(ModBlocks.HARDENED_LIME_SAND_NULLITE_ORE.get(), ModItems.NULLITE),
            Map.entry(ModBlocks.IRON_GRAVEL_ORE.get(), () -> Items.RAW_IRON)
    );
}

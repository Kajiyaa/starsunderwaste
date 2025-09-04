package net.apollo.starsunderwaste.util;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> IRONWOOD_TYPES = tag("ironwood_types");
        public static final TagKey<Block> NEEDS_NULLITE_TOOL = tag("needs_nullite_tool");
        public static final TagKey<Block> IRONWOOD_GROWABLES = tag("ironwood_growables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Starsunderwaste.MOD_ID, name));

        }
    }

    public static class Items {
        public static final TagKey<Item> BASIC_MRE_ITEMS = tag("basic_mre_items");
        public static final TagKey<Item> ADVANCED_MRE_ITEMS = tag("advanced_mre_items");
        public static final TagKey<Item> ROTTEN_MRE_ITEMS = tag("rotten_mre_items");
        public static final TagKey<Item> MRE_TYPES = tag("mre_types");
        public static final TagKey<Item> IRONWOOD_TYPES = tag("ironwood_types");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Starsunderwaste.MOD_ID, name));
        }
    }
}

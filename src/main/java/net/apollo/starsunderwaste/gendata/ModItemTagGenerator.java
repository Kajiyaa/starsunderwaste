package net.apollo.starsunderwaste.gendata;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.apollo.starsunderwaste.block.ModBlocks;
import net.apollo.starsunderwaste.item.ModItems;
import net.apollo.starsunderwaste.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Starsunderwaste.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Items.MRE_TYPES)
                .add(ModItems.ADVANCED_MRE.get(),
                        ModItems.PRESERVED_MRE.get(),
                        ModItems.ROTTEN_MRE.get());

        this.tag(ModTags.Items.ROTTEN_MRE_ITEMS)
                .add(Items.POISONOUS_POTATO,
                        Items.SPIDER_EYE,
                        Items.SUSPICIOUS_STEW,
                        Items.ROTTEN_FLESH);

        this.tag(ModTags.Items.ADVANCED_MRE_ITEMS)
                .add(Items.GOLDEN_CARROT,
                        Items.GOLDEN_APPLE,
                        Items.ENCHANTED_GOLDEN_APPLE,
                        Items.CAKE,
                        Items.PUMPKIN_PIE);


        this.tag(ModTags.Items.BASIC_MRE_ITEMS)
                .add(Items.COOKIE,
                        Items.BAKED_POTATO,
                        Items.MUSHROOM_STEW,
                        Items.RABBIT_STEW,
                        Items.HONEY_BOTTLE,
                        Items.COOKED_BEEF,
                        Items.COOKED_PORKCHOP,
                        Items.COOKED_CHICKEN,
                        Items.COOKED_COD,
                        Items.COOKED_SALMON,
                        Items.COOKED_MUTTON);


        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.IRONWOOD.get().asItem())
                .add(ModBlocks.IRONWOOD_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_IRONWOOD_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_IRONWOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.IRONWOOD_PLANKS.get().asItem());

        this.tag(ModTags.Items.IRONWOOD_TYPES)
                .add(ModBlocks.IRONWOOD.get().asItem())
                .add(ModBlocks.IRONWOOD_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_IRONWOOD_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_IRONWOOD.get().asItem());
    }
}

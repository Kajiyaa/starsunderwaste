package net.apollo.starsunderwaste.gendata;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.apollo.starsunderwaste.block.ModBlocks;
import net.apollo.starsunderwaste.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Starsunderwaste.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.NULLITE_BLOCK.get(),
                        ModBlocks.LIME_SAND_STONE.get(),
                        ModBlocks.UNDER_ROCK.get(),
                        ModBlocks.MARINE_UNDER_ROCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.IRONWOOD.get(),
                        ModBlocks.IRONWOOD_SLAB.get(),
                        ModBlocks.IRONWOOD_LEAVES.get(),
                        ModBlocks.IRONWOOD_SAPLING.get(),
                        ModBlocks.IRONWOOD_LOG.get(),
                        ModBlocks.IRONWOOD_PLANKS.get(),
                        ModBlocks.IRONWOOD_FENCE.get(),
                        ModBlocks.IRONWOOD_BUTTON.get(),
                        ModBlocks.IRONWOOD_DOOR.get(),
                        ModBlocks.IRONWOOD_FENCE_GATE.get(),
                        ModBlocks.IRONWOOD_TRAP_DOOR.get(),
                        ModBlocks.STRIPPED_IRONWOOD_LOG.get(),
                        ModBlocks.STRIPPED_IRONWOOD.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.LIME_SAND.get(),
                        ModBlocks.HARDENED_LIME_SAND.get(),
                        ModBlocks.LIME_SAND_NULLITE_ORE.get(),
                        ModBlocks.IRON_GRAVEL_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.LIME_SAND_NULLITE_ORE.get(),
                        ModBlocks.HARDENED_LIME_SAND_NULLITE_ORE.get(),
                        ModBlocks.LIME_SAND_STONE_NULLITE_ORE.get(),
                        ModBlocks.UNDER_ROCK_NULLITE_ORE.get(),
                        ModBlocks.MARINE_UNDER_ROCK_NULLITE_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.NULLITE_BLOCK.get(),
                        ModBlocks.LIME_SAND.get(),
                        ModBlocks.HARDENED_LIME_SAND.get(),
                        ModBlocks.LIME_SAND_STONE.get(),
                        ModBlocks.UNDER_ROCK.get(),
                        ModBlocks.MARINE_UNDER_ROCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.IRON_GRAVEL_ORE.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.LIME_SAND_STONE_FENCE.get())
                .add(ModBlocks.IRONWOOD_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.LIME_SAND_STONE_FENCE_GATE.get())
                .add(ModBlocks.IRONWOOD_FENCE_GATE.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.LIME_SAND_STONE_WALL.get());

        this.tag(BlockTags.DIRT)
                .add(ModBlocks.DRY_DIRT.get());

        this.tag(ModTags.Blocks.IRONWOOD_GROWABLES)
                .add(Blocks.DIRT)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.SAND)
                .add(Blocks.FARMLAND)
                .add(ModBlocks.LIME_SAND.get());


        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.IRONWOOD.get())
                .add(ModBlocks.IRONWOOD_LOG.get())
                .add(ModBlocks.STRIPPED_IRONWOOD_LOG.get())
                .add(ModBlocks.STRIPPED_IRONWOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.IRONWOOD_PLANKS.get());

        this.tag(ModTags.Blocks.IRONWOOD_TYPES)
                .add(ModBlocks.IRONWOOD.get())
                .add(ModBlocks.IRONWOOD_LOG.get())
                .add(ModBlocks.STRIPPED_IRONWOOD_LOG.get())
                .add(ModBlocks.STRIPPED_IRONWOOD.get());
    }
}

package net.apollo.starsunderwaste.gendata.loot;

import net.apollo.starsunderwaste.block.ModBlocks;
import net.apollo.starsunderwaste.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.NULLITE_BLOCK.get());
        this.dropSelf(ModBlocks.LIME_SAND.get());
        this.dropSelf(ModBlocks.HARDENED_LIME_SAND.get());
        this.dropSelf(ModBlocks.UNDER_ROCK.get());
        this.dropSelf(ModBlocks.MARINE_UNDER_ROCK.get());

        this.dropSelf(ModBlocks.IRONWOOD_LOG.get());
        this.dropSelf(ModBlocks.IRONWOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_IRONWOOD_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_IRONWOOD.get());

        this.dropSelf(ModBlocks.IRONWOOD_PLANKS.get());

        this.dropSelf(ModBlocks.IRONWOOD_SAPLING.get());

        this.add(ModBlocks.IRONWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.IRONWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.LIME_SAND_STONE.get());
        this.dropSelf(ModBlocks.LIME_SAND_STONE_FENCE.get());
        this.dropSelf(ModBlocks.LIME_SAND_STONE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.LIME_SAND_STONE_TRAP_DOOR.get());
        this.dropSelf(ModBlocks.LIME_SAND_STONE_WALL.get());
        this.dropSelf(ModBlocks.LIME_SAND_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.LIME_SAND_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.LIME_SAND_STONE_PRESSURE_PLATE.get());

        this.add(ModBlocks.LIME_SAND_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIME_SAND_STONE_SLAB.get()));
        this.add(ModBlocks.LIME_SAND_STONE_DOOR.get(),
                block -> createDoorTable(ModBlocks.LIME_SAND_STONE_DOOR.get()));

        this.dropSelf(ModBlocks.DRY_DIRT.get());

        this.dropSelf(ModBlocks.IRONWOOD_FENCE.get());
        this.dropSelf(ModBlocks.IRONWOOD_FENCE_GATE.get());
        this.dropSelf(ModBlocks.IRONWOOD_TRAP_DOOR.get());
        this.dropSelf(ModBlocks.IRONWOOD_STAIRS.get());
        this.dropSelf(ModBlocks.IRONWOOD_BUTTON.get());
        this.dropSelf(ModBlocks.IRONWOOD_PRESSURE_PLATE.get());

        this.add(ModBlocks.IRONWOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.IRONWOOD_SLAB.get()));
        this.add(ModBlocks.IRONWOOD_DOOR.get(),
                block -> createDoorTable(ModBlocks.IRONWOOD_DOOR.get()));



        this.add(ModBlocks.LIME_SAND_NULLITE_ORE.get(),
                block -> createOreDrop(ModBlocks.LIME_SAND_NULLITE_ORE.get(), ModItems.NULLITE.get()));
        this.add(ModBlocks.HARDENED_LIME_SAND_NULLITE_ORE.get(),
                block -> createOreDrop(ModBlocks.HARDENED_LIME_SAND_NULLITE_ORE.get(), ModItems.NULLITE.get()));
        this.add(ModBlocks.LIME_SAND_STONE_NULLITE_ORE.get(),
                block -> createOreDrop(ModBlocks.LIME_SAND_STONE_NULLITE_ORE.get(), ModItems.NULLITE.get()));
        this.add(ModBlocks.UNDER_ROCK_NULLITE_ORE.get(),
                block -> createOreDrop(ModBlocks.UNDER_ROCK_NULLITE_ORE.get(), ModItems.NULLITE.get()));
        this.add(ModBlocks.MARINE_UNDER_ROCK_NULLITE_ORE.get(),
                block -> createOreDrop(ModBlocks.MARINE_UNDER_ROCK_NULLITE_ORE.get(), ModItems.NULLITE.get()));

        this.add(ModBlocks.IRON_GRAVEL_ORE.get(),
                block -> createOreDrop(ModBlocks.IRON_GRAVEL_ORE.get(), Items.RAW_IRON));

    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

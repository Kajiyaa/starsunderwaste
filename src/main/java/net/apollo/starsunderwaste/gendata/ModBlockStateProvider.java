package net.apollo.starsunderwaste.gendata;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.apollo.starsunderwaste.block.ModBlocks;
import net.apollo.starsunderwaste.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Starsunderwaste.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.NULLITE_BLOCK);
        blockWithItem(ModBlocks.LIME_SAND);
        blockWithItem(ModBlocks.LIME_SAND_NULLITE_ORE);
        blockWithItem(ModBlocks.HARDENED_LIME_SAND);
        blockWithItem(ModBlocks.HARDENED_LIME_SAND_NULLITE_ORE);
        blockWithItem(ModBlocks.LIME_SAND_STONE);
        blockWithItem(ModBlocks.LIME_SAND_STONE_NULLITE_ORE);
        blockWithItem(ModBlocks.IRON_GRAVEL_ORE);
        blockWithItem(ModBlocks.UNDER_ROCK);
        blockWithItem(ModBlocks.UNDER_ROCK_NULLITE_ORE);
        blockWithItem(ModBlocks.MARINE_UNDER_ROCK);
        blockWithItem(ModBlocks.MARINE_UNDER_ROCK_NULLITE_ORE);
        blockWithItem(ModBlocks.DRY_DIRT);
        blockWithItem(ModBlocks.PORTAL_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.LIME_SAND_STONE_STAIRS.get()), blockTexture(ModBlocks.LIME_SAND_STONE.get()));
        slabBlock(((SlabBlock) ModBlocks.LIME_SAND_STONE_SLAB.get()), blockTexture(ModBlocks.LIME_SAND_STONE.get()), blockTexture(ModBlocks.LIME_SAND_STONE.get()));

        buttonBlock(((ButtonBlock) ModBlocks.LIME_SAND_STONE_BUTTON.get()), blockTexture(ModBlocks.LIME_SAND_STONE.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.LIME_SAND_STONE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.LIME_SAND_STONE.get()));

        fenceBlock(((FenceBlock) ModBlocks.LIME_SAND_STONE_FENCE.get()), blockTexture(ModBlocks.LIME_SAND_STONE.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.LIME_SAND_STONE_FENCE_GATE.get()), blockTexture(ModBlocks.LIME_SAND_STONE.get()));
        wallBlock(((WallBlock) ModBlocks.LIME_SAND_STONE_WALL.get()), blockTexture(ModBlocks.LIME_SAND_STONE.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.LIME_SAND_STONE_DOOR.get()), modLoc("block/lime_sand_stone_door_bottom"), modLoc("block/lime_sand_stone_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.LIME_SAND_STONE_TRAP_DOOR.get()), modLoc("block/lime_sand_stone_trap_door"), true, "cutout");

        logBlock(((RotatedPillarBlock) ModBlocks.IRONWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.IRONWOOD.get()), blockTexture(ModBlocks.IRONWOOD_LOG.get()), blockTexture(ModBlocks.IRONWOOD_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_IRONWOOD_LOG.get()), blockTexture(ModBlocks.STRIPPED_IRONWOOD_LOG.get()),
                new ResourceLocation(Starsunderwaste.MOD_ID, "block/stripped_ironwood_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_IRONWOOD.get()), blockTexture(ModBlocks.STRIPPED_IRONWOOD_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_IRONWOOD_LOG.get()));

        blockWithItem(ModBlocks.IRONWOOD_PLANKS);

        leavesBlock(ModBlocks.IRONWOOD_LEAVES);

        saplingBlock(ModBlocks.IRONWOOD_SAPLING);

        blockItem(ModBlocks.IRONWOOD_LOG);
        blockItem(ModBlocks.STRIPPED_IRONWOOD_LOG);
        blockItem(ModBlocks.IRONWOOD);
        blockItem(ModBlocks.STRIPPED_IRONWOOD);


        stairsBlock(((StairBlock) ModBlocks.IRONWOOD_STAIRS.get()), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.IRONWOOD_SLAB.get()), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.IRONWOOD_BUTTON.get()), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.IRONWOOD_PRESSURE_PLATE.get()), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.IRONWOOD_FENCE.get()), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.IRONWOOD_FENCE_GATE.get()), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.IRONWOOD_DOOR.get()), modLoc("block/ironwood_door_bottom"), modLoc("block/ironwood_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.IRONWOOD_TRAP_DOOR.get()), modLoc("block/ironwood_trap_door"), true, "cutout");
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }


    private void leavesBlock(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }


    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(Starsunderwaste.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }


}

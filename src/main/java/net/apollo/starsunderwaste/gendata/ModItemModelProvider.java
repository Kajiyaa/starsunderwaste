package net.apollo.starsunderwaste.gendata;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.apollo.starsunderwaste.block.ModBlocks;
import net.apollo.starsunderwaste.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Starsunderwaste.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ADVANCED_MRE);
        simpleItem(ModItems.PRESERVED_MRE);
        simpleItem(ModItems.ROTTEN_MRE);

        simpleItem(ModItems.NULLITE);
        simpleItem(ModItems.REFINED_NULLITE);
        simpleItem(ModItems.CAN_OPENER);

        handheldItem(ModItems.FUNNY_SWORD);

        simpleBlockItem(ModBlocks.LIME_SAND_STONE_DOOR);
        fenceItem(ModBlocks.LIME_SAND_STONE_FENCE, ModBlocks.LIME_SAND_STONE);
        buttonItem(ModBlocks.LIME_SAND_STONE_BUTTON, ModBlocks.LIME_SAND_STONE);
        wallItem(ModBlocks.LIME_SAND_STONE_WALL, ModBlocks.LIME_SAND_STONE);

        trapdoorItem(ModBlocks.LIME_SAND_STONE_TRAP_DOOR);
        evenSimplerBlockItem(ModBlocks.LIME_SAND_STONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.LIME_SAND_STONE_SLAB);
        evenSimplerBlockItem(ModBlocks.LIME_SAND_STONE_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.LIME_SAND_STONE_FENCE_GATE);


        simpleBlockItem(ModBlocks.IRONWOOD_DOOR);
        fenceItem(ModBlocks.IRONWOOD_FENCE, ModBlocks.IRONWOOD_PLANKS);
        buttonItem(ModBlocks.IRONWOOD_BUTTON, ModBlocks.IRONWOOD_PLANKS);

        trapdoorItem(ModBlocks.IRONWOOD_TRAP_DOOR);
        evenSimplerBlockItem(ModBlocks.IRONWOOD_STAIRS);
        evenSimplerBlockItem(ModBlocks.IRONWOOD_SLAB);
        evenSimplerBlockItem(ModBlocks.IRONWOOD_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.IRONWOOD_FENCE_GATE);


        saplingItem(ModBlocks.IRONWOOD_SAPLING);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Starsunderwaste.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Starsunderwaste.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Starsunderwaste.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Starsunderwaste.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(Starsunderwaste.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(Starsunderwaste.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(Starsunderwaste.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Starsunderwaste.MOD_ID, "item/" + item.getId().getPath()));
    }
}

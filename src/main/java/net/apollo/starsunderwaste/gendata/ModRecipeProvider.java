package net.apollo.starsunderwaste.gendata;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.apollo.starsunderwaste.block.ModBlocks;
import net.apollo.starsunderwaste.item.ModItems;
import net.apollo.starsunderwaste.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> NULLITE_SMELTABLES = List.of(ModItems.NULLITE.get(),
            ModBlocks.LIME_SAND_NULLITE_ORE.get());

    private static final List<ItemLike> IRON_SMELTABLES = List.of(ModBlocks.IRON_GRAVEL_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while (var9.hasNext()) {
            ItemLike itemlike = (ItemLike) var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Starsunderwaste.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, NULLITE_SMELTABLES, RecipeCategory.MISC, ModItems.REFINED_NULLITE.get(), 0.25F, 100, "nullite");
        oreBlasting(pWriter, IRON_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.25F, 100, "modded_iron");
        oreSmelting(pWriter, NULLITE_SMELTABLES, RecipeCategory.MISC, ModItems.REFINED_NULLITE.get(), 0.25F, 200, "nullite");
        oreSmelting(pWriter, IRON_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.25F, 200, "modded_iron");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NULLITE_BLOCK.get())
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModItems.REFINED_NULLITE.get())
                .unlockedBy(getHasName(ModItems.NULLITE.get()), has(ModItems.NULLITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_SAND_STONE_WALL.get(), 6)
                .pattern("   ")
                .pattern("LLL")
                .pattern("LLL")
                .define('L', ModBlocks.LIME_SAND_STONE.get())
                .unlockedBy(getHasName(ModBlocks.LIME_SAND_STONE.get()), has(ModBlocks.LIME_SAND_STONE_WALL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_SAND_STONE_FENCE_GATE.get(), 2)
                .pattern("   ")
                .pattern("L L")
                .pattern("L L")
                .define('L', ModBlocks.LIME_SAND_STONE.get())
                .unlockedBy(getHasName(ModBlocks.LIME_SAND_STONE.get()), has(ModBlocks.LIME_SAND_STONE_FENCE_GATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRONWOOD_FENCE_GATE.get(), 2)
                .pattern("   ")
                .pattern("L L")
                .pattern("L L")
                .define('L', ModBlocks.IRONWOOD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.IRONWOOD_PLANKS.get()), has(ModBlocks.IRONWOOD_FENCE_GATE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_SAND_STONE_STAIRS.get(), 4)
                .pattern("L  ")
                .pattern("LL ")
                .pattern("LLL")
                .define('L', ModBlocks.LIME_SAND_STONE.get())
                .unlockedBy(getHasName(ModBlocks.LIME_SAND_STONE.get()), has(ModBlocks.LIME_SAND_STONE_STAIRS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRONWOOD_STAIRS.get(), 4)
                .pattern("L  ")
                .pattern("LL ")
                .pattern("LLL")
                .define('L', ModBlocks.IRONWOOD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.IRONWOOD_PLANKS.get()), has(ModBlocks.IRONWOOD_STAIRS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_SAND_STONE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("LLL")
                .define('L', ModBlocks.LIME_SAND_STONE.get())
                .unlockedBy(getHasName(ModBlocks.LIME_SAND_STONE.get()), has(ModBlocks.LIME_SAND_STONE_STAIRS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRONWOOD_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("LLL")
                .define('L', ModBlocks.IRONWOOD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.IRONWOOD_PLANKS.get()), has(ModBlocks.IRONWOOD_SLAB.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_SAND_STONE_DOOR.get(), 2)
                .pattern("LL ")
                .pattern("LL ")
                .pattern("LL ")
                .define('L', ModBlocks.LIME_SAND_STONE.get())
                .unlockedBy(getHasName(ModBlocks.LIME_SAND_STONE.get()), has(ModBlocks.LIME_SAND_STONE_DOOR.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRONWOOD_DOOR.get(), 2)
                .pattern("LL ")
                .pattern("LL ")
                .pattern("LL ")
                .define('L', ModBlocks.IRONWOOD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.IRONWOOD_PLANKS.get()), has(ModBlocks.IRONWOOD_DOOR.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_SAND_STONE_TRAP_DOOR.get(), 2)
                .pattern("   ")
                .pattern("LL ")
                .pattern("LL ")
                .define('L', ModBlocks.LIME_SAND_STONE.get())
                .unlockedBy(getHasName(ModBlocks.LIME_SAND_STONE.get()), has(ModBlocks.LIME_SAND_STONE_TRAP_DOOR.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRONWOOD_TRAP_DOOR.get(), 2)
                .pattern("   ")
                .pattern("LLL")
                .pattern("LLL")
                .define('L', ModBlocks.IRONWOOD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.IRONWOOD_PLANKS.get()), has(ModBlocks.IRONWOOD_TRAP_DOOR.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_SAND_STONE_FENCE.get(), 4)
                .pattern("L L")
                .pattern("LLL")
                .pattern("L L")
                .define('L', ModBlocks.LIME_SAND_STONE.get())
                .unlockedBy(getHasName(ModBlocks.LIME_SAND_STONE.get()), has(ModBlocks.LIME_SAND_STONE_FENCE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRONWOOD_FENCE.get(), 4)
                .pattern("L L")
                .pattern("LLL")
                .pattern("L L")
                .define('L', ModBlocks.IRONWOOD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.IRONWOOD_PLANKS.get()), has(ModBlocks.IRONWOOD_FENCE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_SAND_STONE_PRESSURE_PLATE.get(), 2)
                .pattern("   ")
                .pattern("   ")
                .pattern("LL ")
                .define('L', ModBlocks.LIME_SAND_STONE.get())
                .unlockedBy(getHasName(ModBlocks.LIME_SAND_STONE.get()), has(ModBlocks.LIME_SAND_STONE_PRESSURE_PLATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRONWOOD_PRESSURE_PLATE.get(), 2)
                .pattern("   ")
                .pattern("   ")
                .pattern("LL ")
                .define('L', ModBlocks.IRONWOOD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.IRONWOOD_PLANKS.get()), has(ModBlocks.IRONWOOD_PRESSURE_PLATE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRONWOOD.get(), 3)
                .pattern("   ")
                .pattern("LL ")
                .pattern("LL ")
                .define('L', ModBlocks.IRONWOOD_LOG.get())
                .unlockedBy(getHasName(ModBlocks.IRONWOOD_LOG.get()), has(ModBlocks.IRONWOOD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_IRONWOOD.get(), 3)
                .pattern("   ")
                .pattern("LL ")
                .pattern("LL ")
                .define('L', ModBlocks.STRIPPED_IRONWOOD_LOG.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_IRONWOOD_LOG.get()), has(ModBlocks.STRIPPED_IRONWOOD.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRONWOOD_PLANKS.get(), 4)
                .requires(ModTags.Items.IRONWOOD_TYPES)
                .unlockedBy("has_ironwood", has(ModTags.Items.IRONWOOD_TYPES))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.LIME_SAND_STONE_BUTTON.get(), 2)
                .requires(ModBlocks.LIME_SAND_STONE.get())
                .unlockedBy(getHasName(ModBlocks.LIME_SAND_STONE.get()), has(ModBlocks.LIME_SAND_STONE_BUTTON.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.IRONWOOD_BUTTON.get(), 2)
                .requires(ModBlocks.IRONWOOD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.IRONWOOD_PLANKS.get()), has(ModBlocks.IRONWOOD_BUTTON.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.REFINED_NULLITE.get(), 9)
                .requires(ModBlocks.NULLITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NULLITE_BLOCK.get()), has(ModBlocks.NULLITE_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.HARDENED_LIME_SAND.get(), 4)
                .requires(ModBlocks.LIME_SAND.get(), 4)
                .unlockedBy(getHasName(ModBlocks.LIME_SAND.get()), has(ModBlocks.HARDENED_LIME_SAND.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.LIME_SAND_STONE.get(), 4)
                .requires(ModBlocks.HARDENED_LIME_SAND.get(), 4)
                .unlockedBy(getHasName(ModBlocks.HARDENED_LIME_SAND.get()), has(ModBlocks.LIME_SAND_STONE.get()))
                .save(pWriter);
    }
}

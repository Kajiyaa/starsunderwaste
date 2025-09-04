package net.apollo.starsunderwaste.item;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.apollo.starsunderwaste.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier NULLITE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 4064, 5f, 5f, 20,
                    ModTags.Blocks.NEEDS_NULLITE_TOOL, () -> Ingredient.of(ModItems.REFINED_NULLITE.get())),
            new ResourceLocation(Starsunderwaste.MOD_ID, "refined_nullite"), List.of(Tiers.NETHERITE), List.of());


}

package net.apollo.starsunderwaste.worldgen;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.apollo.starsunderwaste.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> IRON_GRAVEL_ORE_PLACED_KEY = registerKey("iron_gravel_ore_placed");

    public static final ResourceKey<PlacedFeature> IRONWOOD_PLACED_KEY = registerKey("ironwood_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context){
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // Iron Gravel Ore Placement
        register(context, IRON_GRAVEL_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.IRON_GRAVEL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(17,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(74))));

        // Ironwood Tree Placement: rare, one per chunk max, only on land

        register(context, IRONWOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.IRONWOOD_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 0),
                        ModBlocks.IRONWOOD_SAPLING.get()));;
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Starsunderwaste.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

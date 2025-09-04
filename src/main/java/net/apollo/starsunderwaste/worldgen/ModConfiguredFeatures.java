package net.apollo.starsunderwaste.worldgen;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.apollo.starsunderwaste.block.ModBlocks;
import net.apollo.starsunderwaste.worldgen.tree.custom.IronwoodTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?,?>> IRON_GRAVEL_ORE_KEY = registerKey("iron_gravel_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> IRONWOOD_KEY = registerKey("ironwood");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        // Iron Gravel Ore
        RuleTest stoneReplacables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> ironGravelores = List.of(
                OreConfiguration.target(stoneReplacables, ModBlocks.IRON_GRAVEL_ORE.get().defaultBlockState())
        );
        register(context, IRON_GRAVEL_ORE_KEY, Feature.ORE, new OreConfiguration(ironGravelores, 9));

        // Ironwood Tree
        TreeConfiguration ironwoodTreeConfig = new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.IRONWOOD_LOG.get()),
                new IronwoodTrunkPlacer(1, 4, 3),
                BlockStateProvider.simple(ModBlocks.IRONWOOD_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(1, 0 ,2))
                .dirt(BlockStateProvider.simple(ModBlocks.DRY_DIRT.get()))
                .build();

        register(context, IRONWOOD_KEY, Feature.TREE, ironwoodTreeConfig);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Starsunderwaste.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            F feature,
            FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

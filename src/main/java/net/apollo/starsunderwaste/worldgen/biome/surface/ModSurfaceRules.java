package net.apollo.starsunderwaste.worldgen.biome.surface;

import net.apollo.starsunderwaste.block.ModBlocks;
import net.apollo.starsunderwaste.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource LIME_SAND = makeStateRule(ModBlocks.LIME_SAND.get());
    private static final SurfaceRules.RuleSource DRY_DIRT = makeStateRule(ModBlocks.DRY_DIRT.get());
    private static final SurfaceRules.RuleSource LIME_SAND_STONE = makeStateRule(ModBlocks.LIME_SAND_STONE.get());

    public static SurfaceRules.RuleSource makeRules() {
        // Top layer: LIME_SAND
        SurfaceRules.RuleSource topLayer = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, LIME_SAND),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, DRY_DIRT)
        );

        // Entire dimension: only apply to DESERT_ALPHA
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.DESERT_ALPHA), topLayer),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, LIME_SAND_STONE)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}

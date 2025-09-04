package net.apollo.starsunderwaste.worldgen.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.apollo.starsunderwaste.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class IronwoodTrunkPlacer extends TrunkPlacer {

    public static final Codec<IronwoodTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            trunkPlacerParts(instance).apply(instance, IronwoodTrunkPlacer::new));

    public IronwoodTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.IRONWOOD_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level,
                                                            BiConsumer<BlockPos, BlockState> blockSetter,
                                                            RandomSource random,
                                                            int freeTreeHeight,
                                                            BlockPos pos,
                                                            TreeConfiguration config) {
        // Place dirt under tree
        setDirtAt(level, blockSetter, random, pos.below(), config);

        // Trunk: 2–5 logs
        int trunkHeight = 2 + random.nextInt(4);
        BlockPos top = pos;
        for (int i = 0; i < trunkHeight; i++) {
            placeLog(level, blockSetter, random, pos.above(i), config);
            top = pos.above(i);
        }

        // Branches: 2–4 per tree
        int branchCount = 2 + random.nextInt(3);
        int branchLength = 2 + random.nextInt(3); // same length for aligned canopies

        Direction[] usedDirs = new Direction[branchCount];
        for (int b = 0; b < branchCount; b++) {
            Direction dir;
            do {
                dir = Direction.Plane.HORIZONTAL.getRandomDirection(random);
            } while (containsDirection(usedDirs, dir, b));
            usedDirs[b] = dir;

            // Branch start: top or one below
            BlockPos branchStart = random.nextBoolean() ? top : top.below();
            generateBranch(level, blockSetter, random, branchStart, dir, branchLength, config);
        }

        return ImmutableList.of();
    }

    private boolean containsDirection(Direction[] dirs, Direction dir, int upto) {
        for (int i = 0; i < upto; i++) {
            if (dirs[i] == dir) return true;
        }
        return false;
    }

    private void generateBranch(LevelSimulatedReader level,
                                BiConsumer<BlockPos, BlockState> blockSetter,
                                RandomSource random,
                                BlockPos start,
                                Direction dir,
                                int length,
                                TreeConfiguration config) {
        BlockPos current = start;
        for (int i = 0; i < length; i++) {
            // Mostly upward movement (80% chance)
            if (random.nextFloat() < 0.8f) current = current.above();

            // Horizontal movement
            current = current.relative(dir);

            // Axis
            Direction.Axis axis = (current.getY() > start.getY()) ? Direction.Axis.Y : dir.getAxis();

            BlockState log = config.trunkProvider.getState(random, current)
                    .setValue(RotatedPillarBlock.AXIS, axis);
            blockSetter.accept(current, log);

            // Leaves always generated at last log
            if (i == length - 1) {
                generateTaperedCanopy(level, blockSetter, random, current, config);
            }
        }
    }

    // Tapered canopy with randomized corners for natural look
    private void generateTaperedCanopy(LevelSimulatedReader level,
                                       BiConsumer<BlockPos, BlockState> blockSetter,
                                       RandomSource random,
                                       BlockPos tip,
                                       TreeConfiguration config) {
        // Bottom layer: 5x1x5
        for (int dx = -2; dx <= 2; dx++) {
            for (int dz = -2; dz <= 2; dz++) {
                // Skip corners randomly
                if (Math.abs(dx) == 2 && Math.abs(dz) == 2 && random.nextFloat() < 0.5f) continue;
                placeLeaf(level, blockSetter, tip.offset(dx, 0, dz), config, random);
            }
        }

        // Top layer: 3x1x3
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                // Skip corners randomly
                if (Math.abs(dx) == 1 && Math.abs(dz) == 1 && random.nextFloat() < 0.5f) continue;
                placeLeaf(level, blockSetter, tip.above().offset(dx, 0, dz), config, random);
            }
        }

    }

    private void placeLeaf(LevelSimulatedReader level,
                           BiConsumer<BlockPos, BlockState> blockSetter,
                           BlockPos pos,
                           TreeConfiguration config,
                           RandomSource random) {
        BlockState leaf = config.foliageProvider.getState(random, pos);
        if (level.isStateAtPosition(pos, state -> state.isAir())) {
            blockSetter.accept(pos, leaf);
        }
    }
}

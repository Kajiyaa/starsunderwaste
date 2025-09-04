package net.apollo.starsunderwaste.block;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.apollo.starsunderwaste.block.custom.ModFlammableRotatedPillarBlock;
import net.apollo.starsunderwaste.block.custom.ModPortalBlock;
import net.apollo.starsunderwaste.item.ModItems;
import net.apollo.starsunderwaste.worldgen.tree.IronWoodGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Starsunderwaste.MOD_ID);

    public static final RegistryObject<Block> NULLITE_BLOCK = registerBlock("nullite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));

    public static final RegistryObject<Block> IRON_GRAVEL_ORE = registerBlock("iron_gravel_ore",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.GRAVEL)));

    public static final RegistryObject<Block> DRY_DIRT = registerBlock("dry_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> PORTAL_BLOCK = registerBlock("portal_block",
            () -> new ModPortalBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable().noOcclusion().noCollission()));


    public static final RegistryObject<Block> LIME_SAND_NULLITE_ORE = registerBlock("lime_sand_nullite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.GRAVEL)
                    .strength(2).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> HARDENED_LIME_SAND_NULLITE_ORE = registerBlock("hardened_lime_sand_nullite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.GRAVEL)
                    .strength(2).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> LIME_SAND_STONE_NULLITE_ORE = registerBlock("lime_sand_stone_nullite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.GRAVEL)
                    .strength(2).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> UNDER_ROCK_NULLITE_ORE = registerBlock("under_rock_nullite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.GRAVEL)
                    .strength(2).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> MARINE_UNDER_ROCK_NULLITE_ORE = registerBlock("marine_under_rock_nullite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.GRAVEL)
                    .strength(2).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));


    public static final RegistryObject<Block> LIME_SAND = registerBlock("lime_sand",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.SAND)));
    public static final RegistryObject<Block> HARDENED_LIME_SAND = registerBlock("hardened_lime_sand",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.GRAVEL)));

    public static final RegistryObject<Block> UNDER_ROCK = registerBlock("under_rock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> MARINE_UNDER_ROCK = registerBlock("marine_under_rock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)));

    public static final RegistryObject<Block> LIME_SAND_STONE = registerBlock("lime_sand_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> LIME_SAND_STONE_STAIRS = registerBlock("lime_sand_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.LIME_SAND_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

    public static final RegistryObject<Block> LIME_SAND_STONE_SLAB = registerBlock("lime_sand_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

    public static final RegistryObject<Block> LIME_SAND_STONE_BUTTON = registerBlock("lime_sand_stone_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON), BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> LIME_SAND_STONE_PRESSURE_PLATE = registerBlock("lime_sand_stone_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.DEEPSLATE), BlockSetType.IRON));

    public static final RegistryObject<Block> LIME_SAND_STONE_FENCE = registerBlock("lime_sand_stone_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> LIME_SAND_STONE_FENCE_GATE = registerBlock("lime_sand_stone_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundEvents.UI_STONECUTTER_TAKE_RESULT));
    public static final RegistryObject<Block> LIME_SAND_STONE_WALL = registerBlock("lime_sand_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

    public static final RegistryObject<Block> LIME_SAND_STONE_DOOR = registerBlock("lime_sand_stone_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> LIME_SAND_STONE_TRAP_DOOR = registerBlock("lime_sand_stone_trap_door",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noOcclusion(), BlockSetType.STONE));


    public static final RegistryObject<Block> IRONWOOD_SAPLING = registerBlock("ironwood_sapling",
            () -> new SaplingBlock(new IronWoodGrower(), BlockBehaviour.Properties.copy(Blocks.BIRCH_SAPLING)));
    public static final RegistryObject<Block> IRONWOOD_LOG = registerBlock("ironwood_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LOG).strength(3)));
    public static final RegistryObject<Block> IRONWOOD = registerBlock("ironwood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_WOOD).strength(3)));
    public static final RegistryObject<Block> STRIPPED_IRONWOOD = registerBlock("stripped_ironwood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final RegistryObject<Block> STRIPPED_IRONWOOD_LOG = registerBlock("stripped_ironwood_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_BIRCH_LOG)));


    public static final RegistryObject<Block> IRONWOOD_LEAVES = registerBlock("ironwood_leaves",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BIRCH_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> IRONWOOD_PLANKS = registerBlock("ironwood_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }


            });

    public static final RegistryObject<Block> IRONWOOD_STAIRS = registerBlock("ironwood_stairs",
            () -> new StairBlock(() -> ModBlocks.IRONWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> IRONWOOD_SLAB = registerBlock("ironwood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

    public static final RegistryObject<Block> IRONWOOD_BUTTON = registerBlock("ironwood_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));

    public static final RegistryObject<Block> IRONWOOD_PRESSURE_PLATE = registerBlock("ironwood_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.IRON));

    public static final RegistryObject<Block> IRONWOOD_FENCE = registerBlock("ironwood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_FENCE)));
    public static final RegistryObject<Block> IRONWOOD_FENCE_GATE = registerBlock("ironwood_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_FENCE_GATE), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundEvents.UI_STONECUTTER_TAKE_RESULT));


    public static final RegistryObject<Block> IRONWOOD_DOOR = registerBlock("ironwood_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> IRONWOOD_TRAP_DOOR = registerBlock("ironwood_trap_door",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion(), BlockSetType.OAK));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

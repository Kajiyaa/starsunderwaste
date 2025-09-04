package net.apollo.starsunderwaste.item;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.apollo.starsunderwaste.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Starsunderwaste.MOD_ID);


    public static final RegistryObject<CreativeModeTab> VAST_DEEP_NOTHING = CREATIVE_MODE_TABS.register("vast_deep_nothing",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.REFINED_NULLITE.get()))
                    .title(Component.translatable("creativetab.vast_deep_nothing"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.NULLITE.get());
                        pOutput.accept(ModItems.REFINED_NULLITE.get());
                        pOutput.accept(ModBlocks.NULLITE_BLOCK.get());
                        pOutput.accept(ModBlocks.DRY_DIRT.get());
                        pOutput.accept(ModBlocks.LIME_SAND.get());
                        pOutput.accept(ModBlocks.LIME_SAND_NULLITE_ORE.get());
                        pOutput.accept(ModBlocks.HARDENED_LIME_SAND.get());
                        pOutput.accept(ModBlocks.HARDENED_LIME_SAND_NULLITE_ORE.get());
                        pOutput.accept(ModBlocks.LIME_SAND_STONE.get());
                        pOutput.accept(ModBlocks.LIME_SAND_STONE_NULLITE_ORE.get());
                        pOutput.accept(ModBlocks.LIME_SAND_STONE_STAIRS.get());
                        pOutput.accept(ModBlocks.LIME_SAND_STONE_SLAB.get());
                        pOutput.accept(ModBlocks.LIME_SAND_STONE_BUTTON.get());
                        pOutput.accept(ModBlocks.LIME_SAND_STONE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.LIME_SAND_STONE_FENCE.get());
                        pOutput.accept(ModBlocks.LIME_SAND_STONE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.LIME_SAND_STONE_WALL.get());
                        pOutput.accept(ModBlocks.LIME_SAND_STONE_DOOR.get());
                        pOutput.accept(ModBlocks.LIME_SAND_STONE_TRAP_DOOR.get());
                        pOutput.accept(ModBlocks.IRONWOOD_LOG.get());
                        pOutput.accept(ModBlocks.IRONWOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_IRONWOOD_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_IRONWOOD.get());
                        pOutput.accept(ModBlocks.IRONWOOD_PLANKS.get());
                        pOutput.accept(ModBlocks.IRONWOOD_LEAVES.get());
                        pOutput.accept(ModBlocks.IRONWOOD_STAIRS.get());
                        pOutput.accept(ModBlocks.IRONWOOD_SLAB.get());
                        pOutput.accept(ModBlocks.IRONWOOD_BUTTON.get());
                        pOutput.accept(ModBlocks.IRONWOOD_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.IRONWOOD_FENCE.get());
                        pOutput.accept(ModBlocks.IRONWOOD_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.IRONWOOD_DOOR.get());
                        pOutput.accept(ModBlocks.IRONWOOD_TRAP_DOOR.get());
                        pOutput.accept(ModBlocks.IRONWOOD_SAPLING.get());
                        pOutput.accept(ModBlocks.UNDER_ROCK.get());
                        pOutput.accept(ModBlocks.UNDER_ROCK_NULLITE_ORE.get());
                        pOutput.accept(ModBlocks.MARINE_UNDER_ROCK.get());
                        pOutput.accept(ModBlocks.MARINE_UNDER_ROCK_NULLITE_ORE.get());
                        pOutput.accept(ModBlocks.IRON_GRAVEL_ORE.get());
                        pOutput.accept(ModItems.BASIC_SPADE.get());
                        pOutput.accept(ModItems.NULLITE_MACHETE.get());
                        pOutput.accept(ModItems.NULLITE_SHOVEL.get());
                        pOutput.accept(ModItems.NULLITE_PICKAXE.get());
                        pOutput.accept(ModItems.NULLITE_HATCHET.get());
                        pOutput.accept(ModItems.NULLITE_HOE.get());
                        pOutput.accept(ModItems.FUNNY_SWORD.get());
                        pOutput.accept(ModItems.CAN_OPENER.get());
                        pOutput.accept(ModItems.PRESERVED_MRE.get());
                        pOutput.accept(ModItems.ADVANCED_MRE.get());
                        pOutput.accept(ModItems.ROTTEN_MRE.get());
                        pOutput.accept(ModBlocks.PORTAL_BLOCK.get());
                    })

                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

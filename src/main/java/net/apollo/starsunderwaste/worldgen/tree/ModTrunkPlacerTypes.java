package net.apollo.starsunderwaste.worldgen.tree;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.apollo.starsunderwaste.worldgen.tree.custom.IronwoodTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Starsunderwaste.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<IronwoodTrunkPlacer>> IRONWOOD_TRUNK_PLACER =
            TRUNK_PLACER.register("ironwood_trunk_placer", () -> new TrunkPlacerType<>(IronwoodTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus){
        TRUNK_PLACER.register(eventBus);
    }

}


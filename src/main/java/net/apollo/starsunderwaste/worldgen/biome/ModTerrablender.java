package net.apollo.starsunderwaste.worldgen.biome;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes(){
        Regions.register(new ModOverworldRegion(new ResourceLocation(Starsunderwaste.MOD_ID, "overworld"), 5));
    }
}

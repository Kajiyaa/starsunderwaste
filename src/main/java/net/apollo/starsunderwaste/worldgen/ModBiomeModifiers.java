package net.apollo.starsunderwaste.worldgen;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_IRON_GRAVEL = registerKey("add_iron_gravel");

    public static final ResourceKey<BiomeModifier> ADD_IRONWOOD_TREE = registerKey("add_ironwood_tree");

    public static void bootstrap(BootstapContext<BiomeModifier> context){
        var placedFetures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_IRON_GRAVEL, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFetures.getOrThrow(ModPlacedFeatures.IRON_GRAVEL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_IRONWOOD_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFetures.getOrThrow(ModPlacedFeatures.IRONWOOD_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Starsunderwaste.MOD_ID, name));
    }
}

package net.apollo.starsunderwaste.item;

import net.apollo.starsunderwaste.Starsunderwaste;
import net.apollo.starsunderwaste.item.custom.CanOpener;
import net.apollo.starsunderwaste.item.custom.spadeShovel;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Starsunderwaste.MOD_ID);

    public static final RegistryObject<Item> NULLITE = ITEMS.register("nullite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REFINED_NULLITE = ITEMS.register("refined_nullite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PRESERVED_MRE = ITEMS.register("preserved_mre",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ADVANCED_MRE = ITEMS.register("advanced_mre",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROTTEN_MRE = ITEMS.register("rotten_mre",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NULLITE_SHOVEL = ITEMS.register("nullite_shovel",
            () -> new ShovelItem(ModToolTiers.NULLITE, 1, -3.2f, new Item.Properties()));

    public static final RegistryObject<Item> NULLITE_MACHETE = ITEMS.register("nullite_machete",
            () -> new SwordItem(ModToolTiers.NULLITE, 3, -2.6f, new Item.Properties()));

    public static final RegistryObject<Item> NULLITE_PICKAXE = ITEMS.register("nullite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NULLITE, 1, -3.0f, new Item.Properties()));

    public static final RegistryObject<Item> NULLITE_HATCHET = ITEMS.register("nullite_hatchet",
            () -> new AxeItem(ModToolTiers.NULLITE, 6, -3.2f, new Item.Properties()));

    public static final RegistryObject<Item> NULLITE_HOE = ITEMS.register("nullite_hoe",
            () -> new HoeItem(ModToolTiers.NULLITE, -2, -2.0f, new Item.Properties()));

    public static final RegistryObject<Item> FUNNY_SWORD = ITEMS.register("funny_sword",
            () -> new SwordItem(ModToolTiers.NULLITE, 10, -0.6f, new Item.Properties()));

    public static final RegistryObject<Item> CAN_OPENER = ITEMS.register("can_opener",
            () -> new CanOpener(new Item.Properties().stacksTo(1).durability(200)));

    public static final RegistryObject<Item> BASIC_SPADE = ITEMS.register("basic_spade",
            () -> new spadeShovel(new Item.Properties().stacksTo(1).durability(1800)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}


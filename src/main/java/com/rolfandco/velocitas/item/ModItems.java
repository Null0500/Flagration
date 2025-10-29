package com.rolfandco.velocitas.item;


import com.rolfandco.velocitas.Velocitas;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.rolfandco.velocitas.item.ModToolTiers.SCORCHED_TIER;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Velocitas.MODID);


    public static void register (IEventBus eventbus) {
        ITEMS.register(eventbus);
    }



    public static final DeferredItem<Item> SCORCHED_IRON_INGOT = ITEMS.register("scorched_iron_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LUCKY_CORE = ITEMS.register("lucky_core",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> APPLE_CORE = ITEMS.register("apple_core",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SCORCHED_IRON_APPLE = ITEMS.register("scorched_iron_apple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SCORCHED_IRON_APPLE)));


    public static final DeferredItem<Item> SCORCHED_IRON_SWORD = ITEMS.register("scorched_iron_sword",
            () -> new SwordItem(SCORCHED_TIER, new Item.Properties().attributes(
                    SwordItem.createAttributes(SCORCHED_TIER, 2, -2.6F))));
    public static final DeferredItem<Item> SCORCHED_IRON_PICKAXE = ITEMS.register("scorched_iron_pickaxe",
            () -> new PickaxeItem(SCORCHED_TIER, new Item.Properties().attributes(
                    PickaxeItem.createAttributes(SCORCHED_TIER, 0, -3))));



    /*
    ASK DAD:
	public static RegistryObject<Item> registerWithTab(final String name, final Supplier<Item> supplier) {
		RegistryObject<Item> block = ITEMS.register(name, supplier);
		CREATIVE_TAB_ITEMS.add(block);
		return block;
	} (pulled from Farmer's Delight gitHub: https://github.com/vectorwing/FarmersDelight/blob/afc79de755ae04d20ed9654ab4056e53a717cf32/src/main/java/vectorwing/farmersdelight/common/registry/ModItems.java#L50)

	Why use a LinkedHashSet for RegistryObject? What's the difference between LinkedHashSets, LinkedLists, HashMaps,
	Arrays, etc. Is a LinkedHashSet a dictionary, as in key: value? {1: "Ford", 2: "Volvo"}?

	Is registerWithTab a method? It's called later in the code as practically a replacement for item.register,
	passing a supplier in FROM the method's parameters. Is this possible? Why does this work? Are methods just making
	a new line of code = multiple lines of predetermined code? Unrelated, why return block? It's not used anywhere
	else in that mod's code, so why not make the object void too? Does that break the code?

    My deconstruction of code:
        Public object that belongs to a class
        <Item>? Item seems unnecessary
        takes a string name and a supplier that isn't changed. Supplier is () -> yadayadayada
        Registers the block as an item, done in ModBlocks class @ src/main/java/com/rolfandco/velocitas/block/ModBlocks.java
        Adds the block item to the CREATIVE_TAB_ITEMS LinkedHashSet (which is then registered in Farmer's Delight's ModCreativeModeTab class with a .for each item thing)
        returns block for some reason

    DO NOTE this is for blocks, would require modification for item registry.
    */
}

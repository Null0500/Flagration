package com.rolfandco.velocitas.item;


import com.rolfandco.velocitas.Velocitas;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Velocitas.MODID);

    public static final DeferredItem<Item> SCORCHED_IRON_INGOT = ITEMS.register("scorched_iron_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LUCKY_CORE = ITEMS.register("lucky_core",
            () -> new Item(new Item.Properties()));

    public static void register (IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}

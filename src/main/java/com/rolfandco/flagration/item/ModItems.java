package com.rolfandco.flagration.item;


import com.rolfandco.flagration.Flagration;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Flagration.MODID);

    public static final DeferredItem<Item> SCORCHED_IRON_INGOT = ITEMS.register("scorched_iron_ingot",
            () -> new Item(new Item.Properties()));

    public static void register (IEventBus eventbus){
        ITEMS.register(eventbus);
    }
}

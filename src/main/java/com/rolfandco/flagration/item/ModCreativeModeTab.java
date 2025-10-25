package com.rolfandco.flagration.item;

import com.rolfandco.flagration.Flagration;
import com.rolfandco.flagration.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Flagration.MODID);

    public static final Supplier<CreativeModeTab> FLAGRATION_TAB = CREATIVE_MODE_TAB.register("flagration_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SCORCHED_IRON_INGOT.get()))
                    .title(Component.translatable("creativetab.flagration.flagration"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SCORCHED_IRON_INGOT);
                        output.accept(ModBlocks.SCORCHED_IRON_BLOCK);
                    }).build());

    public static void register (IEventBus eventbus){
        CREATIVE_MODE_TAB.register(eventbus);
    }
}

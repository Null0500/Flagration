package com.rolfandco.velocitas.item;

import com.rolfandco.velocitas.Velocitas;
import com.rolfandco.velocitas.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Velocitas.MODID);

    public static final Supplier<CreativeModeTab> VELOCITAS_TAB = CREATIVE_MODE_TAB.register("velocitas_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SCORCHED_IRON_INGOT.get()))
                    .title(Component.translatable("creativetab.velocitas.velocitas"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SCORCHED_IRON_INGOT);
                        output.accept(ModItems.LUCKY_CORE);
                        output.accept(ModItems.SCORCHED_IRON_SWORD);
                        output.accept(ModItems.SCORCHED_IRON_PICKAXE);
                        output.accept(ModItems.APPLE_CORE);
                        output.accept(ModItems.SCORCHED_IRON_APPLE);

                        output.accept(ModBlocks.SCORCHED_IRON_BLOCK);
                    }).build());

    public static void register (IEventBus eventbus){
        CREATIVE_MODE_TAB.register(eventbus);
    }
}

package com.rolfandco.velocitas.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties SCORCHED_IRON_APPLE = new FoodProperties.Builder().nutrition(5).saturationModifier(1f).usingConvertsTo(ModItems.APPLE_CORE).effect(() -> new MobEffectInstance(MobEffects.HARM), 1f).build();
}

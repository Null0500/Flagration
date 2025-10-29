package com.rolfandco.velocitas.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {

    public static final Tier SCORCHED_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            128, 5.5f, 3.0F, 12, () -> Ingredient.of(ModItems.SCORCHED_IRON_INGOT));
}

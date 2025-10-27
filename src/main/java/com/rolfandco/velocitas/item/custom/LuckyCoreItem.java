package com.rolfandco.velocitas.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class LuckyCoreItem extends Item {
    public LuckyCoreItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        // Random XP between 1 and 50 (exclusive)
        int randXpAward = new Random().nextInt(49) + 1;

        if (clickedBlock == Blocks.GRINDSTONE) {
            if (!level.isClientSide) {
                // Consume one item from the stack
                context.getItemInHand().shrink(1);

                ExperienceOrb.award((ServerLevel) level, context.getClickedPos().getCenter(), randXpAward);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}

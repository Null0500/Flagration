package com.rolfandco.velocitas.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.Random;

public class LuckyCoreItem extends Item {
    public LuckyCoreItem(Properties properties) {
        super(properties);
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();
        Block block = level.getBlockState(event.getPos()).getBlock();

        if (block == Blocks.GRINDSTONE && stack.getItem() instanceof LuckyCoreItem) {
            if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
                stack.shrink(1);
                ExperienceOrb.award(serverLevel, Vec3.atCenterOf(event.getPos()), new Random().nextInt(49) + 1);
            }
            event.setCanceled(true); // Prevents GUI from opening
            event.setCancellationResult(InteractionResult.SUCCESS);
        }
    }


}

package com.wildcard.buddycards.util;

import com.wildcard.buddycards.registries.BuddycardsBlocks;
import com.wildcard.buddycards.registries.BuddycardsEntities;
import com.wildcard.buddycards.registries.BuddycardsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class ExplosionHandler {
    @SubscribeEvent
    public void onExplosion (ExplosionEvent.Detonate event) {
        int luminisBlocks = 0;
        List<BlockPos> replacedExplosion = new ArrayList<>();

        for (int i = 0; i < event.getAffectedBlocks().size(); i++) {
            BlockPos blockPos = event.getAffectedBlocks().get(i);
            BlockState targetBlock = event.getWorld().getBlockState(blockPos);
            //Check if the block is a kinetic chamber
            if (event.getWorld() instanceof ServerLevel server && targetBlock.getBlock().equals(BuddycardsBlocks.KINETIC_CHAMBER.get()))
                event.getWorld().getBlockEntity(blockPos, BuddycardsEntities.KINETIC_CHAMBER_TILE.get()).get().absorbExplosion(server);
            //luminis
            else if (targetBlock.getBlock().equals(BuddycardsBlocks.LUMINIS_BLOCK.get())) {
                luminisBlocks++;
                event.getWorld().setBlock(blockPos, Blocks.AIR.defaultBlockState(), 11);
                replacedExplosion.add(blockPos);
            }
            //or not
            else
                replacedExplosion.add(blockPos);
        }
        //Replace with
        event.getExplosion().clearToBlow();
        event.getAffectedBlocks().addAll(replacedExplosion);
        //Calculate rng, needs 2 blocks on average per crimson luminis
        double rng = event.getWorld().getRandom().nextFloat();
        if ((int) (luminisBlocks * rng) > 1)
            event.getWorld().addFreshEntity(new ItemEntity(event.getWorld(), event.getExplosion().getPosition().x, event.getExplosion().getPosition().y, event.getExplosion().getPosition().z,
                    new ItemStack(BuddycardsItems.CRIMSON_LUMINIS.get(), (int) (luminisBlocks * rng))));
    }
}

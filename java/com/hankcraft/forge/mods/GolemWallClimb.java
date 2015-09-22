package com.hankcraft.forge.mods;

import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GolemWallClimb {
	@SubscribeEvent
	public void climbWall(LivingUpdateEvent event) {
		if (!(event.entity instanceof EntityPlayer)
				&& !(event.entity instanceof EntityIronGolem)) {
			return;
		}
		if (!event.entity.isCollidedHorizontally) {
			return;
		}
		event.entity.motionY = 0.5;
	}
}
package com.hankcraft.forge.mods;

import ibxm.Player;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.Random;

public class CheeseBlock extends Block {
	public CheeseBlock() {
		super(Material.iron);
		this.setUnlocalizedName("cheeseBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setResistance(5.0F);
		this.setHardness(10.0F);
		this.setLightLevel(1.0F);
	}

	public Item getItemDropped(int i1, Random random, int i2)
	{
		return Main.cheeseIngot;
	}

	public int quantityDropped(Random random)
	{
		return random.nextInt(2) + 3;
	}

	public void onEntityWalking(World world, int par2, int par3, int par4, Entity entity ) {
		if(entity instanceof EntityPlayer) {
			((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.confusion.getId(), 100, 3));
		}
	}

}
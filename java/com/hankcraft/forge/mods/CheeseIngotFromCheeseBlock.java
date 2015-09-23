package com.hankcraft.forge.mods;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CheeseIngotFromCheeseBlock extends Block {
	public CheeseIngotFromCheeseBlock() {
		super(Material.iron);
//		this.setBlockName("cheeseBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
//		this.textureName = "mymods:cheeseBlock";
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
}
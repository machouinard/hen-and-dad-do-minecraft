package com.hankcraft.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class CheeseIngot extends ItemFood {
	public CheeseIngot() {
		super(5, 1.0F, true);
		this.setPotionEffect(1, 60, 2, 0.5F);
		this.setAlwaysEdible();
		this.setUnlocalizedName("cheeseIngot");
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}


}

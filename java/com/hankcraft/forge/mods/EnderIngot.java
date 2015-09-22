package com.hankcraft.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by markchouinard on 9/21/15.
 */
public class EnderIngot extends ItemFood {

    public EnderIngot() {
        super(5, 1.0F, false);
        this.setUnlocalizedName("enderIngot");
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setPotionEffect(1, 60, 2, 0.9F);
        this.setAlwaysEdible();
    }

//    public ItemStack onItemRightClick( ItemStack stack,
//                                       World world, EntityPlayer player ) {
//       EntityEnderman enderman = new EntityEnderman(world);
//        enderman.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
//
//        if( !world.isRemote ) {
//            world.spawnEntityInWorld( enderman );
//        }
//
//        if (!player.capabilities.isCreativeMode ) {
//            stack.stackSize--;
//        }
//
//        return stack;
//    }

}

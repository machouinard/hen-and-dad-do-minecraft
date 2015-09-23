package com.hankcraft.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	public static final String MODID = "MyMods";
	public static final String VERSION = "2.0";

	public static Block cheeseBlock;
	public static Item cheeseIngot;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new BiggerTNTExplosionsWithFuse());
		// MinecraftForge.EVENT_BUS.register(new
		// BiggerTNTExplosionsWithoutFuse());

		MinecraftForge.EVENT_BUS.register(new BouncySponges());

		FMLCommonHandler.instance().bus().register(new Parachute());
		MinecraftForge.EVENT_BUS.register(new Parachute());
		MinecraftForge.EVENT_BUS.register(new GolemWallClimb());
		MinecraftForge.EVENT_BUS.register(new BlockFillerPositionSelector());

//		cheeseBlock = new CheeseBlock();
		// cheeseBlock = new BlockChanger();
		 cheeseBlock = new CheeseIngotFromCheeseBlock();
		GameRegistry.registerBlock(cheeseBlock, "cheeseBlock");
		Item cheeseBlockItem = GameRegistry.findItem("mymods", "cheeseBlock");
		ModelResourceLocation cheeseBlockModel = new ModelResourceLocation(
				"mymods:cheeseBlock", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(cheeseBlockItem, 0, cheeseBlockModel);

//		cheeseIngot = new CheeseIngot();
		// cheeseIngot = new EndermanSpawner();
		 cheeseIngot = new EdibleIngot();
		GameRegistry.registerItem(cheeseIngot, "cheeseIngot");
		Item cheeseIngotItem = GameRegistry.findItem("mymods", "cheeseIngot");
		ModelResourceLocation cheeseIngotModel = new ModelResourceLocation(
				"mymods:cheeseIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(cheeseIngot, 0, cheeseIngotModel);

		GameRegistry.addRecipe(new ItemStack(cheeseBlock), "iii", "iii", "iii",
				'i', cheeseIngot);

		GameRegistry.addRecipe(new ItemStack(cheeseBlock), "e e", " o ", "e e",
				'o', Blocks.obsidian, 'e', Items.ender_eye);

		GameRegistry.addShapelessRecipe(new ItemStack(cheeseIngot, 9),
				new ItemStack(cheeseBlock));

		GameRegistry.addShapelessRecipe(new ItemStack(cheeseIngot, 12),
				new ItemStack(cheeseBlock, 1), new ItemStack(Items.iron_ingot),
				new ItemStack(Items.gold_ingot));

		GameRegistry.addSmelting(Items.ender_pearl,
				new ItemStack(cheeseIngot, 1), 1.0F);

		Items.cake.setPotionEffect(PotionHelper.blazePowderEffect);
	}

	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {
		event.registerServerCommand(new BlockFillCommand());
	}
}

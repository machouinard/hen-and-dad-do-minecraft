package com.hankcraft.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION )
public class Main {

	public static final String MODID = "myMods";
	public static final String NAME = "Hank Mod";
	public static final String VERSION = "1.0";
	public static Block enderBlock;
    public static Item enderIngot;

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
		MinecraftForge.EVENT_BUS.register(new ExplodingMinecarts());
		MinecraftForge.EVENT_BUS.register(new ExplodingAnvils());
		MinecraftForge.EVENT_BUS.register(new DiamondOreTrap());
		MinecraftForge.EVENT_BUS.register(new BiggerTNTExplosions());
		MinecraftForge.EVENT_BUS.register(new PigsDropDiamonds());
		MinecraftForge.EVENT_BUS.register(new ZombieKnights());
		MinecraftForge.EVENT_BUS.register(new CreeperBackup());
		MinecraftForge.EVENT_BUS.register(new SuperJump());
//		Parachute mod uses 2 different buses
		FMLCommonHandler.instance().bus().register(new Parachute());
		MinecraftForge.EVENT_BUS.register(new Parachute());
		
		MinecraftForge.EVENT_BUS.register(new GolemWallClimb());
		MinecraftForge.EVENT_BUS.register(new BlockFillerPositionSelector());

		enderBlock = new EnderBlock();
		GameRegistry.registerBlock( enderBlock, "enderBlock" );
        enderIngot = new EnderIngot();
        GameRegistry.registerItem(enderIngot, "enderIngot");

	}
	
	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {

		event.registerServerCommand(new FirePigs());
		event.registerServerCommand(new BlockFillCommand());
	}
}

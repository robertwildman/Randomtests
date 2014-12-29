package com.wildcraft;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TestMain extends JavaPlugin {
	//Main class that will deal with the commands and dealing with event listener. 
	@Override
	public void onDisable()
	{
		
	}
	@Override 
	public void onEnable()
	{
		System.out.println("Hello and welcome to test puzzle");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new InventoryListener(),this);
		pm.registerEvents(new PlayerListener(),this);
	}

}

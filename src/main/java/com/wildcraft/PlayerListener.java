package com.wildcraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerListener implements Listener {
	public ItemStack Compass,Watch,Tag,Diamond;
	public ItemMeta Compassdata,Watchdata,Tagdata,Diamonddata;
	public void Itemloader()
	{
		//COMPASS
		Compass = new ItemStack(Material.COMPASS);
		Compassdata = Compass.getItemMeta();
		Compassdata.setDisplayName(ChatColor.RED + " "+ChatColor.BOLD+ "Game Selector");
		Compass.setItemMeta(Compassdata);
		//WATCH 
		Watch = new ItemStack(Material.WATCH);
		Watchdata = Watch.getItemMeta();
		Watchdata.setDisplayName(ChatColor.BLUE + " "+ChatColor.BOLD+ "Hub Selector");
		Watch.setItemMeta(Watchdata);
		//NAME TAG
		Tag = new ItemStack(Material.NAME_TAG);
		Tagdata = Tag.getItemMeta();
		Tagdata.setDisplayName(ChatColor.GREEN + " "+ChatColor.BOLD+ "Player Challenger");
		Tag.setItemMeta(Tagdata); 
		//DIAMOND
		Diamond = new ItemStack(Material.DIAMOND);
		Diamonddata = Diamond.getItemMeta();
		Diamonddata.setDisplayName(ChatColor.BLUE + " "+ChatColor.BOLD+ "Store");
		Diamond.setItemMeta(Diamonddata); 
		
		
	}
	@EventHandler
	public void onPlayerJoined(PlayerJoinEvent event) 
	{
		Itemloader();
		event.getPlayer().sendMessage("Welcome to the Server. Use your inventory to move around the server!");
		Player person = event.getPlayer();
		person.getInventory().setItem(0,Compass);
		person.getInventory().setItem(1,Watch);
		person.getInventory().setItem(2,Tag);
		person.getInventory().setItem(3,Diamond);
		
	}
	@EventHandler 
	public void onPlayerrightclick(PlayerInteractEvent event)
	{
		Itemloader();
		if(event.getMaterial().equals(Material.COMPASS))
		{
			Inventory games = Bukkit.createInventory(null, 9, "Game Selector");
			games.setItem(0, new ItemStack(Material.ANVIL));
			event.getPlayer().openInventory(games);
		}else if(event.getMaterial().equals(Material.WATCH))
		{
			Inventory games = Bukkit.createInventory(null, 9, "Hub Selector");
			games.setItem(0, new ItemStack(Material.IRON_HELMET));
			event.getPlayer().openInventory(games);
		}
	}
}

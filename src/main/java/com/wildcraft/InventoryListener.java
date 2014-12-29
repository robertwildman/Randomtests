package com.wildcraft;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {
	public List<ItemStack> items;
	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent event) 
	{
		Itemloader();
		int amountofitems = 3;
		//When user opens a chest it will fill with random items 
		if(event.getInventory().getType().equals(InventoryType.CHEST))
		{
			
			if(event.getInventory().getContents()[0] == null)
			{
				//Needs a refill
				for(int i = 0; i < amountofitems; i++)
				{
					//This will randomly pick an item and put it into the chest
					//It will keep going till the correct amount 
					 Random randomGenerator = new Random();
					 int randomInt = randomGenerator.nextInt(items.size());
					 event.getInventory().addItem(items.get(randomInt));
				}
				
			}else
			{
				//To test spawning in blocks if chest has items inside it will spawn a new one 5 blocks away.,
				Player p = (Player)event.getPlayer();
				Location playerloc = p.getLocation();
				double x = playerloc.getBlockX() - 5;
				double y =  playerloc.getBlockY();
				double z =  playerloc.getBlockZ();
				Location spawnloc = new Location(playerloc.getWorld(),x,y,z);
				p.getWorld().getBlockAt(spawnloc).setType(Material.CHEST);
				
				
			}
		}
	}
	@EventHandler
	public void onInventoryCLick(InventoryClickEvent event)
	{
		//Will check to see what Inventory has been open by the user
		Inventory clickinventory = event.getInventory();
		ItemStack selectedgame = event.getCurrentItem();
		if(clickinventory.getName().equalsIgnoreCase("Game Selector"))
		{
			//Knows its the game selector so can deal with the user click on each item in the inventory
			if(selectedgame.getType() == Material.ANVIL)
			{
				//Would send user to the game
				Player p = (Player)event.getWhoClicked();
				p.sendMessage("You have selected a game");
				//Will teleport player to the game area.
				p.teleport(new Location(p.getWorld(), -100 ,-100,60 ));
			}
		}
	}
	
	public void Itemloader()
	{
		//Checks list of items that can be in the chests 
		items = new ArrayList<ItemStack>();
		items.add(new ItemStack(Material.WATCH));
		items.add(new ItemStack(Material.IRON_AXE));
		items.add(new ItemStack(Material.IRON_BARDING));
		items.add(new ItemStack(Material.IRON_BLOCK));
		items.add(new ItemStack(Material.IRON_BOOTS));
		items.add(new ItemStack(Material.IRON_CHESTPLATE));
		items.add(new ItemStack(Material.IRON_DOOR));
		items.add(new ItemStack(Material.IRON_DOOR_BLOCK));
		items.add(new ItemStack(Material.IRON_HELMET));
		
		
	}
	
}

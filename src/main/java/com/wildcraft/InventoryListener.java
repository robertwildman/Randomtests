package com.wildcraft;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {
	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent event) 
	{
		System.out.println("Opened");
		HumanEntity person = event.getPlayer();
		person.setGameMode(GameMode.CREATIVE);
	}
	@EventHandler
	public void onInventoryCLick(InventoryClickEvent event)
	{
		Inventory clickinventory = event.getInventory();
		ItemStack selectedgame = event.getCurrentItem();
		if(clickinventory.getName().equalsIgnoreCase("Game Selector"))
		{
			if(selectedgame.getType() == Material.ANVIL)
			{
				Player p = (Player)event.getWhoClicked();
				p.sendMessage("You have selected a game");
			}
		}
	}
}

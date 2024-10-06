package com.rabbitcomapny.listeners;

import com.rabbitcomapny.Passky;
import com.rabbitcomapny.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

	private final Passky passky;

	public InventoryClickListener(Passky plugin) {
		passky = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (Utils.isFake(e.getWhoClicked())) {
			return;
		}

		if (!Passky.isLoggedIn.getOrDefault(e.getWhoClicked().getUniqueId(), false)) {
			e.setCancelled(true);
		}
	}
}

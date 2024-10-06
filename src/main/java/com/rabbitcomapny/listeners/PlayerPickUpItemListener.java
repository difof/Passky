package com.rabbitcomapny.listeners;

import com.rabbitcomapny.Passky;
import com.rabbitcomapny.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPickUpItemListener
	implements Listener {
	private final Passky passky;

	public PlayerPickUpItemListener(Passky plugin) {
		this.passky = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerPickUpItem(PlayerPickupItemEvent e) {
		if (Utils.isFake(e.getPlayer())) {
			return;
		}

		if (!Passky.isLoggedIn.getOrDefault(e.getPlayer().getUniqueId(), false))
			e.setCancelled(true);
	}
}

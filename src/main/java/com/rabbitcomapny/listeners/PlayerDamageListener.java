package com.rabbitcomapny.listeners;

import com.rabbitcomapny.Passky;
import com.rabbitcomapny.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageListener implements Listener {

	private final Passky passky;

	public PlayerDamageListener(Passky plugin) {
		passky = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e) {
		if (Utils.isFake(e.getEntity())) {
			return;
		}

		if (e.getEntity() instanceof Player) {
			if (!Passky.isLoggedIn.getOrDefault(e.getEntity().getUniqueId(), false)) {
				e.setCancelled(true);
			}
		}
	}
}

package com.rabbitcomapny.listeners;

import com.rabbitcomapny.Passky;
import com.rabbitcomapny.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

	private final Passky passky;

	public BlockBreakListener(Passky plugin) {
		passky = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if (Utils.isFake(e.getPlayer())) {
			return;
		}

		if (!Passky.isLoggedIn.getOrDefault(e.getPlayer().getUniqueId(), false)) {
			e.setCancelled(true);
		}
	}

}

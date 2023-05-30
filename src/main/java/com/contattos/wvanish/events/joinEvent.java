package com.contattos.wvanish.events;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.contattos.wvanish.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class joinEvent implements Listener {

    Main plugin;

    public joinEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (player.hasPermission("wvanish.vanish")) {
            if (!Main.listaInvisivel.contains(player)) {
                for (Player pessoa : Bukkit.getOnlinePlayers()) {
                    pessoa.hidePlayer(player);
                }
                //plugin.actionBarTask.runTaskTimer(plugin, 0, 50);
                //plugin.actionBarTasks.put(player, plugin.actionBarTask);
                Main.listaInvisivel.add(player);
            }
        }
    }
}
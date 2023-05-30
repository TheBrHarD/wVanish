package com.contattos.wvanish.events;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.contattos.wvanish.Main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class itemDrop implements Listener {

    Main plugin;

    public itemDrop(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerPickupItemEvent(PlayerPickupItemEvent e) {
        Player player = e.getPlayer();
        if (Main.listaInvisivel.contains(player)) {
            ActionBarAPI.sendActionBar(player, "§cVocê não pode pegar itens com o vanish ativado.");
            e.setCancelled(true);
        }
    }
}
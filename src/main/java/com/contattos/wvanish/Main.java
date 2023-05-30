package com.contattos.wvanish;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.contattos.wvanish.commands.randomCommand;
import com.contattos.wvanish.commands.vanishCommand;
import com.contattos.wvanish.events.itemDrop;
import com.contattos.wvanish.events.joinEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends JavaPlugin implements Listener {

    public static ArrayList<Player> listaInvisivel = new ArrayList<>();
    public HashMap<Player, BukkitRunnable> actionBarTasks = new HashMap<>();
    public BukkitRunnable actionBarTask = new BukkitRunnable() {
        @Override
        public void run() {

            for(Player player :Bukkit.getOnlinePlayers()) {
                ActionBarAPI.sendActionBar(player, "§aVocê está invisível!");
            }
        }
    };

    @Override
    public void onEnable() {
        getLogger().info("Plugin inicializado com sucesso!");
        getCommand("vanish").setExecutor(new vanishCommand(this));
        getCommand("rtp").setExecutor(new randomCommand());
        getServer().getPluginManager().registerEvents(new joinEvent(this), this);
        getServer().getPluginManager().registerEvents(new itemDrop(this), this);
    }
}

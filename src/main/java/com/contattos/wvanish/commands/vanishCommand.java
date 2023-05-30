package com.contattos.wvanish.commands;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.contattos.wvanish.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

public class vanishCommand implements CommandExecutor {

    Main plugin;

    public vanishCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("wvanish.vanish")){
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (Main.listaInvisivel.contains(player)) {
                    for (Player pessoa : Bukkit.getOnlinePlayers()) {
                        pessoa.showPlayer(player);
                    }
                    Main.listaInvisivel.remove(player);
                    BukkitRunnable task = plugin.actionBarTasks.remove(player);
                    if (task != null) {
                        task.cancel();
                        plugin.actionBarTasks.clear();
                    }
                    player.sendMessage("§cVocê não está mais invisível para todos!");
                    ActionBarAPI.sendActionBar(player, "§cVocê não está mais invisível para todos!", 10);
                } else{
                    for (Player pessoa : Bukkit.getOnlinePlayers()) {
                        pessoa.hidePlayer(player);
                    }
                    if (plugin.actionBarTasks.containsKey(player)){
                        plugin.actionBarTasks.clear();
                    }
                        plugin.actionBarTask.runTaskTimer(plugin, 0, 50);
                        plugin.actionBarTasks.put(player, plugin.actionBarTask);
                    Main.listaInvisivel.add(player);
                    player.sendMessage("§aVocê está invisível para todos!");

                }

            } else {
                sender.sendMessage("§cApenas jogadores podem executar este comando!");
            }
        }else {
            sender.sendMessage("§cVocê não tem o grupo §2[Moderador] §cpara executar este comando.");
        }

        return true;
    }
}

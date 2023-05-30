package com.contattos.wvanish.commands;

import com.contattos.wvanish.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class randomCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("wvanish.vanish")) {
            if (sender instanceof Player) {

                Player player = (Player) sender;

                    if (command.getName().equalsIgnoreCase("rtp")) {
                        Player[] online = Bukkit.getOnlinePlayers().toArray(new Player[0]);
                        if (online.length == 0) {
                            player.sendMessage("§cNão há jogadores online para teleportar.");
                            return true;
                        }
                        Random random = new Random();
                        Player randomPlayer = online[random.nextInt(online.length)];
                        player.teleport(randomPlayer);
                        player.sendMessage("§aVocê foi teleportado para o jogador §7" + randomPlayer.getName() + "§a.");
                    }

                } else {
                    sender.sendMessage("§cApenas jogadores podem executar este comando.");
                }
            }else {
                sender.sendMessage("§cVocê não tem o grupo §2[Moderador] §cpara executar este comando.");
        }
        return true;
    }
}

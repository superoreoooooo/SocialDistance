package org.oreoprojekt.socialdistancepl.SDCommand;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.oreoprojekt.socialdistancepl.SDUtil.SocialDistanceUtil;
import org.oreoprojekt.socialdistancepl.SocialDistancePL;

public class SocialDistanceCommand implements CommandExecutor {
    private SocialDistanceUtil socialDistanceUtil;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("no console");
            return false;
        }
        if (args.length == 1) {
            if (args[0].equals("on")) {
                Bukkit.broadcastMessage("Social Distance Plugin enabled");
                socialDistanceUtil.set(true);
                return true;
            }
            if (args[0].equals("off")) {
                Bukkit.broadcastMessage("Social Distance Plugin disabled");
                socialDistanceUtil.set(false);
                return true;
            }
            if (args[0].equals("now")) {
                Bukkit.broadcastMessage("Social Distance Status = " + socialDistanceUtil.status());
                return true;
            }
            if (args[0].equals("list")) {
                sender.sendMessage(socialDistanceUtil.getInfected().toString());
                return true;
            }
            if (args[0].equals("clear")) {
                Bukkit.broadcastMessage("초기화 완료");
                Bukkit.broadcastMessage(socialDistanceUtil.getInfected().toString());
                socialDistanceUtil.resetInfected();
                return true;
            }
            else {
                sender.sendMessage("wrong type");
                return false;
            }
        }

        if (args.length == 2) {
            if (args[0].equals("infect")) {
                Player player = Bukkit.getPlayer(args[1]);
                socialDistanceUtil.setInfected(player);
            }
            if (args[0].equals("heal")) {
                Player player = Bukkit.getPlayer(args[1]);
                socialDistanceUtil.setHealed(player);
            }
        }
        return false;
    }
}

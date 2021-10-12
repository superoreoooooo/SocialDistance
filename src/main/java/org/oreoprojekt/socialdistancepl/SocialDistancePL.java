package org.oreoprojekt.socialdistancepl;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.oreoprojekt.socialdistancepl.SDCommand.SocialDistanceCommand;

public final class SocialDistancePL extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "SocialDistancePlugin ON");
        getCommand("SocialDistance").setExecutor(new SocialDistanceCommand());
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "SocialDistancePlugin OFF");
    }
}

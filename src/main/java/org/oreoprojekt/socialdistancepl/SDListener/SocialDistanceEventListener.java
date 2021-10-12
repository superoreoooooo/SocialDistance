package org.oreoprojekt.socialdistancepl.SDListener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.oreoprojekt.socialdistancepl.SDUtil.SocialDistanceUtil;

import java.util.Random;

public class SocialDistanceEventListener implements Listener {
    private SocialDistanceUtil socialDistanceUtil;

    double limit = 2.0;

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        socialDistanceUtil.setHealed(player);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (!(socialDistanceUtil.status())) return;
        Player player = e.getPlayer();
        Random killPer = new Random();
        int check2die = killPer.nextInt(25);
        if (check2die == 0) {
            player.sendMessage("당신은 점점 죽어가는것이 느껴집니다..");
            player.setHealth(3);
            player.setHealth(2);
            player.setHealth(1);
            player.setHealth(0);
        }
        for (Player target : Bukkit.getOnlinePlayers()) {
            if (!(socialDistanceUtil.isInfected(target))) return;
            double distance = player.getLocation().distance(target.getLocation());
            if (distance >= limit) {
                Random random = new Random();
                int check = random.nextInt(10);
                if (check == 0) {
                    player.sendMessage("천운의 확률로 코로나에 감염되지 않았습니다. 잘 살아보세요");
                    return;
                }
                player.sendMessage("당신은 코로나에 감염되었습니다 ㅋㅋ 잘가시고");
                socialDistanceUtil.setInfected(player);
            }
        }
    }
}

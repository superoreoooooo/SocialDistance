package org.oreoprojekt.socialdistancepl.SDUtil;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SocialDistanceUtil {
    List<Player> coronaList = new ArrayList<>();

    boolean isOn = false;

    public boolean status() {
        return isOn;
    }

    public void set(boolean t) {
        isOn = t;
    }

    public List<Player> getInfected() {
        return coronaList;
    }

    public void setInfected(Player player) {
        coronaList.add(player);
    }

    public void resetInfected() {
        coronaList.clear();
    }

    public boolean isInfected(Player player) {
        return coronaList.contains(player);
    }

    public void setHealed(Player player) {
        coronaList.remove(player);
    }


}


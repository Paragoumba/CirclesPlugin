package fr.paragoumba.circlesplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class CirclesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("circle").setExecutor(new CircleCommand());

    }
}

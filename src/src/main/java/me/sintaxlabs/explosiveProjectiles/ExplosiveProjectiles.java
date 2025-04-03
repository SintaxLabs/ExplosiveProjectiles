package me.sintaxlabs.explosiveProjectiles;

import me.sintaxlabs.explosiveProjectiles.listeners.entityHurtCheck;

import me.sintaxlabs.explosiveProjectiles.listeners.entityShootBowCheck;
import me.sintaxlabs.explosiveProjectiles.listeners.projectileHitCheck;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExplosiveProjectiles extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new entityHurtCheck(), this);
        getServer().getPluginManager().registerEvents(new entityShootBowCheck(), this);
        getServer().getPluginManager().registerEvents(new projectileHitCheck(), this);

        Global.explosiveImpact = this.getConfig().getInt("explosive-impact");
        Global.toggleFire = this.getConfig().getBoolean("toggle-Fire");
        Global.toggleBreakBlocks = this.getConfig().getBoolean("toggle-BreakBlocks");
        Global.toggleHurtPlayer = this.getConfig().getInt("toggle-HurtPlayer");
        Global.toggleHurtMobs = this.getConfig().getInt("toggle-HurtMobs");

        Global.toggleBow = this.getConfig().getInt("BOW");
        Global.toggleSnowball = this.getConfig().getInt("SNOWBALL");
        Global.toggleEgg = this.getConfig().getInt("EGG");

        Global.toggleVerbose = this.getConfig().getInt("verbose");

        if (Global.toggleVerbose == 1)
        {
            getLogger().warning("Verbose is enabled for ExplosiveBow. This can be changed in your config file.");
        }
    }



    public static class Global
    {
        public static int playerShoot = 0;
        public static int playerHit = 0;

        public static int explosiveImpact;
        public static boolean toggleFire;
        public static boolean toggleBreakBlocks;
        public static int toggleHurtPlayer;
        public static int toggleHurtMobs;

        public static int toggleBow;
        public static int toggleSnowball;
        public static int toggleEgg;

        public static int kaboom;
        public static int toggleVerbose;
    }


    //Verbose Operator Join Disclaimer
    @EventHandler
    public void playerJoinEvent (PlayerJoinEvent e)
    {
        if (Global.toggleVerbose == 1)
        {
            Player player = e.getPlayer();
            if (player.isOp())
            {
                player.sendMessage("ExplosiveProjectiles - Verbose is enabled. This can be changed in your config file.");
            }
        }
    }









    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }
}

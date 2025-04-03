package me.sintaxlabs.explosiveProjectiles.listeners;

import me.sintaxlabs.explosiveProjectiles.ExplosiveProjectiles;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

import static org.bukkit.Bukkit.getServer;

public final class entityShootBowCheck implements Listener
{
    @EventHandler
    public void playerShootBowCheck (EntityShootBowEvent e)
    {
        //Check 00c
        if (ExplosiveProjectiles.Global.toggleBow == 1)
        {
            //Check 01c
            if (e.getEntityType() == EntityType.PLAYER)
            {
                ExplosiveProjectiles.Global.playerShoot = 1;
                //Check 02c
                if (ExplosiveProjectiles.Global.toggleVerbose == 1)
                {
                    getServer().sendRichMessage("EP - Step 1c Success. Player shot bow.");
                    getServer().sendRichMessage(" ");
                }
            }
        }
    }
}
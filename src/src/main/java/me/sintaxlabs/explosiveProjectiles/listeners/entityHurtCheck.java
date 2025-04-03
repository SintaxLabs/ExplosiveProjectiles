package me.sintaxlabs.explosiveProjectiles.listeners;

import me.sintaxlabs.explosiveProjectiles.ExplosiveProjectiles;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


import static org.bukkit.Bukkit.getServer;



public final class entityHurtCheck implements Listener
{
    public static class hurtGlobal
    {
        public static int mobCount = 1;
    }

    @EventHandler
    public void damageCheck (EntityDamageEvent e)
    {
        //getServer().sendRichMessage("DamageEvent called.");
        if (e.getEntityType() == EntityType.PLAYER)
        {
            //Check 00a
            if (ExplosiveProjectiles.Global.toggleHurtPlayer == 0)
            {
                //Check 01a
                if (ExplosiveProjectiles.Global.kaboom == 1)
                {
                    if (ExplosiveProjectiles.Global.toggleVerbose == 1)
                    {
                        getServer().sendRichMessage("EP - Step 1a-2 Success - No explosive damage to player.");
                        getServer().sendRichMessage(" ");
                    }
                    e.setDamage(0);
                }
            }
            else if (ExplosiveProjectiles.Global.toggleVerbose == 1)
            {
                if(e.getEntityType() != EntityType.ITEM)
                {
                    getServer().sendRichMessage("EP - Step 1a-1 Success - Player received explosive damage.");
                    getServer().sendRichMessage(" ");
                    hurtGlobal.mobCount ++;
                }

            }
        }
        //-----------------------------------------------------------------------------------------------------
        if (e.getEntityType() != EntityType.PLAYER)
        {
            //Check 00b

            if (ExplosiveProjectiles.Global.toggleHurtMobs == 0)
            {
                //Check 01b
                if (ExplosiveProjectiles.Global.kaboom == 1)
                {
                    if (ExplosiveProjectiles.Global.toggleVerbose == 1)
                    {
                        if(e.getEntityType() != EntityType.ITEM)
                        {
                            getServer().sendRichMessage("EP - Step 1b-2 Success - "+ e.getEntityType() + " (" + hurtGlobal.mobCount + ")" +" countered explosion.");
                            getServer().sendRichMessage(" ");
                            hurtGlobal.mobCount ++;
                        }

                    }
                    e.setDamage(0);
                    //entityHurtCheck.hurtGlobal.mobCount = 1;
                }
            }
            else if (ExplosiveProjectiles.Global.toggleVerbose == 1)
            {
                if(e.getEntityType() != EntityType.ITEM)
                {
                    if (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)
                    {
                        getServer().sendRichMessage("EP - Step 1b-1 Success - "+ e.getEntityType() + " (" + hurtGlobal.mobCount + ")" +" received explosive damage.");
                        getServer().sendRichMessage(" ");
                        hurtGlobal.mobCount ++;
                    }

                }

            }
        }
    }
}

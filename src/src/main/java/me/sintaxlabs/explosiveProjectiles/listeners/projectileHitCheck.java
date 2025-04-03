package me.sintaxlabs.explosiveProjectiles.listeners;

import me.sintaxlabs.explosiveProjectiles.ExplosiveProjectiles;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public final class projectileHitCheck implements Listener
{
    @EventHandler
    public void projectileBlockCheck (ProjectileHitEvent e)
    {
        var projectileType = e.getEntity().getType();


        //Now the show starts
        //Check #1 - Entity Hit Check
        if (e.getHitBlock() == null)
        {
            //Projectile Check - Arrow
            //Check 2a-1
            if (Objects.equals(projectileType.toString(), "ARROW"))
            {
                if (ExplosiveProjectiles.Global.playerShoot == 1)
                {
                    if (ExplosiveProjectiles.Global.toggleBow == 1)
                    {
                        Location locationEntity = e.getHitEntity().getLocation();
                        World worldEntity = e.getHitEntity().getWorld();
                        EntityType entityType = EntityType.PLAYER;

                        //Check #2 - Player Check
                        if (entityType == e.getHitEntity().getType())
                        {
                            ExplosiveProjectiles.Global.playerHit = 1;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                        }
                        else
                        {
                            ExplosiveProjectiles.Global.kaboom = 1;
                            worldEntity.createExplosion(locationEntity, ExplosiveProjectiles.Global.explosiveImpact, ExplosiveProjectiles.Global.toggleFire, ExplosiveProjectiles.Global.toggleBreakBlocks);
                            ExplosiveProjectiles.Global.playerShoot = 0;
                            ExplosiveProjectiles.Global.playerHit = 0;
                            ExplosiveProjectiles.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;

                            if (ExplosiveProjectiles.Global.toggleVerbose == 1)
                            {
                                if (ExplosiveProjectiles.Global.toggleHurtMobs == 0)
                                {
                                    getServer().sendRichMessage("EP - Step 2a-1 Success - You shot " + e.getHitEntity().getType() + " but toggleHurtMob was disabled.");
                                    getServer().sendRichMessage(" ");
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                }
                                else
                                {
                                    getServer().sendRichMessage("EP - Step 2a-1 Success - " + e.getHitEntity().getType() + " received explosive damage.");
                                    getServer().sendRichMessage(" ");
                                    //entityHurtCheck.hurtGlobal.mobCount = 1;
                                }

                            }
                        }
                    }
                }
            }
            //Projectile Check - Snowball
            //Check 2a-2
            else if (Objects.equals(projectileType.toString(), "SNOWBALL"))
            {
                if (ExplosiveProjectiles.Global.toggleSnowball == 1)
                {
                    Location locationEntity = e.getHitEntity().getLocation();
                    World worldEntity = e.getHitEntity().getWorld();
                    EntityType entityType = EntityType.PLAYER;

                    //Check #2 - Player Check
                    //This is primarily here for if a player hits themselves. We don't want them to.
                    if (entityType == e.getHitEntity().getType())
                    {
                        ExplosiveProjectiles.Global.playerHit = 1;
                        entityHurtCheck.hurtGlobal.mobCount = 1;
                    }
                    else
                    {
                        ExplosiveProjectiles.Global.kaboom = 1;
                        worldEntity.createExplosion(locationEntity, ExplosiveProjectiles.Global.explosiveImpact, ExplosiveProjectiles.Global.toggleFire, ExplosiveProjectiles.Global.toggleBreakBlocks);
                        ExplosiveProjectiles.Global.playerShoot = 0;
                        ExplosiveProjectiles.Global.playerHit = 0;
                        ExplosiveProjectiles.Global.kaboom = 0;
                        entityHurtCheck.hurtGlobal.mobCount = 1;

                        if (ExplosiveProjectiles.Global.toggleVerbose == 1)
                        {
                            if (ExplosiveProjectiles.Global.toggleHurtMobs == 0)
                            {
                                getServer().sendRichMessage("EP - Step 2a-2 Success - You hit " + e.getHitEntity().getType() + " but toggleHurtMob was disabled.");
                                getServer().sendRichMessage(" ");
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                            }
                            else
                            {
                                getServer().sendRichMessage("EP - Step 2a-2 Success - " + e.getHitEntity().getType() + " received explosive damage.");
                                getServer().sendRichMessage(" ");
                                //entityHurtCheck.hurtGlobal.mobCount = 1;
                            }
                        }
                    }
                }
            }
            //Projectile Check - Egg
            //Check 2a-3
            else if (Objects.equals(projectileType.toString(), "EGG"))
            {
                if (ExplosiveProjectiles.Global.toggleEgg == 1)
                {
                    Location locationEntity = e.getHitEntity().getLocation();
                    World worldEntity = e.getHitEntity().getWorld();
                    EntityType entityType = EntityType.PLAYER;

                    //Check #2 - Player Check
                    if (entityType == e.getHitEntity().getType())
                    {
                        ExplosiveProjectiles.Global.playerHit = 1;
                        entityHurtCheck.hurtGlobal.mobCount = 1;
                    }
                    else
                    {
                        ExplosiveProjectiles.Global.kaboom = 1;
                        worldEntity.createExplosion(locationEntity, ExplosiveProjectiles.Global.explosiveImpact, ExplosiveProjectiles.Global.toggleFire, ExplosiveProjectiles.Global.toggleBreakBlocks);
                        ExplosiveProjectiles.Global.playerShoot = 0;
                        ExplosiveProjectiles.Global.playerHit = 0;
                        ExplosiveProjectiles.Global.kaboom = 0;
                        entityHurtCheck.hurtGlobal.mobCount = 1;

                        if (ExplosiveProjectiles.Global.toggleVerbose == 1)
                        {
                            if (ExplosiveProjectiles.Global.toggleHurtMobs == 0)
                            {
                                getServer().sendRichMessage("EP - Step 2a-3 Success - You hit " + e.getHitEntity().getType() + " but toggleHurtMob was disabled.");
                                getServer().sendRichMessage(" ");
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                            }
                            else
                            {
                                getServer().sendRichMessage("EP - Step 2a-3 Success - " + e.getHitEntity().getType() + " received explosive damage.");
                                getServer().sendRichMessage(" ");
                                //entityHurtCheck.hurtGlobal.mobCount = 1;
                            }
                        }
                    }
                }
            }

        }
        //Check #2 - Block Hit Check
        else
        {
            //Projectile Check - Arrow
            //Check 2b-1
            if (Objects.equals(projectileType.toString(), "ARROW")) {
                if (ExplosiveProjectiles.Global.playerShoot == 1)
                {
                    if (ExplosiveProjectiles.Global.toggleBow == 1)
                    {
                        if (ExplosiveProjectiles.Global.playerHit == 1)
                        {
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                        }

                        ExplosiveProjectiles.Global.kaboom = 1;
                        Location locationBlock = e.getHitBlock().getLocation();
                        World worldBlock = locationBlock.getWorld();
                        worldBlock.createExplosion(locationBlock, ExplosiveProjectiles.Global.explosiveImpact, ExplosiveProjectiles.Global.toggleFire, ExplosiveProjectiles.Global.toggleBreakBlocks);
                        ExplosiveProjectiles.Global.playerShoot = 0;
                        ExplosiveProjectiles.Global.playerHit = 0;
                        ExplosiveProjectiles.Global.kaboom = 0;
                        entityHurtCheck.hurtGlobal.mobCount = 1;

                        if (ExplosiveProjectiles.Global.toggleVerbose == 1)
                        {
                            getServer().sendRichMessage("EP - Step 2b-1 Success - Block received explosion.");
                            getServer().sendRichMessage(" ");
                        }
                    }
                }
            }
            //Projectile Check - Snowball
            //Check 2b-2
            else if (Objects.equals(projectileType.toString(), "SNOWBALL")) {
                if (ExplosiveProjectiles.Global.toggleSnowball == 1)
                {
                    if (ExplosiveProjectiles.Global.playerHit == 1)
                    {
                        entityHurtCheck.hurtGlobal.mobCount = 1;
                    }

                    ExplosiveProjectiles.Global.kaboom = 1;
                    Location locationBlock = e.getHitBlock().getLocation();
                    World worldBlock = locationBlock.getWorld();
                    worldBlock.createExplosion(locationBlock, ExplosiveProjectiles.Global.explosiveImpact, ExplosiveProjectiles.Global.toggleFire, ExplosiveProjectiles.Global.toggleBreakBlocks);
                    ExplosiveProjectiles.Global.playerShoot = 0;
                    ExplosiveProjectiles.Global.playerHit = 0;
                    ExplosiveProjectiles.Global.kaboom = 0;
                    entityHurtCheck.hurtGlobal.mobCount = 1;

                    if (ExplosiveProjectiles.Global.toggleVerbose == 1)
                    {
                        getServer().sendRichMessage("EP - Step 2b-2 Success - Block received explosion.");
                        getServer().sendRichMessage(" ");
                    }
                }
            }
            //Projectile Check - Egg
            //Check 2b-3
            else if (Objects.equals(projectileType.toString(), "EGG")) {
                if (ExplosiveProjectiles.Global.toggleEgg == 1)
                {
                    if (ExplosiveProjectiles.Global.playerHit == 1)
                    {
                        entityHurtCheck.hurtGlobal.mobCount = 1;
                    }

                    ExplosiveProjectiles.Global.kaboom = 1;
                    Location locationBlock = e.getHitBlock().getLocation();
                    World worldBlock = locationBlock.getWorld();
                    worldBlock.createExplosion(locationBlock, ExplosiveProjectiles.Global.explosiveImpact, ExplosiveProjectiles.Global.toggleFire, ExplosiveProjectiles.Global.toggleBreakBlocks);
                    ExplosiveProjectiles.Global.playerShoot = 0;
                    ExplosiveProjectiles.Global.playerHit = 0;
                    ExplosiveProjectiles.Global.kaboom = 0;
                    entityHurtCheck.hurtGlobal.mobCount = 1;

                    if (ExplosiveProjectiles.Global.toggleVerbose == 1)
                    {
                        getServer().sendRichMessage("EP - Step 2b-3 Success - Block received explosion.");
                        getServer().sendRichMessage(" ");
                    }
                }
            }
        }
    }
}

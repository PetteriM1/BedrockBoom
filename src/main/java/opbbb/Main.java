package opbbb;

import cn.nukkit.entity.item.EntityPrimedTNT;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityExplosionPrimeEvent;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBigBoom(EntityExplosionPrimeEvent e) {
        if (!e.isCancelled() && e.getEntity() instanceof EntityPrimedTNT) {
            e.setCancelled(true);
            opbbb.BigExplosion explosion = new opbbb.BigExplosion(e.getEntity(), (float) e.getForce() - 0.1, e.getEntity());
            if (explosion.explodeA()) {
                explosion.explodeB();
            }
        }
    }
}

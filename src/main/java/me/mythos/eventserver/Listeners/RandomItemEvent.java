package me.mythos.eventserver.Listeners;
import me.mythos.eventserver.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import java.util.Random;


public class RandomItemEvent implements Listener {

    private Main plugin;

    public Material[] itemsChosable = Material.values();

    private Random rand = new Random();

    public int amountSelected;
    Material itemChosen;

    public RandomItemEvent(Main plugin)
    {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void onPlayerJoinEvent(PlayerJoinEvent e)
    {
        Player player = e.getPlayer();
        BukkitScheduler scheduler = player.getServer().getScheduler();

        scheduler.scheduleSyncRepeatingTask(this.plugin, new Runnable() {
            @Override
            public void run()
            {
                RandomItem();
                RandomAmount();
                

                ItemStack item = new ItemStack(itemChosen);
                item.setAmount(amountSelected);
                player.getInventory().addItem(item);

            }
        }, 40L, 600L);
    }

    private void RandomItem()
    {
        itemChosen = itemsChosable[rand.nextInt(itemsChosable.length)];

        while (itemChosen.name().contains("COMMAND") || itemChosen.name().contains("DEAD") || itemChosen.name().contains("BARRIER") || itemChosen.isAir() || !itemChosen.isItem())
        {
            itemChosen = itemsChosable[rand.nextInt(itemsChosable.length)];
        }
    }

    private void RandomAmount()
    {
        int upperBound = 64;
        amountSelected = rand.nextInt(upperBound);
    }

}

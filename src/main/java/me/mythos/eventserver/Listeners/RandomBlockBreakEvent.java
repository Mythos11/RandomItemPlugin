package me.mythos.eventserver.Listeners;
import me.mythos.eventserver.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Consumer;

import java.util.Random;

public class RandomBlockBreakEvent implements Listener {

    private Main plugin;
    private final Material[] itemsChosable = Material.values();

    private Material itemChosen;
    private int amountSelected;
    private final Random rand = new Random();

    public RandomBlockBreakEvent(Main plugin)
    {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void DropItem(BlockDropItemEvent e)
    {
        Location loc = e.getBlock().getLocation();
        RandomItem();
        RandomAmount();

        ItemStack item = new ItemStack(itemChosen);
        item.setAmount(amountSelected);

        e.getPlayer().getWorld().dropItem(loc, item);
    }

    private void RandomItem()
    {
        itemChosen = itemsChosable[rand.nextInt(itemsChosable.length)];

        while (itemChosen.name().contains("COMMAND") || itemChosen.name().contains("DEAD") || itemChosen.name().contains("BARRIER") || itemChosen.name().contains("JIGSAW") || itemChosen.isAir() || !itemChosen.isItem())
        {
            itemChosen = itemsChosable[rand.nextInt(itemsChosable.length)];
        }
    }

    private void RandomAmount()
    {
        int upperBound = 120;
        amountSelected = rand.nextInt(upperBound);
    }
}

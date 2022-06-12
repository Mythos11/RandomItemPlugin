package me.mythos.eventserver.Commands;

import me.mythos.eventserver.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TestCommand implements CommandExecutor {

    private Main plugin;

    public TestCommand(Main plugin)
    {
        this.plugin = plugin;
        Objects.requireNonNull(plugin.getCommand("Test")).setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemStack emeralds = new ItemStack(Material.EMERALD);

        diamond.setAmount(28);
        emeralds.setAmount(28);

        player.getInventory().addItem(diamond, emeralds);
        return true;
    }
}

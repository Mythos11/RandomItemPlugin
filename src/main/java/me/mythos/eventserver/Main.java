package me.mythos.eventserver;

import me.mythos.eventserver.Commands.TestCommand;
import me.mythos.eventserver.Listeners.RandomBlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable()
    {
        new TestCommand(this);
        new RandomBlockBreakEvent(this);
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }
}

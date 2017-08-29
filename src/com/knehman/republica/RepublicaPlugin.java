package com.knehman.republica;

import org.bukkit.plugin.java.JavaPlugin;

import com.knehman.republica.Commands.AbstractCommand;
import com.knehman.republica.Commands.LocationCommands;

public class RepublicaPlugin extends JavaPlugin {

	static final String pluginName = "Republica Convenience Plugin";
	public static final String prefix = "[RSMP] ";
	
	@Override
	public void onEnable() {
		AbstractCommand abstractCommand = new AbstractCommand(this);
		this.getCommand("loc").setExecutor(new LocationCommands(this));

		abstractCommand.initPerms();
		System.out.println(pluginName + " is enabled");
	}
	
	@Override
	public void onDisable() {
		System.out.println(pluginName + " is disabled");
	}
}

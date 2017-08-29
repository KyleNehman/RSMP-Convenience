package com.knehman.republica.Commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import republica.knehman.com.RepublicaPlugin;

public class AbstractCommand {
	static Map<String, List<String>> loadedCommands = new HashMap<String, List<String>>();
	static Map<String, String> commandPerms;
	static final String permPrefix = "rsmp.";
	
	Plugin plugin;
	
	public AbstractCommand() {
	}
	
	public AbstractCommand(String clazzName, List<String> commandNames) {
		if (!AbstractCommand.loadedCommands.containsKey(clazzName)) {
			AbstractCommand.loadedCommands.put(clazzName, commandNames);
		}
	}
	
	public AbstractCommand(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public void initPerms() {
		commandPerms = new HashMap<String, String>();
		for (String key : loadedCommands.keySet()) {
			List<String> commands = loadedCommands.get(key);
			
			if (commands != null) {
				for (String command : commands) {
					System.out.println("Debug: " + permPrefix + command);
					commandPerms.put(command, permPrefix + command);
				}
			}
		}
	}
	
	void message(CommandSender sender, String message) {
		String toSend = ChatColor.LIGHT_PURPLE + RepublicaPlugin.prefix + ChatColor.RESET + message;
		sender.sendMessage(toSend);
	}
	
	void errorMessage(CommandSender sender, String message) {
		String toSend = ChatColor.RED + RepublicaPlugin.prefix + ChatColor.RESET + message;
		sender.sendMessage(toSend);
	}
}

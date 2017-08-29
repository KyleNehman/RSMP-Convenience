package com.knehman.republica.Commands;

import java.util.Arrays;
import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class LocationCommands  extends AbstractCommand implements CommandExecutor {

	public LocationCommands(Plugin plugin) {
		super(LocationCommands.class.getName(), Arrays.asList("loc"));
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("loc")) {
			if (sender.hasPermission("rsmp.loc") || sender.isOp()) {
				int argsLength = args.length;
				Player target = null;
				
				if (argsLength == 0) {
					if (sender instanceof Player) {
						target = (Player) sender;
					} else {
						message(sender, "You must be a player to get your own location");
					}
				} else if (argsLength == 1) {
					target = Bukkit.getPlayer(args[0]);
				} else {
					errorMessage(sender, "Invalid amount of arguments");
					return false;
				}
				
				if (target == null) {
					errorMessage(sender, "Player isn't online");
					return false;
				}
					
				Location loc = target.getLocation();
				String x = String.format(Locale.US, "%.2f", loc.getX());
				String y = String.format(Locale.US, "%.2f", loc.getY());
				String z = String.format(Locale.US, "%.2f", loc.getZ());
				String locString = "X: " + x + ", Y: " + y + ", Z: " + z; 
				
				message(sender, target.getName() + "'s location: " + locString);
				return true;
			}
		}
		return false;
	}
}

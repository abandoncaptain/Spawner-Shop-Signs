package me.abandoncaptian.SpawnerSigns;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

	Main plugin;
	MyConfig Config;
	
	public Commands(Main p){
		this.plugin = p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("es")){
			if(args.length < 1){
				sender.sendMessage("§cInvalid Arguments!");
				sender.sendMessage("§7/es [reload/mob]");
			}
			if(args[0].equalsIgnoreCase("reload") && sender.hasPermission("EnerySpawners.reload")){
				if (!Config.contains("Mobs.Prices")){
					Config.set("Mobs.Prices.Creeper", 100000);
					Config.set("Mobs.Prices.Wither-Skel", 100000);
					Config.set("Mobs.Prices.Spider", 100000);
					Config.set("Mobs.Prices.Zombie", 100000);
					Config.set("Mobs.Prices.Slime", 100000);
					Config.set("Mobs.Prices.Ghast", 100000);
					Config.set("Mobs.Prices.Pig-Zombie", 100000);
					Config.set("Mobs.Prices.Enderman", 100000);
					Config.set("Mobs.Prices.Cave-Spider", 100000);
					Config.set("Mobs.Prices.Silverfish", 100000);
					Config.set("Mobs.Prices.Blaze", 100000);
					Config.set("Mobs.Prices.Magma-Cube", 100000);
					Config.set("Mobs.Prices.Bat", 100000);
					Config.set("Mobs.Prices.Witch", 100000);
					Config.set("Mobs.Prices.Guardian", 100000);
					Config.set("Mobs.Prices.Pig", 100000);
					Config.set("Mobs.Prices.Sheep", 100000);
					Config.set("Mobs.Prices.Cow", 100000);
					Config.set("Mobs.Prices.Chicken", 100000);
					Config.set("Mobs.Prices.Squid", 100000);
					Config.set("Mobs.Prices.Wolf", 100000);
					Config.set("Mobs.Prices.Mooshroom", 100000);
					Config.set("Mobs.Prices.Iron-Golem", 100000);
					Config.set("Mobs.Prices.Villager", 100000);
					Config.saveConfig();
				}
				Config.reloadConfig();
				sender.sendMessage("§aReloaded Energy Spawners Config");
			}
			if(args[0].equalsIgnoreCase("mob") && sender.hasPermission("EnerySpawners.scan")){
				if(args.length == 1){
					sender.sendMessage("§9Use this to determine the mob type ID");
					sender.sendMessage("§7EX: /es mob creeper");
					sender.sendMessage("§7Will return: §b50");
					return true;
				}
				if(args.length > 2){
					sender.sendMessage("§9To many arguments");
					sender.sendMessage("§7EX: /es mob cave-spider");
					return true;
				}
				switch(args[1].toUpperCase()){
				case "CREEPER":
					sender.sendMessage("§b50");
					break;
				case "WITHER-SKELETON":
				case "WITHER-SKEL":
					sender.sendMessage("§b51");
					break;
				case "SPIDER":
					sender.sendMessage("§b52");
					break;
				case "ZOMBIE":
					sender.sendMessage("§b54");
					break;
				case "SLIME":
					sender.sendMessage("§b50");
					break;
				case "GHAST":
					sender.sendMessage("§b56");
					break;
				case "ZOMBIE-PIGMAN":
				case "PIG-ZOMBIE":
					sender.sendMessage("§b57");
					break;
				case "ENDERMAN":
					sender.sendMessage("§b58");
					break;
				case "CAVE-SPIDER":
					sender.sendMessage("§b59");
					break;
				case "SILVERFISH":
					sender.sendMessage("§b60");
					break;
				case "BLAZE":
					sender.sendMessage("§b61");
					break;
				case "MAGMA-SLIME":
				case "MAGMA-CUBE":
					sender.sendMessage("§b62");
					break;
				case "BAT":
					sender.sendMessage("§b65");
					break;
				case "WITCH":
					sender.sendMessage("§b66");
					break;
				case "GUARDIAN":
					sender.sendMessage("§b68");
					break;
				case "PIG":
					sender.sendMessage("§b90");
					break;
				case "SHEEP":
					sender.sendMessage("§b91");
					break;
				case "COW":
					sender.sendMessage("§b92");
					break;
				case "CHICKEN":
					sender.sendMessage("§b93");
					break;
				case "SQUID":
					sender.sendMessage("§b94");
					break;
				case "WOLF":
					sender.sendMessage("§b95");
					break;
				case "MUSHROOM-COW":
				case "MOOSHROOM":
					sender.sendMessage("§b96");
					break;
				case "IRON-GOLEM":
					sender.sendMessage("§b99");
					break;
				case "VILLAGER":
					sender.sendMessage("§b120");
					break;
				default:
					sender.sendMessage("§cUnable to locate mob type!");
					sender.sendMessage("§7EX: cave-spider");
					sender.sendMessage("§7Do not use spaces, use - instead");
					break;
				}
				return true;
				
			}
		}
		return true;
	}
	
}

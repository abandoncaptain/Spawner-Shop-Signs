package me.abandoncaptian.SpawnerSigns;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin implements Listener{

	Logger myPluginLogger = Bukkit.getLogger();
	MyConfigManager manager;
	MyConfig Config;
	public static Economy econ = null;

	@Override
	public void onEnable()
	{
		if(!setupEconomy()){
			myPluginLogger.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		myPluginLogger.info("--------------------------------");
		myPluginLogger.info("          Spawner Signs Enabled");
		myPluginLogger.info("--------------------------------");
		getServer().getPluginManager().registerEvents(this, this);
		manager = new MyConfigManager(this);
		Config = manager.getNewConfig("config.yml", new String[] {"Spawner Signs Config"});
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
	}

	@Override
	public void onDisable()
	{
		myPluginLogger.info("--------------------------------");
		myPluginLogger.info("          Spawner Signs Disabled");
		myPluginLogger.info("--------------------------------");
	}

	private boolean setupEconomy(){
		if(getServer().getPluginManager().getPlugin("Vault") == null){
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if(rsp == null){
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}
	
	
	@EventHandler
	public void onSign(SignChangeEvent e){
		if(e.getLine(0).equalsIgnoreCase("[Spawners]") || e.getLine(0).equalsIgnoreCase("[s]") || e.getLine(0).equalsIgnoreCase("spawners")){
			if(e.getPlayer().hasPermission("spawnersigns.signcreate")){
				e.setLine(0, "§1[Spawners]");
				if (Integer.parseInt(e.getLine(1).split(":")[0]) == 52){
					int data = Integer.parseInt(e.getLine(1).split(":")[1]);
					switch(data){
					case 50:
						e.setLine(1, "§bCreeper");
						e.setLine(3, Config.getString("Mobs.Prices.Creeper"));
						break;
					case 51:
						e.setLine(1, "§bWither Skel.");
						e.setLine(3, Config.getString("Mobs.Prices.Wither-Skel"));
						break;
					case 52:
						e.setLine(1, "§bSpider");
						e.setLine(3, Config.getString("Mobs.Prices.Spider"));
						break;
					case 54:
						e.setLine(1, "§bZombie");
						e.setLine(3, Config.getString("Mobs.Prices.Zombie"));
						break;
					case 55:
						e.setLine(1, "§bSlime");
						e.setLine(3, Config.getString("Mobs.Prices.Slime"));
						break;
					case 56:
						e.setLine(1, "§bGhast");
						e.setLine(3, Config.getString("Mobs.Prices.Ghast"));
						break;
					case 57:
						e.setLine(1, "§bPig Zombie");
						e.setLine(3, Config.getString("Mobs.Prices.Pig-Zombie"));
						break;
					case 58:
						e.setLine(1, "§bEnderman");
						e.setLine(3, Config.getString("Mobs.Prices.Enderman"));
						break;
					case 59:
						e.setLine(1, "§bCave Spider");
						e.setLine(3, Config.getString("Mobs.Prices.Cave-Spider"));
						break;
					case 60:
						e.setLine(1, "§bSilverfish");
						e.setLine(3, Config.getString("Mobs.Prices.Silverfish"));
						break;
					case 61:
						e.setLine(1, "§bBlaze");
						e.setLine(3, Config.getString("Mobs.Prices.Blaze"));
						break;
					case 62:
						e.setLine(1, "§bMagma Cube");
						e.setLine(3, Config.getString("Mobs.Prices.Magma-Cube"));
						break;
					case 65:
						e.setLine(1, "§bBat");
						e.setLine(3, Config.getString("Mobs.Prices.Bat"));
						break;
					case 66:
						e.setLine(1, "§bWitch");
						e.setLine(3, Config.getString("Mobs.Prices.Witch"));
						break;
					case 68:
						e.setLine(1, "§bGuardian");
						e.setLine(3, Config.getString("Mobs.Prices.Guardian"));
						break;
					case 90:
						e.setLine(1, "§bPig");
						e.setLine(3, Config.getString("Mobs.Prices.Pig"));
						break;
					case 91:
						e.setLine(1, "§bSheep");
						e.setLine(3, Config.getString("Mobs.Prices.Sheep"));
						break;
					case 92:
						e.setLine(1, "§bCow");
						e.setLine(3, Config.getString("Mobs.Prices.Cow"));
						break;
					case 93:
						e.setLine(1, "§bChicken");
						e.setLine(3, Config.getString("Mobs.Prices.Chicken"));
						break;
					case 94:
						e.setLine(1, "§bSquid");
						e.setLine(3, Config.getString("Mobs.Prices.Squid"));
						break;
					case 95:
						e.setLine(1, "§bWolf");
						e.setLine(3, Config.getString("Mobs.Prices.Wolf"));
						break;
					case 96:
						e.setLine(1, "§bMooshroom");
						e.setLine(3, Config.getString("Mobs.Prices.Mooshroom"));
						break;
					case 99:
						e.setLine(1, "§bIron Golem");
						e.setLine(3, Config.getString("Mobs.Prices.Iron-Golem"));
						break;
					case 120:
						e.setLine(1, "§bVillager");
						e.setLine(3, Config.getString("Mobs.Prices.Villager"));
						break;
					default:
						e.setLine(1, "§cNULL");
						e.setLine(2, "§cInvalid Mob");
						break;
					}
				}
			}else{
				e.getPlayer().sendMessage("You don't have permission to make a spawner shop sign!");
			}
		}
	}

	private void giveSpawner(Player p, int mob, String mobN){
		if (p.getInventory().firstEmpty() == -1) {
			p.sendMessage("You don't have a open slot!");
			return;
		}
		ItemStack spawner = new ItemStack(Material.MOB_SPAWNER, 1);
		ItemMeta spawnerMeta = spawner.getItemMeta();
		spawnerMeta.setDisplayName(mobN);
		spawner.setItemMeta(spawnerMeta);
		p.getInventory().addItem(spawner);
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		if(!(e.getAction() == Action.RIGHT_CLICK_BLOCK))return;
		if(e.getClickedBlock().getState() instanceof Sign){
			Player p = (Player) e.getPlayer();
			Sign s = (Sign) e.getClickedBlock().getState();
			if(s.getLine(0).equals("§1[Spawners]")){
				int price = Integer.parseInt(s.getLine(3));
				if(econ.getBalance(p) >= price){
					switch(s.getLine(1)){
					case "§bCreeper":
						giveSpawner(p, 50, s.getLine(1));
						break;
					case "§bWither Skel.":
						giveSpawner(p, 51, s.getLine(1));
						break;
					case "§bSpider":
						giveSpawner(p, 52, s.getLine(1));
						break;
					case "§bZombie":
						giveSpawner(p, 54, s.getLine(1));
						break;
					case "§bSlime":
						giveSpawner(p, 55, s.getLine(1));
						break;
					case "§bGhast":
						giveSpawner(p, 56, s.getLine(1));
						break;
					case "§bPig Zombie":
						giveSpawner(p, 57, s.getLine(1));
						break;
					case "§bEnderman":
						giveSpawner(p, 58, s.getLine(1));
						break;
					case "§bCave Spider":
						giveSpawner(p, 59, s.getLine(1));
						break;
					case "§bSilverfish":
						giveSpawner(p, 60, s.getLine(1));
						break;
					case "§bBlaze":
						giveSpawner(p, 61, s.getLine(1));
						break;
					case "§bMagma Cube":
						giveSpawner(p, 62, s.getLine(1));
						break;
					case "§bBat":
						giveSpawner(p, 65, s.getLine(1));
						break;
					case "§bWitch":
						giveSpawner(p, 66, s.getLine(1));
						break;
					case "§bGuardian":
						giveSpawner(p, 68, s.getLine(1));
						break;
					case "§bPig":
						giveSpawner(p, 90, s.getLine(1));
						break;
					case "§bSheep":
						giveSpawner(p, 91, s.getLine(1));
						break;
					case "§bCow":
						giveSpawner(p, 92, s.getLine(1));
						break;
					case "§bChicken":
						giveSpawner(p, 93, s.getLine(1));
						break;
					case "§bSquid":
						giveSpawner(p, 94, s.getLine(1));
						break;
					case "§bWolf":
						giveSpawner(p, 95, s.getLine(1));
						break;
					case "§bMooshroom":
						giveSpawner(p, 96, s.getLine(1));
						break;
					case "§bIron Golem":
						giveSpawner(p, 99, s.getLine(1));
						break;
					case "§bVillager":
						giveSpawner(p, 120, s.getLine(1));
						break;
					default:
						s.setLine(1, "§cNULL");
						s.setLine(2, "§cInvalid Mob");
						break;
					}
					econ.withdrawPlayer(p, price);
				}
				return;
			} else {
				return;
			}
		}
	}

}
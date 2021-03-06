package cc.thedudeguy.jukebukkit.materials.items;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.material.CustomItem;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.player.SpoutPlayer;

import cc.thedudeguy.jukebukkit.JukeBukkit;
import cc.thedudeguy.jukebukkit.events.SpeakerWirePlaceEvent;
import cc.thedudeguy.jukebukkit.util.Debug;

public class SpeakerWire extends GenericCustomItem {
	
	public SpeakerWire() {
		super(JukeBukkit.instance, "Speaker Wire");
		setTexture(new File(JukeBukkit.instance.getDataFolder(), new File("textures", "speakerwire.png").getPath()));
	}
	
	@Override
	public boolean onItemInteract(SpoutPlayer player, SpoutBlock block, org.bukkit.block.BlockFace face) {
		
		if (block != null && !block.getType().equals(Material.AIR) && face.equals(BlockFace.UP)) {
			
			SpoutBlock placeBlock = block.getRelative(face);
			if (placeBlock == null || placeBlock.getType().equals(Material.AIR)) {
				
				SpeakerWirePlaceEvent event = new SpeakerWirePlaceEvent(player, placeBlock);
				Bukkit.getServer().getPluginManager().callEvent(event);
				
				//remove 1 from hand.
				//if (!player.getGameMode().equals(GameMode.CREATIVE)) {
					Debug.debug(player, "Removing item from hand");
					ItemStack inHand = player.getItemInHand();
					if (inHand.getAmount()<2) {
						player.setItemInHand(new ItemStack(Material.AIR));
					} else {
						player.getItemInHand().setAmount(inHand.getAmount()-1);
					}
				//}
				
			}
			
		}
		return false;
	}
	
	public CustomItem setTexture(File texture) {
		this.texture = texture.getName();
		SpoutManager.getFileManager().addToCache(JukeBukkit.instance, texture);
		return this;
	}
	
}

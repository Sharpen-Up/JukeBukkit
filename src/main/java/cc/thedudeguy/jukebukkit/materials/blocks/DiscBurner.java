/**
 * Copyright (C) 2011  Chris Churchwell
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **/
package cc.thedudeguy.jukebukkit.materials.blocks;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.CustomItem;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

import cc.thedudeguy.jukebukkit.JukeBukkit;
import cc.thedudeguy.jukebukkit.gui.BurnSelector;
import cc.thedudeguy.jukebukkit.materials.Blocks;
import cc.thedudeguy.jukebukkit.materials.items.BlankDisc;


/**
 * The Prototype Disc Burner. Basic Custom Block in which I can expand with.
 * @author Chris Churchwell
 */
public class DiscBurner extends GenericCustomBlock {
	
	/**
	 * Construct
	 * @param JukeBukkit plugin - JukeBukkit instance
	 */
	public DiscBurner()
	{
		super(JukeBukkit.instance, "Disc Burner", 4);
		this.setRotate(true);
		this.setName("Disc Burner");
		this.setBlockDesign(new GenericCubeBlockDesign(JukeBukkit.instance, Blocks.blocksTexture, new int[] {2, 3, 3, 4, 3, 2}));
	}
	
	@Override
	public boolean onBlockInteract(World world, int x, int y, int z, SpoutPlayer player) {
		
		//plugin.log.info("onBlockInteract");
		
		Location location = new Location(world, (double)x, (double)y, (double)z);
		ItemStack inHand = player.getItemInHand();
		
		if (inHand != null && (new SpoutItemStack(inHand).isCustomItem()))
		{
			//checks if item in hand is white disc.
			CustomItem customInHand = (CustomItem)new SpoutItemStack(inHand).getMaterial();
			if (customInHand instanceof BlankDisc)
			{
				player.getMainScreen().attachPopupScreen(new BurnSelector(player, world.getBlockAt(x, y, z)));
				return true;
			}
		}
		
		SpoutManager.getSoundManager().playGlobalCustomSoundEffect(JukeBukkit.instance, "jb_error.wav", false, location, 8);
		return true;
	}
	
}

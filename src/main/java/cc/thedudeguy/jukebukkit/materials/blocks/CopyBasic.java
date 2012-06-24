package cc.thedudeguy.jukebukkit.materials.blocks;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;

import cc.thedudeguy.jukebukkit.JukeBukkit;
import cc.thedudeguy.jukebukkit.materials.Blocks;

public class CopyBasic extends JukeboxBlockCopy {
	
	public CopyBasic()
	{
		super("Basic CD-Copier Jukebox");
	}
	
	@Override
	public int getRange()
	{
		return 7;
	}
	
	@Override
	public String getPermission() {
		return "jukebukkit.player.copy";
	}
	
	@Override
	public boolean canRedstoneActivate() {
		return true;
	}

	@Override
	public GenericCubeBlockDesign getCustomBlockDesign() {
		
		return new GenericCubeBlockDesign(
				JukeBukkit.instance, 
				Blocks.blocksTexture, 
				new int[] { 0, 0, 0, 0, 0, 11 }
			);
	}
}

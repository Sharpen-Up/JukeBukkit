package cc.thedudeguy.jukebukkit.materials;

import org.getspout.spoutapi.block.design.Texture;

import cc.thedudeguy.jukebukkit.JukeBukkit;
import cc.thedudeguy.jukebukkit.materials.blocks.DiscBurner;
import cc.thedudeguy.jukebukkit.materials.blocks.JukeboxBasic;
import cc.thedudeguy.jukebukkit.materials.blocks.JukeboxLongRange;
import cc.thedudeguy.jukebukkit.materials.blocks.JukeboxLowRange;
import cc.thedudeguy.jukebukkit.materials.blocks.JukeboxMaxRange;
import cc.thedudeguy.jukebukkit.materials.blocks.JukeboxMidRange;
import cc.thedudeguy.jukebukkit.materials.blocks.JukeboxWorldRange;
import cc.thedudeguy.jukebukkit.materials.blocks.RecordPlayer;
import cc.thedudeguy.jukebukkit.materials.blocks.Speaker;
import cc.thedudeguy.jukebukkit.materials.blocks.SpeakerWireBlock;


public class Blocks {
	
	public static final Texture recordPlayerTexture = new Texture(JukeBukkit.instance, "recordplayer.png", 256, 256, 16);
	public static final Texture blocksTexture = new Texture(JukeBukkit.instance, "blocks_deprecated.png", 256, 256, 16);
	public static final Texture speakerwireTexture = new Texture(JukeBukkit.instance, "speakerwireblock.png", 256, 256, 16);
	
	public static RecordPlayer recordPlayer;
	public static JukeboxBasic jukeboxBasic;
	public static cc.thedudeguy.jukebukkit.materials.blocks.CopyBasic CopyBasic;
	public static JukeboxLowRange jukeboxLowRange;
	public static JukeboxMidRange jukeboxMidRange;
	public static JukeboxLongRange jukeboxLongRange;
	public static JukeboxMaxRange jukeboxMaxRange;
	public static JukeboxWorldRange jukeboxWorldRange;
	
	
	public static DiscBurner discBurner;
	
	
	public static Speaker speaker;
	
	public static SpeakerWireBlock speakerWireBlock;
	
	public Blocks() {
		
		recordPlayer = new RecordPlayer();
		
		discBurner = new DiscBurner();
		
		
		jukeboxBasic = new JukeboxBasic();
		CopyBasic = new cc.thedudeguy.jukebukkit.materials.blocks.CopyBasic();
		jukeboxLowRange = new JukeboxLowRange();
		jukeboxMidRange = new JukeboxMidRange();
		jukeboxLongRange = new JukeboxLongRange();
		jukeboxMaxRange = new JukeboxMaxRange();
		jukeboxWorldRange = new JukeboxWorldRange();
		
		speaker = new Speaker();
		
		speakerWireBlock = new SpeakerWireBlock();
	}
	
}

package cc.thedudeguy.jukebukkit.util;

import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.inventory.SpoutShapelessRecipe;
import org.getspout.spoutapi.material.MaterialData;

import cc.thedudeguy.jukebukkit.materials.Blocks;
import cc.thedudeguy.jukebukkit.materials.Items;

public class Recipies {
	
	public static void load() {
		
		//////////////////
		// Speaker Wire //
		//////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
		new SpoutShapedRecipe( new SpoutItemStack(Items.speakerWire, 3) )
			.shape("sss", "rrr")
			.setIngredient('s', MaterialData.string)
			.setIngredient('r', MaterialData.redstone)
			);
		
		//////////////////////////////
		// Wood-Flint Record Needle //
		//////////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapedRecipe( new SpoutItemStack(Items.woodflintNeedle, 1) )
			.shape("ttt", "sss", "  f")
			.setIngredient('t', Items.speakerWire)
			.setIngredient('s', MaterialData.stick)
			.setIngredient('f', MaterialData.flint)
			);
		
		//////////////////////////////
		// Blaze-Flint Record Needle //
		//////////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapedRecipe( new SpoutItemStack(Items.blazeflintNeedle, 1) )
			.shape("ttt", "sss", "  f")
			.setIngredient('t', Items.speakerWire)
			.setIngredient('s', MaterialData.blazeRod)
			.setIngredient('f', MaterialData.flint)
			);
		
		//////////////////////////
		// Badass Record Player //
		//////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapedRecipe( new SpoutItemStack(Blocks.recordPlayer, 1) )
			.shape("sps", "njn", "www")
			.setIngredient('s', MaterialData.woodenSlab)
			.setIngredient('p', MaterialData.stonePressurePlate)
			.setIngredient('n', Blocks.speaker)
			.setIngredient('j', MaterialData.jukebox)
			.setIngredient('w', MaterialData.wood)
			);
		
		//////////////////////
		// What? a speaker? //
		//////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapedRecipe( new SpoutItemStack(Blocks.speaker, 1) )
			.shape("www", "cnc", "www")
			.setIngredient('w', MaterialData.wood)
			.setIngredient('c', MaterialData.whiteWool)
			.setIngredient('n', MaterialData.noteblock)
			);
		
		///////////////////////
		// Basic Jukebox     //
		///////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapedRecipe( new SpoutItemStack(Blocks.jukeboxBasic, 1) )
			.shape("jn")
			.setIngredient('j', MaterialData.jukebox)
			.setIngredient('n', MaterialData.noteblock)
			);
		
		//////////////////////////////
		// Basic CD-Copier Jukebox  //
		//////////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapedRecipe( new SpoutItemStack(Blocks.CopyBasic, 1) )
			.shape("kkk","jnj","kkk")
			.setIngredient('j', Blocks.jukeboxBasic)
			.setIngredient('n', Blocks.discBurner)
			.setIngredient('k', MaterialData.noteblock)
			);
		
		///////////////////////
		// Low Range Jukebox //
		///////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapedRecipe( new SpoutItemStack(Blocks.jukeboxLowRange, 1) )
			.shape("www", "wjw", "www")
			.setIngredient('j', Blocks.jukeboxBasic)
			.setIngredient('w', MaterialData.wood)
			);

		///////////////////////
		// Mid Range Jukebox //
		///////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
				new SpoutShapedRecipe( new SpoutItemStack(Blocks.jukeboxMidRange, 1) )
			.shape("www", "njn", "www")
			.setIngredient('j', Blocks.jukeboxLowRange)
			.setIngredient('w', MaterialData.wood)
			.setIngredient('n', MaterialData.noteblock)
			);

		///////////////////////
		// Long Range Jukebox //
		///////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapedRecipe( new SpoutItemStack(Blocks.jukeboxLongRange, 1) )
			.shape("wnw", "njn", "wnw")
			.setIngredient('j', Blocks.jukeboxMidRange)
			.setIngredient('w', MaterialData.wood)
			.setIngredient('n', MaterialData.noteblock)
			);

		///////////////////////
		// Max Range Jukebox //
		///////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapedRecipe( new SpoutItemStack(Blocks.jukeboxMaxRange, 1) )
			.shape("nnn", "njn", "nnn")
			.setIngredient('j', Blocks.jukeboxLongRange)
			.setIngredient('n', MaterialData.noteblock)
			);
		
		///////////////////////
		// World Range Jukebox //
		///////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapedRecipe( new SpoutItemStack(Blocks.jukeboxWorldRange, 1) )
			.shape("njn", "jdj", "njn")
			.setIngredient('j', Blocks.jukeboxMaxRange)
			.setIngredient('n', MaterialData.noteblock)
			.setIngredient('d', MaterialData.diamondBlock)
			);
		
		//////////////////////
		// Disc Burner //
		//////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapedRecipe( new SpoutItemStack(Blocks.discBurner, 1) )
			.shape("jf")
			.setIngredient('j', MaterialData.jukebox)
			.setIngredient('f', MaterialData.furnace)
			);
		
		/////////////////////
		// Blank Obsidyisc //
		/////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapedRecipe( new SpoutItemStack(Items.blankDiscWhite, 1) )
			.shape(" o ", "oRo", " o ")
			.setIngredient('o', MaterialData.obsidian)
			.setIngredient('R', MaterialData.redstone)
			);
		
		///////////////////////////
		// Black Blank Obsidyisc //
		///////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack(Items.blankDiscBlack, 1) )
			.addIngredient(MaterialData.inkSac)
			.addIngredient(Items.blankDiscWhite)
			);
		
		/////////////////////////
		// Red Blank Obsidyisc //
		/////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscRed, 1) )
			.addIngredient(MaterialData.roseRed)
			.addIngredient(Items.blankDiscWhite)
			);
		
		///////////////////////////
		// Green Blank Obsidyisc //
		///////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscGreen, 1) )
			.addIngredient(MaterialData.cactusGreen)
			.addIngredient(Items.blankDiscWhite)
			);
		
		/////////////////////////
		// Brown Blank Obsidyisc //
		/////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscBrown, 1) )
			.addIngredient(MaterialData.cocoaBeans)
			.addIngredient(Items.blankDiscWhite)
			);
		
		//////////////////////////
		// Blue Blank Obsidyisc //
		//////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscBlue, 1) )
			.addIngredient(MaterialData.lapisLazuli)
			.addIngredient(Items.blankDiscWhite)
			);
		
		////////////////////////////
		// Purple Blank Obsidyisc //
		////////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscPurple, 1) )
			.addIngredient(MaterialData.purpleDye)
			.addIngredient(Items.blankDiscWhite)
			);
		
		//////////////////////////
		// Cyan Blank Obsidyisc //
		//////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscCyan, 1) )
			.addIngredient(MaterialData.cyanDye)
			.addIngredient(Items.blankDiscWhite)
			);
		
		////////////////////////////////
		// Light Gray Blank Obsidyisc //
		////////////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscLightGray, 1) )
			.addIngredient(MaterialData.lightGrayDye)
			.addIngredient(Items.blankDiscWhite)
			);
		
		//////////////////////////
		// Gray Blank Obsidyisc //
		//////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscGray, 1) )
			.addIngredient(MaterialData.grayDye)
			.addIngredient(Items.blankDiscWhite)
			);
		
		//////////////////////////
		// Pink Blank Obsidyisc //
		//////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscPink, 1) )
			.addIngredient(MaterialData.pinkDye)
			.addIngredient(Items.blankDiscWhite)
			);
		
		//////////////////////////
		// Lime Blank Obsidyisc //
		//////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscLime, 1) )
			.addIngredient(MaterialData.limeDye)
			.addIngredient(Items.blankDiscWhite)
			);
		
		////////////////////////////
		// Yellow Blank Obsidyisc //
		////////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscYellow, 1) )
			.addIngredient(MaterialData.dandelionYellow)
			.addIngredient(Items.blankDiscWhite)
			);
		
		////////////////////////////////
		// Light Blue Blank Obsidyisc //
		////////////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscLightBlue, 1) )
			.addIngredient(MaterialData.lightBlueDye)
			.addIngredient(Items.blankDiscWhite)
			);
		
		/////////////////////////////
		// Magenta Blank Obsidyisc //
		/////////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscMagenta, 1) )
			.addIngredient(MaterialData.magentaDye)
			.addIngredient(Items.blankDiscWhite)
			);
		
		////////////////////////////
		// Orange Blank Obsidyisc //
		////////////////////////////
		SpoutManager.getMaterialManager().registerSpoutRecipe(
			new SpoutShapelessRecipe( new SpoutItemStack( Items.blankDiscOrange, 1) )
			.addIngredient(MaterialData.orangeDye)
			.addIngredient(Items.blankDiscWhite)
			);
	}
	
}

package com.therifty.necessaryadditions.core.init;

import com.therifty.necessaryadditions.NecessaryAdditions;
import com.therifty.necessaryadditions.common.block.DisplayCaseBlock;
import com.therifty.necessaryadditions.common.block.QuarryBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			NecessaryAdditions.MOD_ID);

	public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS
			.register("example_block",
					() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
							.hardnessAndResistance(3f, 3f).harvestTool(ToolType.PICKAXE).harvestLevel(1)
							.sound(SoundType.METAL).setRequiresTool()));
	
	public static final RegistryObject<Block> GILDED_REDSTONE_ORE = BLOCKS
			.register("gilded_redstone_ore",
					() -> new Block(AbstractBlock.Properties.from(Blocks.REDSTONE_ORE))); 

	
	
	public static final RegistryObject<Block> QUARRY = BLOCKS.register("quarry", () -> new QuarryBlock());
	public static final RegistryObject<Block> DISPLAY_CASE = BLOCKS.register("display_case", () -> new DisplayCaseBlock());

}

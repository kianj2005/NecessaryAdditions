package com.therifty.necessaryadditions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.therifty.necessaryadditions.core.init.BlockInit;
import com.therifty.necessaryadditions.core.init.FeatureInit;
import com.therifty.necessaryadditions.core.init.ItemInit;
import com.therifty.necessaryadditions.core.init.TileEntityTypesInit;
import com.therifty.necessaryadditions.core.itemgroup.NecessaryAdditionsItemGroup;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("necessaryadditions")
@Mod.EventBusSubscriber(modid = NecessaryAdditions.MOD_ID, bus = Bus.MOD)
public class NecessaryAdditions {

	// Directly reference a log4j logger.
	private static final Logger LOGGER = LogManager.getLogger();

	public static final String MOD_ID = "necessaryadditions";

	public NecessaryAdditions() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		BlockInit.BLOCKS.register(bus);
		TileEntityTypesInit.TILE_ENTITY_TYPE.register(bus);
		ItemInit.ITEMS.register(bus);
		
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FeatureInit::addOres);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {

		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			event.getRegistry().register(new BlockItem(block, new Item.Properties().group(NecessaryAdditionsItemGroup.NECESSARY_ADDITIONS))
					.setRegistryName(block.getRegistryName()));
		});
	}

}

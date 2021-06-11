package com.therifty.necessaryadditions.core.init;

import com.therifty.necessaryadditions.NecessaryAdditions;
import com.therifty.necessaryadditions.core.itemgroup.NecessaryAdditionsItemGroup;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			NecessaryAdditions.MOD_ID);

	public static final RegistryObject<Item> GILDED_REDSTONE = ITEMS.register("gilded_redstone",
			() -> new Item(new Item.Properties().group(NecessaryAdditionsItemGroup.NECESSARY_ADDITIONS)));
	
	public static final RegistryObject<Item> GILDED_REDSTONE_SWORD = ITEMS.register("gilded_redstone_sword",
			() -> new Item(new Item.Properties().group(NecessaryAdditionsItemGroup.NECESSARY_ADDITIONS)));

}

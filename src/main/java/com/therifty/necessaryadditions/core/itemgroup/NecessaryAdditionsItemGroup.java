package com.therifty.necessaryadditions.core.itemgroup;

import com.therifty.necessaryadditions.core.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class NecessaryAdditionsItemGroup extends ItemGroup {

	public static final NecessaryAdditionsItemGroup NECESSARY_ADDITIONS = new NecessaryAdditionsItemGroup(
			ItemGroup.GROUPS.length, "necessary_additions");

	public NecessaryAdditionsItemGroup(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemInit.GILDED_REDSTONE.get());
	}

}

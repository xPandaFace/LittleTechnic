package com.xpandaface.littletechnic;

import com.xpandaface.littletechnic.lists.BlockList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class LittleItemGroup extends ItemGroup {

	public LittleItemGroup() {
		super("LittleTab");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(Item.BLOCK_TO_ITEM.get(BlockList.basic_machine_frame));
	}

}

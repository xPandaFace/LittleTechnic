package com.xpandaface.littletechnic.items;

import com.xpandaface.littletechnic.LittleTechnic;

import net.minecraft.item.Item;

public class LittleWrench  extends Item {

	public LittleWrench () {
		super(new Item.Properties()
				.group(LittleTechnic.setup.ItemGroup)
				.maxStackSize(1));
		

		setRegistryName("little_wrench");
	}
	
}

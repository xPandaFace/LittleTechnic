package com.xpandaface.littletechnic.setup;

import com.xpandaface.littletechnic.blocks.ModBlocks;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {
	
	public ItemGroup ItemGroup = new ItemGroup("little_technic") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.GRINDER);
		
		}
	};
	
	public void init() {
		
		
	}
}

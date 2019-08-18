package com.xpandaface.littletechnic.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Grinder extends Block {

	public Grinder(){
		super(Properties.create(Material.IRON)
				.sound(SoundType.METAL)
				.hardnessAndResistance(2.0f)
				.lightValue(14)
				);
		setRegistryName("grinder");
		// TODO Auto-generated constructor stub
	}

}

package com.xpandaface.littletechnic.blocks;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {
	@ObjectHolder("littletechnic:grinder")
	public static Grinder GRINDER;
	
	@ObjectHolder("littletechnic:generator")
	public static Generator GENERATOR;
	@ObjectHolder("littletechnic:generator")
	public static TileEntityType<GeneratorTile> GENERATOR_TILE;
	@ObjectHolder("littletechnic:generator")
	public static ContainerType<GeneratorContainer> GENERATOR_CONTAINER;
}

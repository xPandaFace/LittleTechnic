package com.xpandaface.littletechnic.setup;

import com.xpandaface.littletechnic.blocks.GeneratorScreen;
import com.xpandaface.littletechnic.blocks.ModBlocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy{

	@Override
	public void init() { 
		ScreenManager.registerFactory(ModBlocks.GENERATOR_CONTAINER, GeneratorScreen::new);
	}
	
	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().world;

	}
	@Override
	public PlayerEntity getClientPlayer() { 
		return Minecraft.getInstance().player; 
	}
}

package com.xpandaface.littletechnic.blocks;

import com.mojang.blaze3d.platform.GlStateManager;
import com.xpandaface.littletechnic.LittleTechnic;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class GeneratorScreen extends ContainerScreen<GeneratorContainer> {
	
	private ResourceLocation GUI = new ResourceLocation(LittleTechnic.MODID, "textures/gui/generator_gui.png");

	public GeneratorScreen(GeneratorContainer container, PlayerInventory inv, ITextComponent name) {
		super(container, inv, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		this.renderBackground();
		super.render(mouseX, mouseY, partialTicks);
		super.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.font.drawString(this.title.getFormattedText(), 8.0F, 6.0F, 4210752);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 96 + 2), 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		renderBackground();
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(GUI);
		int relX = (this.width - this.xSize) / 2;
		int relY = (this.height - this.ySize) /2;
		this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
		
	}

}

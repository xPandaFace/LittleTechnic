package com.xpandaface.littletechnic.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList  implements IItemTier{

	little_wrench(1.0f, 1.0f, 100, 0, 0, ItemList.dirty_iron_dust); //,
	
	private float attackDamage, effeciency;
	private int durability, harvestlevel, enchantability;
	private Item repairMaterial;
	
	private ToolMaterialList(float attackDamage, float effeciency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
		
		this.attackDamage = attackDamage;
		this.effeciency = effeciency;
		this.durability = durability;
		this.harvestlevel = harvestlevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
		
		
	}

	@Override
	public int getMaxUses() {
		return this.durability;
	}

	@Override
	public float getEfficiency() {
		return this.effeciency = effeciency;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage = attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		return this.harvestlevel = harvestlevel;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability = enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(this.repairMaterial);
	}

}

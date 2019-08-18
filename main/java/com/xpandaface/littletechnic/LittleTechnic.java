package com.xpandaface.littletechnic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.xpandaface.littletechnic.blocks.Generator;
import com.xpandaface.littletechnic.blocks.GeneratorContainer;
import com.xpandaface.littletechnic.blocks.GeneratorTile;
import com.xpandaface.littletechnic.blocks.Grinder;
import com.xpandaface.littletechnic.blocks.ModBlocks;
import com.xpandaface.littletechnic.items.LittleWrench;
import com.xpandaface.littletechnic.lists.BlockList;
import com.xpandaface.littletechnic.lists.ItemList;
import com.xpandaface.littletechnic.setup.ClientProxy;
import com.xpandaface.littletechnic.setup.IProxy;
import com.xpandaface.littletechnic.setup.ModSetup;
import com.xpandaface.littletechnic.setup.ServerProxy;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("littletechnic")
public class LittleTechnic
{
	
	public static LittleTechnic instance;
	public static final String MODID = "littletechnic";
	private static final Logger logger = LogManager.getLogger(MODID);
	
	public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
	
	public static ModSetup setup = new ModSetup();
	
    public LittleTechnic() {
    	
    	instance = this;
    	
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
    	
    	MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {	
    	setup.init();
    	proxy.init();
        logger.info("Setup method registerd");
    }
    
    private void clientRegistries(final FMLClientSetupEvent event) {
    	logger.info("clientRegistries method registerd");
    }
    
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
    	//""""""""""""""""""OnBlockRegestry"""""""""""""""""""""""""""""TUTORIAL2
    	@SubscribeEvent
    	public static void onBlockRegistry(final RegistryEvent.Register<Block> event) {
    		event.getRegistry().register(new Grinder());
    		event.getRegistry().register(new Generator());
    	}
    	//""""""""""""""""""OnItemRegestry""""""""""""""""""""""""""""" 
    	@SubscribeEvent
    	public static void OnItemRegistry(final RegistryEvent.Register<Item> event) {
    		event.getRegistry().register(new BlockItem(ModBlocks.GRINDER, new Item.Properties().group(setup.ItemGroup)).setRegistryName("grinder"));
    		event.getRegistry().register(new BlockItem(ModBlocks.GENERATOR, new Item.Properties().group(setup.ItemGroup)).setRegistryName("generator"));
    		event.getRegistry().register(new LittleWrench());
    	}
    	//""""""""""""""""""""""""""END"""""""""""""""""""""""""""""TUTORIAL2
    	//""""""""""""""""""OnItemRegestry"""""""""""""""""""""""""""""
    	@SubscribeEvent
    	public static void registerItems(final RegistryEvent.Register<Item> event) {
    		
    		event.getRegistry().registerAll(
    		//dusts
    		ItemList.dirty_iron_dust = new Item(new Item.Properties().group(setup.ItemGroup)).setRegistryName(location("dirty_iron_dust")),
    		//ingots
    		ItemList.harderned_iron_ingot = new Item(new Item.Properties().group(setup.ItemGroup)).setRegistryName(location("harderned_iron_ingot")),
    		//blocks
    		ItemList.basic_machine_frame = new BlockItem(BlockList.basic_machine_frame, new Item.Properties().group(setup.ItemGroup)).setRegistryName(BlockList.basic_machine_frame.getRegistryName())
    		);
    		
    		logger.info("Items Loaded");
    	}
    	
    	
    	//""""""""""""""""""OnBlockRegestry"""""""""""""""""""""""""""""TUTORIAL1
    	@SubscribeEvent
    	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
    		
    		event.getRegistry().registerAll(
     
    		BlockList.basic_machine_frame = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName("basic_machine_frame")
    		);
    		
    		logger.info("Block Loaded");
    	}

    	//""""""""""""""""""""""""""END"""""""""""""""""""""""""""""TUTORIAL1
    	@SubscribeEvent
    	public static void onTileRegistryEvent(final RegistryEvent.Register<TileEntityType<?>> event) {
    		event.getRegistry().register(TileEntityType.Builder.create(GeneratorTile::new, ModBlocks.GENERATOR).build(null).setRegistryName("generator"));
    	}
    	private static ResourceLocation location(String name) {
    		return new ResourceLocation(MODID, name);
    	}
    	
    	public static void onContainerRegestry(final RegistryEvent.Register<ContainerType<?>> event) {
    		event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
    			BlockPos pos = data.readBlockPos();
    			return new GeneratorContainer(windowId, LittleTechnic.proxy.getClientWorld(), pos, inv, LittleTechnic.proxy.getClientPlayer());
    		}).setRegistryName("generator"));
    	}
    }
}

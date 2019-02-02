package net.brusselsprout.sotw;

import com.google.common.graph.Network;
import net.brusselsprout.sotw.block.ModBlocks;
import net.brusselsprout.sotw.client.SOTWCreativeTab;
import net.brusselsprout.sotw.gui.ModGuiHandler;
import net.brusselsprout.sotw.item.ModItems;
import net.brusselsprout.sotw.network.PRUStarbucksShop;
import net.brusselsprout.sotw.network.PUStarbucksShop;
import net.brusselsprout.sotw.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = SproutOTW.MODID, name = SproutOTW.NAME, version = SproutOTW.VERSION)
public class SproutOTW {

    public static final String MODID = "sotw";
    public static final String NAME = "Sprouts of the Wild";
    public static final String VERSION = "0.0.1";

    //TODO- add ore worldgen, starbucks card functionality
    //TODO- chai latte, lemon muffin, starbucks card, starbucks store

    @Mod.Instance
    public static SproutOTW instance;

    @SidedProxy(serverSide = "net.brusselsprout.sotw.proxy.CommonProxy", clientSide = "net.brusselsprout.sotw.proxy.ClientProxy")
    public static CommonProxy proxy;

    public static SimpleNetworkWrapper network;

    // Mod Feature Instances
    public static SOTWCreativeTab creativeTab = new SOTWCreativeTab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGuiHandler());
        proxy.registerRenderers();

        network = NetworkRegistry.INSTANCE.newSimpleChannel(SproutOTW.MODID);
        network.registerMessage(new PUStarbucksShop.Handler(), PUStarbucksShop.class, 0, Side.CLIENT);
        network.registerMessage(new PRUStarbucksShop.Handler(), PRUStarbucksShop.class, 1, Side.SERVER);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModBlocks.registerItemBlocks(event.getRegistry());
            ModItems.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ModBlocks.registerModels();
            ModItems.registerModels();
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }
    }

}

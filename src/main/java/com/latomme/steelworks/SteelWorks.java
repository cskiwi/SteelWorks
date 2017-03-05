package com.latomme.steelworks;

import com.latomme.steelworks.init.ModBlocks;
import com.latomme.steelworks.init.ModCrafting;
import com.latomme.steelworks.init.ModItems;
import com.latomme.steelworks.proxy.CommonProxy;
import com.latomme.steelworks.tileentity.TileEntityJar;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Glenn Latomme on 3/3/2017.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class SteelWorks {

    @Mod.Instance
    public static SteelWorks instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final CreativeTabs TAB_SW = new SteelWorksTab();


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Pre init");

        ModItems.init();
        ModItems.register();

        ModBlocks.init();
        ModBlocks.register();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Init");
        proxy.init();

        ModCrafting.register();

        GameRegistry.registerTileEntity(TileEntityJar.class, Reference.MOD_ID + "TileEntityJar");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("Post init");

    }
}

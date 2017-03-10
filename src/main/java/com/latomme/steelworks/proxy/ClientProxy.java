package com.latomme.steelworks.proxy;

import com.latomme.steelworks.init.ModBlocks;
import com.latomme.steelworks.init.ModFluids;
import com.latomme.steelworks.init.ModItems;
import com.latomme.steelworks.tileentity.TileEntityJar;
import com.latomme.steelworks.tileentity.render.RendererJar;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;

/**
 * Created by Glenn Latomme on 3/3/2017.
 */
public class ClientProxy implements CommonProxy {

    @Override
    public void preInit() {
        ModFluids.registerRenders();
    }

    @Override
    public void init() {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
        ModFluids.registerRenders();

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJar.class, new RendererJar());
    }

}

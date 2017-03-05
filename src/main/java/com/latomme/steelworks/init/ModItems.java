package com.latomme.steelworks.init;

import com.latomme.steelworks.Reference;
import com.latomme.steelworks.items.ItemCheese;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.MinecraftDummyContainer;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Glenn Latomme on 3/3/2017.
 */
public class ModItems {
    public static Item cheese;

    public static void init() {
        cheese = new ItemCheese();
    }

    public static void register() {
        GameRegistry.register(cheese);
    }

    public static void registerRenders() {
        registerRender(cheese);
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}

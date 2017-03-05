package com.latomme.steelworks.init;

import com.latomme.steelworks.Reference;
import com.latomme.steelworks.items.ItemCheese;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.MinecraftDummyContainer;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glenn Latomme on 3/3/2017.
 */
public class ModItems {
    private static List<Item> items = new ArrayList<>();
    public static ItemCheese itemCheese;

    public static void init() {
        items.add(itemCheese = new ItemCheese());
    }

    public static void register() {
        items.forEach(GameRegistry::register);
    }

    public static void registerRenders() {
        items.forEach(ModItems::registerRender);
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}

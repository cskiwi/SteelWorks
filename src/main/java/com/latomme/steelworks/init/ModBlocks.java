package com.latomme.steelworks.init;

import com.latomme.steelworks.Reference;
import com.latomme.steelworks.blocks.BlockCheese;
import com.latomme.steelworks.blocks.BlockFluidSteel;
import com.latomme.steelworks.blocks.BlockJar;
import com.latomme.steelworks.items.ItemCheese;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glenn Latomme on 3/5/2017.
 */
public class ModBlocks {
    private static List<Block> blocks = new ArrayList<>();

    public static BlockCheese blockCheese;
    public static BlockJar blockJar;
    public static BlockFluidSteel blockFluidSteel;

    public ModBlocks() {
    }

    public static void init() {
        blocks.add(blockCheese = new BlockCheese());
        blocks.add(blockJar = new BlockJar());
        blocks.add(blockFluidSteel = new BlockFluidSteel());
    }

    public static void register() {
        blocks.forEach(ModBlocks::registerBlock);
    }

    private static void registerBlock(Block block) {
        GameRegistry.register(block);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        GameRegistry.register(item);
    }

    public static void registerRenders() {
        blocks.forEach(ModBlocks::registerRender);
    }

    private static void registerRender(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }
}

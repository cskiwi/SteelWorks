package com.latomme.steelworks.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Glenn Latomme on 3/5/2017.
 */
public class ModCrafting {

    public static void register() {
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockCheese), "CCC", "CCC", "CCC", 'C', ModItems.itemCheese);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockJar), " C ", "GGG", "CCC", 'C', Blocks.COAL_BLOCK, 'G', new ItemStack(Blocks.STAINED_GLASS, 1, 0));
    }
}

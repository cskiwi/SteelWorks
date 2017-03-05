package com.latomme.steelworks.blocks;

import com.latomme.steelworks.Reference;
import com.latomme.steelworks.SteelWorks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Glenn Latomme on 3/5/2017.
 */
public class BlockCheese extends Block {
    public BlockCheese() {
        super(Material.CAKE);
        setUnlocalizedName(Reference.SteelWorksBlocks.CHEESE.getUnlocalizedName());
        setRegistryName(Reference.SteelWorksBlocks.CHEESE.getRegisteryName());
        setCreativeTab(SteelWorks.TAB_SW);

        setHardness(1.0f);
    }
}

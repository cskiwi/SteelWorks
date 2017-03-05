package com.latomme.steelworks.items;

import com.latomme.steelworks.Reference;
import com.latomme.steelworks.SteelWorks;
import net.minecraft.item.Item;

/**
 * Created by Glenn Latomme on 3/3/2017.
 */
public class ItemCheese extends Item {
    public ItemCheese() {
        setUnlocalizedName(Reference.SteelWorksItems.CHEESE.getUnlocalizedName());
        setRegistryName(Reference.SteelWorksItems.CHEESE.getRegisteryName());
        setCreativeTab(SteelWorks.TAB_SW);
    }
}

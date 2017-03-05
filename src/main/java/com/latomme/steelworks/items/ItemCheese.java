package com.latomme.steelworks.items;

import com.latomme.steelworks.Reference;
import com.latomme.steelworks.SteelWorks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

/**
 * Created by Glenn Latomme on 3/3/2017.
 */
public class ItemCheese extends ItemFood {
    public ItemCheese() {
        super(4, 0.3f, false);
        setUnlocalizedName(Reference.SteelWorksItems.CHEESE.getUnlocalizedName());
        setRegistryName(Reference.SteelWorksItems.CHEESE.getRegisteryName());
        setCreativeTab(SteelWorks.TAB_SW);
    }
}

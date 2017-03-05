package com.latomme.steelworks;

import com.latomme.steelworks.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * Created by Glenn Latomme on 3/5/2017.
 */
public class TabSteelWorks extends CreativeTabs
{
    public TabSteelWorks()
    {
        super("SteelWorks");
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModItems.cheese);
    }
}

package com.latomme.steelworks.init;

import com.latomme.steelworks.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Glenn Latomme on 3/5/2017.
 */
public class ModTab extends CreativeTabs
{
    public ModTab()
    {
        super("tabSteelWorks");
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModItems.itemCheese);
    }
}

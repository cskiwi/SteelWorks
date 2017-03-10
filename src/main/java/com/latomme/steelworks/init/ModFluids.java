package com.latomme.steelworks.init;

import com.latomme.steelworks.Reference;
import com.latomme.steelworks.blocks.BlockFluidSteel;
import com.latomme.steelworks.fluids.FluidSteel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glenn Latomme on 3/9/2017.
 */
public class ModFluids {

    private static List<Fluid> items = new ArrayList<>();
    public static FluidSteel fluidSteel;


    public static void init() {
        items.add(fluidSteel = new FluidSteel());
    }

    public static void register() {

        items.forEach(FluidRegistry::registerFluid);
    }

    public static void registerRenders() {
        items.forEach(FluidRegistry::addBucketForFluid);
        items.forEach(ModFluids::registerRender);
    }

    private static void registerRender(Fluid item) {
        Item i = Item.getItemFromBlock(item.getBlock());
        String loc = Reference.MOD_ID + ":" + item.getName();

        ModelLoader.setCustomMeshDefinition(i, stack -> new ModelResourceLocation(loc, "fluid"));
        ModelLoader.setCustomStateMapper(item.getBlock(), new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return new ModelResourceLocation(loc, "fluid");
            }
        });
    }

}

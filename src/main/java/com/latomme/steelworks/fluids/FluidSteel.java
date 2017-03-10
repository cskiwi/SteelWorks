package com.latomme.steelworks.fluids;

import com.latomme.steelworks.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by Glenn Latomme on 3/9/2017.
 */
public class FluidSteel extends Fluid {
    public FluidSteel() {
        super(Reference.SteelWorksBlocks.STEEL.getRegisteryName(),
                new ResourceLocation(Reference.MOD_ID + ":" + "blocks/" + Reference.SteelWorksBlocks.STEEL.getRegisteryName() + "_still"),
                new ResourceLocation(Reference.MOD_ID + ":" + "blocks/" + Reference.SteelWorksBlocks.STEEL.getRegisteryName() + "_flow")
        );
        // this.setViscosity(10000);
    }
}


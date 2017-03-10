package com.latomme.steelworks.blocks;

import com.latomme.steelworks.Reference;
import com.latomme.steelworks.SteelWorks;
import com.latomme.steelworks.init.ModFluids;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

/**
 * Created by Glenn Latomme on 3/9/2017.
 */
public class BlockFluidSteel extends BlockFluidClassic {
    public BlockFluidSteel() {
        super(ModFluids.fluidSteel, Material.LAVA);
        setUnlocalizedName(Reference.SteelWorksBlocks.STEEL.getUnlocalizedName());
        setRegistryName(Reference.SteelWorksBlocks.STEEL.getRegisteryName());
        setCreativeTab(SteelWorks.TAB_SW);
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (entityIn instanceof EntityLivingBase) {

        }
    }
}

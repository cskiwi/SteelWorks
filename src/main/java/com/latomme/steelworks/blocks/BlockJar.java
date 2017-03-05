package com.latomme.steelworks.blocks;

import com.latomme.steelworks.Reference;
import com.latomme.steelworks.SteelWorks;
import com.latomme.steelworks.init.ModItems;
import com.latomme.steelworks.tileentity.TileEntityJar;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Glenn Latomme on 3/5/2017.
 */
public class BlockJar extends Block implements ITileEntityProvider {
    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(
            Reference.PIXEL_DISTANCE * 3,
            0,
            Reference.PIXEL_DISTANCE * 3,

            Reference.PIXEL_DISTANCE * 13,
            Reference.PIXEL_DISTANCE * 13,
            Reference.PIXEL_DISTANCE * 13
    );
    private static final AxisAlignedBB COLLISION_BOX = new AxisAlignedBB(
            Reference.PIXEL_DISTANCE * 4,
            0,
            Reference.PIXEL_DISTANCE * 4,

            Reference.PIXEL_DISTANCE * 12,
            Reference.PIXEL_DISTANCE * 12,
            Reference.PIXEL_DISTANCE * 12
    );

    public BlockJar() {
        super(Material.GLASS);
        setUnlocalizedName(Reference.SteelWorksBlocks.JAR.getUnlocalizedName());
        setRegistryName(Reference.SteelWorksBlocks.JAR.getRegisteryName());
        setCreativeTab(SteelWorks.TAB_SW);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDING_BOX;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_) {
        super.addCollisionBoxToList(pos, entityBox, collidingBoxes, COLLISION_BOX);
    }


    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof TileEntityJar) {
                TileEntityJar jar = (TileEntityJar) tileEntity;
                ItemStack heldStack = playerIn.getHeldItem(hand);
                if (heldStack.getItem() == ModItems.itemCheese) {
                    if (jar.addCheese()) {
                        heldStack.shrink(1);
                        return true;
                    }
                }
                jar.removeCracker();
            }
        }
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityJar();
    }
}

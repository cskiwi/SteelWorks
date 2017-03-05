package com.latomme.steelworks.tileentity;

import com.latomme.steelworks.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nullable;

/**
 * Created by Glenn Latomme on 3/5/2017.
 */
public class TileEntityJar extends TileEntity {
    public int cheeseCount = 0;
    private static final int cheeseMaxCount = 10;

    public boolean addCheese() {
        if (!world.isRemote) {
            if (cheeseCount < cheeseMaxCount) {
                cheeseCount++;
                markDirty();
                IBlockState state = world.getBlockState(pos);
                world.notifyBlockUpdate(pos, state, state, 3);
                return true;
            }
        }
        return false;
    }

    public void removeCracker() {
        if (!world.isRemote) {
            if (cheeseCount > 0) {
                EntityItem ent = new EntityItem(world);
                ent.setPosition(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
                ent.setEntityItemStack(new ItemStack(ModItems.itemCheese));
                world.spawnEntity(ent);
                cheeseCount--;
                markDirty();
                IBlockState state = world.getBlockState(pos);
                world.notifyBlockUpdate(pos, state, state, 3);
            }
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("CheeseCount", cheeseCount);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        cheeseCount = compound.getInteger("CheeseCount");
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        NBTTagCompound tag = pkt.getNbtCompound();
        readUpdateTag(tag);
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeUpdateTag(tag);
        return new SPacketUpdateTileEntity(pos, getBlockMetadata(), tag);
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound tag = super.getUpdateTag();
        writeUpdateTag(tag);
        return tag;
    }

    private void writeUpdateTag(NBTTagCompound tag) {
        tag.setInteger("CheeseCount", cheeseCount);
    }

    private void readUpdateTag(NBTTagCompound tag) {
        cheeseCount = tag.getInteger("CheeseCount");
    }
}

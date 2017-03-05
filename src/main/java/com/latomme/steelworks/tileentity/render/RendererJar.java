package com.latomme.steelworks.tileentity.render;

import com.latomme.steelworks.Reference;
import com.latomme.steelworks.init.ModItems;
import com.latomme.steelworks.tileentity.TileEntityJar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

/**
 * Created by Glenn Latomme on 3/5/2017.
 */
public class RendererJar extends TileEntitySpecialRenderer<TileEntityJar> {
    private static final EntityItem ITEM = new EntityItem(Minecraft.getMinecraft().world, 0, 0, 0, new ItemStack(ModItems.itemCheese));

    @Override
    public void renderTileEntityAt(TileEntityJar te, double x, double y, double z, float partialTicks, int destroyStage) {
        super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);

        ITEM.hoverStart = 0f;
        GlStateManager.pushMatrix();

        {
            GlStateManager.translate(x, y, z);
            GlStateManager.rotate(90f, 1, 0, 0);
            GlStateManager.translate(0.5, 0.05, -0.1);
            for (int i = 0; i < te.cheeseCount; i++) {
                Minecraft.getMinecraft().getRenderManager().doRenderEntity(ITEM, 0, 0, 0, 0f, 0f, false);
                GlStateManager.translate(0, 0, -Reference.PIXEL_DISTANCE);
            }
        }

        GlStateManager.popMatrix();
    }
}

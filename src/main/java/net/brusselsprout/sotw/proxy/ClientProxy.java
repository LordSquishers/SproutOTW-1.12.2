package net.brusselsprout.sotw.proxy;

import net.brusselsprout.sotw.SproutOTW;
import net.brusselsprout.sotw.blocks.BlockLeavesBanana;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(SproutOTW.MODID + ":" + id, "inventory"));
    }

    @Override
    public String localize(String unlocalized, Object... args) {
        return I18n.format(unlocalized, args);
    }

    @Override
    public void registerRenderers() {

    }

    public void setGraphicsLevel(BlockLeavesBanana blockIn, boolean isFancy) {
        blockIn.setGraphicsLevel(isFancy);
    }

}

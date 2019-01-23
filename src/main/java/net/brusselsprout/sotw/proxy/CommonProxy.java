package net.brusselsprout.sotw.proxy;

import net.brusselsprout.sotw.blocks.BlockLeavesBanana;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.item.Item;

public class CommonProxy {

    public void registerItemRenderer(Item item, int meta, String id) {

    }

    public String localize(String unlocalized, Object... args) {
        return I18n.translateToLocalFormatted(unlocalized, args);
    }

    public void registerRenderers() {

    }

    public void setGraphicsLevel(BlockLeavesBanana blockIn, boolean isFancy) {}

}

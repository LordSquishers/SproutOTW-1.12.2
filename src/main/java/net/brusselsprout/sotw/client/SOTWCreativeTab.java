package net.brusselsprout.sotw.client;

import net.brusselsprout.sotw.SproutOTW;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class SOTWCreativeTab extends CreativeTabs {

    public SOTWCreativeTab() {
        super(SproutOTW.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.BOOK);
    }
}

package net.brusselsprout.sotw.item;

import net.brusselsprout.sotw.SproutOTW;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    private String name;

    public ItemBase(String name) {
        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(SproutOTW.creativeTab);
    }

    public void registerItemModel() {
        SproutOTW.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}

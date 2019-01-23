package net.brusselsprout.sotw.block;

import net.brusselsprout.sotw.SproutOTW;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {

    private String name;

    public BlockBase(Material material, String name) {
        super(material);
        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(SproutOTW.creativeTab);
    }

    public void registerItemModel() {
        SproutOTW.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}

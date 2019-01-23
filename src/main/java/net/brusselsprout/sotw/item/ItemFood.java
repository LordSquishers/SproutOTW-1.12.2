package net.brusselsprout.sotw.item;

import net.brusselsprout.sotw.SproutOTW;
import net.minecraftforge.oredict.OreDictionary;

public class ItemFood extends net.minecraft.item.ItemFood {

    private String oreDictName;
    private String name;

    public ItemFood(String name, String oreDictName, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.oreDictName = oreDictName;
        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(SproutOTW.creativeTab);
    }

    public void initOreDict() {
        OreDictionary.registerOre(oreDictName, this);
    }

    public void registerItemModel() {
        SproutOTW.proxy.registerItemRenderer(this, 0, name);
    }

}

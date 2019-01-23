package net.brusselsprout.sotw.item;

import net.brusselsprout.sotw.SproutOTW;
import net.minecraftforge.oredict.OreDictionary;

public class ItemOre extends ItemBase {

    private String oreName;

    public ItemOre(String name, String oreName) {
        super(name);

        this.oreName = oreName;
        setCreativeTab(SproutOTW.creativeTab);
    }

    public void initOreDict() {
        OreDictionary.registerOre(oreName, this);
    }
}

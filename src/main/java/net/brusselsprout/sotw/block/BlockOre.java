package net.brusselsprout.sotw.block;

import net.brusselsprout.sotw.SproutOTW;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

public class BlockOre extends BlockBase {

    private String oreName;

    public BlockOre(String name, String oreName) {
        super(Material.ROCK, name);

        this.oreName = oreName;
        setHardness(3f);
        setResistance(5f);

        setCreativeTab(SproutOTW.creativeTab);
    }

    public void initOreDict() {
        OreDictionary.registerOre(oreName, this);
    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        return super.setCreativeTab(tab);
    }

}

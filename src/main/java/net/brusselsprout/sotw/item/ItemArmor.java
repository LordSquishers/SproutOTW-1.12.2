package net.brusselsprout.sotw.item;

import net.brusselsprout.sotw.SproutOTW;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemArmor extends net.minecraft.item.ItemArmor {

    private String name;

    public ItemArmor(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
        super(material, 0, slot);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.name = name;

        setCreativeTab(SproutOTW.creativeTab);
    }

    public void registerItemModel() {
        SproutOTW.proxy.registerItemRenderer(this, 0, name);
    }
}

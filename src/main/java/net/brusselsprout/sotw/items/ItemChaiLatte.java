package net.brusselsprout.sotw.items;

import net.brusselsprout.sotw.item.ItemFood;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemChaiLatte extends ItemFood {

    private static final int MAX_STACK_SIZE = 1;

    public ItemChaiLatte() {
        super("chai_latte", "foodDrink", 4, 3, false);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    @Override
    public Item setMaxStackSize(int maxStackSize) {
        this.maxStackSize = MAX_STACK_SIZE;
        return this;
    }
}

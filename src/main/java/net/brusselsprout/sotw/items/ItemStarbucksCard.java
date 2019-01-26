package net.brusselsprout.sotw.items;

import net.brusselsprout.sotw.item.ItemBase;
import net.minecraft.item.Item;

public class ItemStarbucksCard extends ItemBase {

    private static final int MAX_STACK_SIZE = 1;

    private float cardFunds = 0;

    public ItemStarbucksCard() {
        super("starbucks_card");
    }

    @Override
    public Item setMaxStackSize(int maxStackSize) {
        this.maxStackSize = MAX_STACK_SIZE;
        return this;
    }


}
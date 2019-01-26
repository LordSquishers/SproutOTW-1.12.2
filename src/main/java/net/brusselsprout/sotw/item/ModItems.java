package net.brusselsprout.sotw.item;

import net.brusselsprout.sotw.items.ItemChaiLatte;
import net.brusselsprout.sotw.items.ItemStarbucksCard;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    // Ingots
    public static ItemOre deorium_ingot = new ItemOre("deorium_ingot", "ingotDeorium");

    // Natural Resources

    // Foods
    public static ItemFood banana = new ItemFood("banana", "foodBanana", 2, 2, false);
    public static ItemFood lemon_muffin = new ItemFood("lemon_muffin", "foodMuffin", 3, 3, false);
    public static ItemChaiLatte chai_latte = new ItemChaiLatte();

    // Other
    public static ItemStarbucksCard starbucks_card = new ItemStarbucksCard();

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                banana,
                deorium_ingot,
                lemon_muffin,
                chai_latte,
                starbucks_card
        );
    }

    public static void registerModels() {
        banana.registerItemModel();
        deorium_ingot.registerItemModel();
        lemon_muffin.registerItemModel();
        chai_latte.registerItemModel();
        starbucks_card.registerItemModel();
    }
}

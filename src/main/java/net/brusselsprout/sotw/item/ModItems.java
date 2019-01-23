package net.brusselsprout.sotw.item;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    // Ingots

    // Natural Resources

    // Foods
    public static ItemFood banana = new ItemFood("banana", "foodBanana", 2, 2, false);

    // Other

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                banana
        );
    }

    public static void registerModels() {
        banana.registerItemModel();
    }
}

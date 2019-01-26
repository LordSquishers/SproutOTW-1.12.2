package net.brusselsprout.sotw;

import net.brusselsprout.sotw.block.ModBlocks;
import net.brusselsprout.sotw.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init() {
        // oredict init
        ModBlocks.deorium_ore.initOreDict();
        ModItems.deorium_ingot.initOreDict();

        // smelting
        GameRegistry.addSmelting(ModBlocks.deorium_ore, new ItemStack(ModItems.deorium_ingot, 1), 5.0f);
    }

}

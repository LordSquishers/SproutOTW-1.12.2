package net.brusselsprout.sotw.block;

import net.brusselsprout.sotw.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

    // Ores
    public static BlockOre deorium_ore = new BlockOre("deorium_ore", "oreDeorium");

    // Tile Entities
    public static BlockStarbucksShop starbucks_shop = new BlockStarbucksShop();

    // Blocks
    public static BlockLogBanana log_banana = new BlockLogBanana();
    public static BlockLeavesBanana leaves_banana = new BlockLeavesBanana();

    // Special Blocks
    public static BlockSaplingBanana sapling_banana = new BlockSaplingBanana();
    public static BlockBananaFruit banana_fruit = new BlockBananaFruit();

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                log_banana,
                leaves_banana,
                sapling_banana,
                banana_fruit,
                deorium_ore,
                starbucks_shop
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                log_banana.createItemBlock(),
                leaves_banana.createItemBlock(),
                sapling_banana.createItemBlock(),
                banana_fruit.createItemBlock(),
                deorium_ore.createItemBlock(),
                starbucks_shop.createItemBlock()
        );
    }

    public static void registerModels() {
        log_banana.registerItemModel();
        leaves_banana.registerItemModel();
        sapling_banana.registerItemModel();
        banana_fruit.registerItemModel();
        deorium_ore.registerItemModel();
        starbucks_shop.registerItemModel();
    }
}

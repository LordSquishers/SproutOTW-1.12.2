package net.brusselsprout.sotw.gui;

import net.brusselsprout.sotw.container.ContainerStarbucksShop;
import net.brusselsprout.sotw.tiles.TEStarbucksShop;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {

    public static final int STARBUCKS_SHOP = 0;

    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case STARBUCKS_SHOP:
                return new ContainerStarbucksShop(player.inventory, (TEStarbucksShop) world.getTileEntity(new BlockPos(x, y, z)));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case STARBUCKS_SHOP:
                return new GuiStarbucksShop(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
            default:
                return null;
        }
    }

}

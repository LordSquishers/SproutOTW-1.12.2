package net.brusselsprout.sotw.blocks;

import net.brusselsprout.sotw.SproutOTW;
import net.brusselsprout.sotw.block.BlockTileEntity;
import net.brusselsprout.sotw.gui.ModGuiHandler;
import net.brusselsprout.sotw.tiles.TEStarbucksShop;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockStarbucksShop extends BlockTileEntity<TEStarbucksShop> {

    public BlockStarbucksShop() {
        super(Material.IRON, "starbucks_shop");
    }

    // tile logic here


    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            playerIn.openGui(SproutOTW.instance, ModGuiHandler.STARBUCKS_SHOP, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }

    @Override
    public Class<TEStarbucksShop> getTileEntityClass() {
        return TEStarbucksShop.class;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TEStarbucksShop createTileEntity(World world, IBlockState state) {
        return new TEStarbucksShop();
    }
}

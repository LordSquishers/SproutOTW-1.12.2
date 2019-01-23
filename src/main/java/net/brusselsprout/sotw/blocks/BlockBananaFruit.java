package net.brusselsprout.sotw.blocks;

import net.brusselsprout.sotw.SproutOTW;
import net.brusselsprout.sotw.block.ModBlocks;
import net.brusselsprout.sotw.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockBananaFruit extends Block implements IGrowable, net.minecraftforge.common.IShearable {

    private static final int MATURE_AGE = 2;

    private static final String name = "banana_fruit";

    private final BlockSaplingBanana sapling;

    private final Item fruitItem;

    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, MATURE_AGE);
    public String BASE_STAGE_ID = null;

    public BlockBananaFruit() {
        super(Material.PLANTS);
        this.setTickRandomly(true);
        setSoundType(SoundType.WOOD);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));
        this.sapling = ModBlocks.sapling_banana;
        this.fruitItem = ModItems.banana;

        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        SproutOTW.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(playerIn.getHeldItem(hand).getItem() == new ItemStack(Items.DYE, 1, 15).getItem()) return false;

        if(!worldIn.isRemote) {
            if (getMetaFromState(state) >= MATURE_AGE) {
                state = state.withProperty(AGE, 0);
                worldIn.setBlockState(pos, state, 2);
                worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.banana, 1 + new Random().nextInt(2))));
                return true;
            }
        }

        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    public PropertyInteger getAgeProperty() {
        return AGE;
    }

    public Item getFruitItem() {
        if(fruitItem == null) {
            FMLLog.bigWarning("Cannot get fruit %s.", getUnlocalizedName());
        }

        return fruitItem;
    }

    public BlockSaplingBanana getSapling() {
        if(sapling == null) {
            FMLLog.bigWarning("Cannot get sapling for fruit %s.", getUnlocalizedName());
        }

        return sapling;
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        if(getMetaFromState(blockState) >= MATURE_AGE) {
            return 0f;
        }

        return 5f;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!this.canBlockStay(worldIn, pos))
        {
            this.dropBlock(worldIn, pos, state);
        }

    }

    private boolean canBlockStay(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.up()).getMaterial().isSolid();
    }

    private void dropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!(state.getValue(AGE) != 3))
        {

        }
        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        this.dropBlockAsItem(worldIn, pos, state, 0);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        if(getMetaFromState(state) >= MATURE_AGE) {
            drops.add(new ItemStack(getFruitItem(), 1 + new Random().nextInt(4)));
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        final Block leafBlock = world.getBlockState(pos.up()).getBlock();

        return isSuitableSoilBlock(leafBlock);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    private boolean isSuitableSoilBlock(Block leafBlock) {
        return leafBlock == ModBlocks.leaves_banana;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(AGE, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(AGE);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, AGE);
    }


    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        int i = state.getValue(AGE);

        if(i < MATURE_AGE && rand.nextInt(10) == 0) {
            state = state.withProperty(AGE, i + 1);
            worldIn.setBlockState(pos, state, 2);
        }

        super.updateTick(worldIn, pos, state, rand);

    }

    private void grow(World worldIn, BlockPos pos, IBlockState state) {
        int i = state.getValue(AGE) + MathHelper.getInt(worldIn.rand, 1, 2);
        if(i > MATURE_AGE) {
            i = MATURE_AGE;
        }
        worldIn.setBlockState(pos, state.withProperty(AGE, i), 2);
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return state.getValue(AGE) < MATURE_AGE;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        this.grow(worldIn, pos, state);
    }

    @Override public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos){ return true; }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        // TODO Auto-generated method stub
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, 0));
        return ret;
    }




}
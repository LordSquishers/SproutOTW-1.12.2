package net.brusselsprout.sotw.network;

import io.netty.buffer.ByteBuf;
import net.brusselsprout.sotw.tiles.TEStarbucksShop;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PRUStarbucksShop implements IMessage {

    private BlockPos pos;
    private int dimension;

    public PRUStarbucksShop(BlockPos pos, int dimension) {
        this.pos = pos;
        this.dimension = dimension;
    }

    public PRUStarbucksShop(TEStarbucksShop te) {
        this(te.getPos(), te.getWorld().provider.getDimension());
    }

    public PRUStarbucksShop() {
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        buf.writeInt(dimension);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
        dimension = buf.readInt();
    }

    public static class Handler implements IMessageHandler<PRUStarbucksShop, PUStarbucksShop> {

        @Override
        public PUStarbucksShop onMessage(PRUStarbucksShop message, MessageContext ctx) {
            World world = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(message.dimension);
            TEStarbucksShop te = (TEStarbucksShop)world.getTileEntity(message.pos);
            if (te != null) {
                return new PUStarbucksShop(te);
            } else {
                return null;
            }
        }

    }

}

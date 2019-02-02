package net.brusselsprout.sotw.network;

import io.netty.buffer.ByteBuf;
import net.brusselsprout.sotw.tiles.TEStarbucksShop;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PUStarbucksShop implements IMessage {

    private BlockPos pos;
    private ItemStack stack;
    private long lastChangeTime;

    public PUStarbucksShop(BlockPos pos, ItemStack stack, long lastChangeTime) {
        this.pos = pos;
        this.stack = stack;
        this.lastChangeTime = lastChangeTime;
    }

    public PUStarbucksShop(TEStarbucksShop te) {
        this(te.getPos(), te.inventory.getStackInSlot(0), te.lastChangeTime);
    }

    public PUStarbucksShop() {
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        ByteBufUtils.writeItemStack(buf, stack);
        buf.writeLong(lastChangeTime);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
        stack = ByteBufUtils.readItemStack(buf);
        lastChangeTime = buf.readLong();
    }

    public static class Handler implements IMessageHandler<PUStarbucksShop, IMessage> {

        @Override
        public IMessage onMessage(PUStarbucksShop message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                TEStarbucksShop te = (TEStarbucksShop) Minecraft.getMinecraft().world.getTileEntity(message.pos);
                te.inventory.setStackInSlot(0, message.stack);
                te.lastChangeTime = message.lastChangeTime;
            });
            return null;
        }

    }

}

package com.werlsoft.bsm.mods.fmp.blocks;

import java.util.LinkedList;

import codechicken.multipart.TileMultipart;
import codechicken.multipart.TileMultipartClient;
import codechicken.multipart.asm.StackAnalyser.This;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import buildcraft.api.blueprints.IBuilderContext;
import buildcraft.api.blueprints.SchematicTile;

public class SchematicMultipart extends SchematicTile {
	
	@Override
	public void writeToWorld(IBuilderContext context, int x, int y, int z, LinkedList<ItemStack> stacks) {
		// Meta needs to be specified twice, depending on the block behavior
		context.world().setBlock(x, y, z, block, meta, 3);
		context.world().setBlockMetadataWithNotify(x, y, z, meta, 3);
		
		if (block.hasTileEntity(meta)) {
			
			tileNBT.setInteger("x", x);
			tileNBT.setInteger("y", y);
			tileNBT.setInteger("z", z);
			
			context.world().setTileEntity(x, y, z, TileMultipartClient.createFromNBT(tileNBT));
			
			TileEntity tile = context.world().getTileEntity(x, y, z);
			
			/*if(tile != null){
				if(tile instanceof TileMultipart){
					TileMultipart part = (TileMultipart)tile;
					for(int i = 0; i < context.world().playerEntities.size(); i++){
						EntityPlayer player = (EntityPlayer) context.world().playerEntities.get(i);
						if(player instanceof EntityPlayerMP){
							System.out.println("a");
							Packet packet = part.();

				            if (packet != null)
				            {
				            	
				                ((EntityPlayerMP)player).playerNetServerHandler.sendPacket(packet);
				            }
						}
					}
				}
			}*/
		}
	}

}
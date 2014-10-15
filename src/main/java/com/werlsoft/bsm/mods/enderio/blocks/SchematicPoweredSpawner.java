package com.werlsoft.bsm.mods.enderio.blocks;

import java.util.LinkedList;

import crazypants.enderio.EnderIO;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import buildcraft.api.blueprints.IBuilderContext;

public class SchematicPoweredSpawner extends SchematicEIOEnergy {
	
	@Override
	public void writeToWorld(IBuilderContext context, int x, int y, int z, LinkedList<ItemStack> stacks) {
		if(this.tileNBT.hasKey("EndityId"))
			this.tileNBT.setString("EntityId", "none");
		if(this.tileNBT.hasKey("mobType"))
			this.tileNBT.removeTag("mobType");
		
		super.writeToWorld(context, x, y, z, stacks);
	}

}

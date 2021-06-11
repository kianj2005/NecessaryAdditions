package com.therifty.necessaryadditions.common.container;

import java.util.Objects;

import com.therifty.necessaryadditions.common.te.DisplayCaseTileEntity;
import com.therifty.necessaryadditions.core.init.ContainerTypesInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class DisplayCaseContainer extends Container{
	public final DisplayCaseTileEntity te;
	private final IWorldPosCallable canInteractWithCallable;
	
	
	public DisplayCaseContainer(final int windowId, final PlayerInventory playerInv, final DisplayCaseTileEntity te) {
		super(ContainerTypesInit.DISPLAY_CASE_CONTAINER_TYPE.get(), windowId);
		this.te = te;
		this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
		
		//Main Player Inventory
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col< 9; col++) {
				//this.addSlot(new Slot(playerInv, col * row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));
			}
		}
	}

	public DisplayCaseContainer(final int windowId, final PlayerInventory playerInv, final PacketBuffer data) {
		this(windowId, playerInv, getTileEntity(playerInv, data));
	}

	private static DisplayCaseTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "Player Inventory cannot be null.");
		Objects.requireNonNull(data, "Player Buffer cannot be null.");
		final TileEntity te = playerInv.player.world.getTileEntity(data.readBlockPos());
		if(te instanceof DisplayCaseTileEntity) {
			return (DisplayCaseTileEntity) te;
		}
		throw new IllegalStateException("Tile Entity Is Not Correct");
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		// TODO Auto-generated method stub
		return false;
	}

}

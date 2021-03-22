package com.stevenpaw.awesomeshop.recipe;

import com.stevenpaw.awesomeshop.client.container.ShredderContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ShredderFuelSlot extends Slot {
    private final ShredderContainer shredderContainer;

    public ShredderFuelSlot(ShredderContainer shredderContainer, IInventory furnaceInventory, int index, int xPosition, int yPosition) {
        super(furnaceInventory, index, xPosition, yPosition);
        this.shredderContainer = shredderContainer;
    }

    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
     */
    public boolean isItemValid(ItemStack stack) {
        return this.shredderContainer.isFuel(stack) || isBucket(stack);
    }

    public int getItemStackLimit(ItemStack stack) {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return stack.getItem() == Items.BUCKET;
    }
}

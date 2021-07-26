package com.stevenpaw.awesomeshop.integrations.jei;

import com.stevenpaw.awesomeshop.client.container.ShredderContainer;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ShredderRecipeTransferInfo implements IRecipeTransferInfo<ShredderContainer> {
    @Override
    public Class<ShredderContainer> getContainerClass() {
        return ShredderContainer.class;
    }

    @Override
    public ResourceLocation getRecipeCategoryUid() {
        return ShredderRecipeCategory.ID;
    }

    @Override
    public boolean canHandle(ShredderContainer container) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(ShredderContainer container) {
        List<Slot> slots = new ArrayList<>(1);

        slots.add(container.getSlot(0));

        return slots;
    }

    @Override
    public List<Slot> getInventorySlots(ShredderContainer container) {
        List<Slot> inventorySlots = new ArrayList<Slot>(container.inventorySlots.size() - 3) ;

        for (int i = 3; i < container.inventorySlots.size(); i++) {
            inventorySlots.add(container.getSlot(i));
        }

        return inventorySlots;
    }
}

package com.stevenpaw.awesomeshop.recipe;

import com.stevenpaw.awesomeshop.client.container.AwesomeShopContainer;
import com.stevenpaw.awesomeshop.client.container.ShredderContainer;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class AwesomeShopRecipeTransferInfo implements IRecipeTransferInfo<AwesomeShopContainer> {
    @Override
    public Class<AwesomeShopContainer> getContainerClass() {
        return AwesomeShopContainer.class;
    }

    @Override
    public ResourceLocation getRecipeCategoryUid() {
        return AwesomeShopRecipeCategory.ID;
    }

    @Override
    public boolean canHandle(AwesomeShopContainer container) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(AwesomeShopContainer container) {
        List<Slot> slots = new ArrayList<>(1);

        slots.add(container.getSlot(0));

        return slots;
    }

    @Override
    public List<Slot> getInventorySlots(AwesomeShopContainer container) {
        List<Slot> inventorySlots = new ArrayList<Slot>(container.inventorySlots.size() - 3) ;

        for (int i = 3; i < container.inventorySlots.size(); i++) {
            inventorySlots.add(container.getSlot(i));
        }

        return inventorySlots;
    }
}

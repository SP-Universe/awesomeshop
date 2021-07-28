package com.stevenpaw.awesomeshop.integrations.jei;

import com.stevenpaw.awesomeshop.client.container.SignPainterContainer;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class SignPainterRecipeTransferInfo implements IRecipeTransferInfo<SignPainterContainer> {
    @Override
    public Class<SignPainterContainer> getContainerClass() {
        return SignPainterContainer.class;
    }

    @Override
    public ResourceLocation getRecipeCategoryUid() {
        return SignPainterRecipeCategory.ID;
    }

    @Override
    public boolean canHandle(SignPainterContainer container) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(SignPainterContainer container) {
        List<Slot> slots = new ArrayList<>(1);

        slots.add(container.getSlot(0));

        return slots;
    }

    @Override
    public List<Slot> getInventorySlots(SignPainterContainer container) {
        List<Slot> inventorySlots = new ArrayList<Slot>(container.inventorySlots.size() - 3) ;

        for (int i = 3; i < container.inventorySlots.size(); i++) {
            inventorySlots.add(container.getSlot(i));
        }

        return inventorySlots;
    }
}

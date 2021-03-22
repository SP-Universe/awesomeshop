package com.stevenpaw.awesomeshop.client.container;

import com.stevenpaw.awesomeshop.init.BlockInit;
import com.stevenpaw.awesomeshop.init.ModContainerTypes;
import com.stevenpaw.awesomeshop.recipe.ModRecipeType;
import com.stevenpaw.awesomeshop.tileentity.ShredderTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntArray;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;

public class ShredderContainer extends AbstractFurnaceContainer {

    public ShredderContainer(int id, PlayerInventory playerInventory, IInventory inventory, IIntArray array) {

        super(ModContainerTypes.SHREDDER.get(), ModRecipeType.SHREDDER, RecipeBookCategory.FURNACE, id, playerInventory, inventory, array);

    }

    public ShredderContainer(int id, PlayerInventory playerInventory, PacketBuffer extraData) {

        super(ModContainerTypes.SHREDDER.get(), ModRecipeType.SHREDDER, RecipeBookCategory.FURNACE, id, playerInventory);

    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {

        return true;

    }
}

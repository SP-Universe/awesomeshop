package com.stevenpaw.awesomeshop.tileentity;

import com.stevenpaw.awesomeshop.client.container.ShredderContainer;
import com.stevenpaw.awesomeshop.init.ModContainerTypes;
import com.stevenpaw.awesomeshop.init.ModTileEntityTypes;
import com.stevenpaw.awesomeshop.objects.blocks.Shredder;
import com.stevenpaw.awesomeshop.recipe.ModRecipeType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nonnull;

public class ShredderTileEntity extends AbstractShredderTileEntity {

    public ShredderTileEntity() {

        super(ModTileEntityTypes.SHREDDER.get(), ModRecipeType.SHREDDER);

    }

    @Override
    protected ITextComponent getDefaultName() {

        return new TranslationTextComponent("container.shredder");

    }

    @Override
    protected int getBurnTime(ItemStack fuel) {

        return super.getBurnTime(fuel) / 2;

    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {

        return new ShredderContainer(ModContainerTypes.SHREDDER.get(), id, player, this, this.furnaceData);

    }
}

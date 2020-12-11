package com.stevenpaw.awesomeshop.util;

import com.stevenpaw.awesomeshop.tileentity.ShredderTileEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.IIntArray;

import java.util.Arrays;

public class ShredderStateData implements IIntArray {
    public static final int FUEL_SLOTS_COUNT = ShredderTileEntity.FUEL_SLOTS_COUNT;

    /**The number of ticks that the current item has been cooking*/
    public int shredderTimeElapsed;
    // The number of ticks required to cook the current item (i.e complete when cookTimeElapsed == cookTimeForCompletion
    public int shredderTimeForCompletion;

    /** The initial fuel value of the currently burning fuel in each slot (in ticks of burn duration) */
    public int [] burnTimeInitialValues = new int[FUEL_SLOTS_COUNT];
    /** The number of burn ticks remaining on the current piece of fuel in each slot */
    public int [] burnTimeRemainings = new int[FUEL_SLOTS_COUNT];

    // --------- read/write to NBT for permanent storage (on disk, or packet transmission) - used by the TileEntity only

    public void putIntoNBT(CompoundNBT nbtTagCompound) {
        nbtTagCompound.putInt("CookTimeElapsed", shredderTimeElapsed);
        nbtTagCompound.putInt("CookTimeForCompletion", shredderTimeElapsed);
        nbtTagCompound.putIntArray("burnTimeRemainings", burnTimeRemainings);
        nbtTagCompound.putIntArray("burnTimeInitial", burnTimeInitialValues);
    }

    public void readFromNBT(CompoundNBT nbtTagCompound) {
        // Trim the arrays (or pad with 0) to make sure they have the correct number of elements
        shredderTimeElapsed = nbtTagCompound.getInt("CookTimeElapsed");
        shredderTimeForCompletion = nbtTagCompound.getInt("CookTimeForCompletion");
        burnTimeRemainings = Arrays.copyOf(nbtTagCompound.getIntArray("burnTimeRemainings"), FUEL_SLOTS_COUNT);
        burnTimeInitialValues = Arrays.copyOf(nbtTagCompound.getIntArray("burnTimeInitialValues"), FUEL_SLOTS_COUNT);
    }

    // -------- used by vanilla, not intended for mod code
//  * The ints are mapped (internally) as:
//  * 0 = cookTimeElapsed
//  * 1 = cookTimeForCompletion
//  * 2 .. FUEL_SLOTS_COUNT+1 = burnTimeInitialValues[]
//  * FUEL_SLOTS_COUNT + 2 .. 2*FUEL_SLOTS_COUNT +1 = burnTimeRemainings[]
//  *

    private final int COOKTIME_INDEX = 0;
    private final int COOKTIME_FOR_COMPLETION_INDEX = 1;
    private final int BURNTIME_INITIAL_VALUE_INDEX = 2;
    private final int BURNTIME_REMAINING_INDEX = BURNTIME_INITIAL_VALUE_INDEX + FUEL_SLOTS_COUNT;
    private final int END_OF_DATA_INDEX_PLUS_ONE = BURNTIME_REMAINING_INDEX + FUEL_SLOTS_COUNT;

    @Override
    public int get(int index) {
        validateIndex(index);
        if (index == COOKTIME_INDEX) {
            return shredderTimeElapsed;
        } else if (index == COOKTIME_FOR_COMPLETION_INDEX) {
            return shredderTimeForCompletion;
        } else if (index >= BURNTIME_INITIAL_VALUE_INDEX && index < BURNTIME_REMAINING_INDEX) {
            return burnTimeInitialValues[index - BURNTIME_INITIAL_VALUE_INDEX];
        } else {
            return burnTimeRemainings[index - BURNTIME_REMAINING_INDEX];
        }
    }

    @Override
    public void set(int index, int value) {
        validateIndex(index);
        if (index == COOKTIME_INDEX) {
            shredderTimeElapsed = value;
        } else if (index == COOKTIME_FOR_COMPLETION_INDEX) {
            shredderTimeForCompletion = value;
        } else if (index >= BURNTIME_INITIAL_VALUE_INDEX && index < BURNTIME_REMAINING_INDEX) {
            burnTimeInitialValues[index - BURNTIME_INITIAL_VALUE_INDEX] = value;
        } else {
            burnTimeRemainings[index - BURNTIME_REMAINING_INDEX] = value;
        }
    }

    @Override
    public int size() {
        return END_OF_DATA_INDEX_PLUS_ONE;
    }

    private void validateIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds:"+index);
        }
    }
}


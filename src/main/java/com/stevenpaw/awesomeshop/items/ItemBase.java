package com.stevenpaw.awesomeshop.items;

import com.stevenpaw.awesomeshop.AwesomeShop;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
    public ItemBase() {
        super(new Item.Properties().group(AwesomeShop.ITEMTAB)); //Creates a standard Item
    }
}

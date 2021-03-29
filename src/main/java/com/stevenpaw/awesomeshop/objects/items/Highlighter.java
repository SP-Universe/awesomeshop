package com.stevenpaw.awesomeshop.objects.items;

import com.stevenpaw.awesomeshop.AwesomeShop;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public class Highlighter extends Item
{
    public Highlighter() {
        super(new Properties().group(AwesomeShop.ITEMTAB)); //Creates a standard Item
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        if(InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
            super.addInformation(stack, worldIn, tooltip, flagIn);
            tooltip.add(new StringTextComponent(TextFormatting.BLUE + "You can use it to highlight any Entity"));
            tooltip.add(new StringTextComponent(TextFormatting.BLUE + "Just rightclick to highlight or de-highlight"));
        }
        else
        {
            tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "Shift" + "\u00A77" + " for More Information")); //"\u00A7e" is a color code
        }
    }
}

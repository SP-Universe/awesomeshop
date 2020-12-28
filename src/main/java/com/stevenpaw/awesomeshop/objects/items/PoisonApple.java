package com.stevenpaw.awesomeshop.objects.items;

import com.stevenpaw.awesomeshop.AwesomeShop;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public class PoisonApple extends Item {

    public PoisonApple() {
        super(new Item.Properties()
                .group(AwesomeShop.ITEMTAB)
                .food(new Food.Builder()
                        .hunger(4)
                        .saturation(1.2F)
                        .effect(new EffectInstance(Effects.NAUSEA, 300, 0), 1)
                        .effect(new EffectInstance(Effects.POISON, 300, 1), 1)
                        .effect(new EffectInstance(Effects.HUNGER, 300, 0), 0.3f)
                        .setAlwaysEdible()
                        .build())
        );
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        if(InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
            tooltip.add(new StringTextComponent("This Apple will give you poison and nausea"));
            tooltip.add(new StringTextComponent("Sometimes even hunger!"));
            tooltip.add(new StringTextComponent("So watch out when to eat it"));
        }
        else
        {
            tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "Shift" + "\u00A77" + " for More Information")); //"\u00A7e" is a color code
        }
    }
}

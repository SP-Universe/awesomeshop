package com.stevenpaw.awesomeshop.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.blocks.Shredder;
import com.stevenpaw.awesomeshop.container.ShredderContainer;
import com.stevenpaw.awesomeshop.init.ModContainerTypes;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.awt.*;

@OnlyIn(Dist.CLIENT)
public class ShredderScreen extends Screen {

    ContainerType<ShredderContainer> container = ModContainerTypes.SHREDDER.get();

    public ShredderScreen(MatrixStack matrixStack) {
        super(new TranslationTextComponent("awesomeshop/gui/shredder/title"));
        this.blit(matrixStack, 100, 50, 0, 0,  this.container.getShredderedProgressionLevel,24);
        this.resize(minecraft, 176, 166);
    }
    private static final ResourceLocation TEXTURE = new ResourceLocation(AwesomeShop.MOD_ID, "textures/gui/shredder.png");

    public void render(MatrixStack matrixStack, final int mouseX, final int mouseY, final float partialTicks) {

        this.renderBackground(matrixStack);
        this.minecraft.getTextureManager().bindTexture(TEXTURE);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }
}

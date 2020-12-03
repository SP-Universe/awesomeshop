package com.stevenpaw.awesomeshop.containerScreens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.stevenpaw.awesomeshop.container.ShredderContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShredderContainerScreen extends ContainerScreen<ShredderContainer> {
    private ShredderContainer shredderContainer;
    public ShredderContainerScreen(ShredderContainer containerFurnace, PlayerInventory playerInventory, ITextComponent title) {
        super(containerFurnace, playerInventory, title);
        this.shredderContainer = containerFurnace;

        // Set the width and height of the gui.  Should match the size of the texture!
        xSize = 176;
        ySize = 207;
    }

    // some [x,y] coordinates of graphical elements
    final static int COOK_BAR_XPOS = 49;
    final static  int COOK_BAR_YPOS = 60;
    final static  int COOK_BAR_ICON_U = 0;   // texture position of white arrow icon [u,v]
    final static  int COOK_BAR_ICON_V = 207;
    final static  int SHREDDER_BAR_WIDTH = 80;
    final static  int SHREDDER_BAR_HEIGHT = 17;

    final static  int FLAME_XPOS = 54;
    final static  int FLAME_YPOS = 80;
    final static  int FLAME_ICON_U = 176;   // texture position of flame icon [u,v]
    final static  int FLAME_ICON_V = 0;
    final static  int FLAME_WIDTH = 14;
    final static  int FLAME_HEIGHT = 14;
    final static  int FLAME_X_SPACING = 18;

    final static  int FONT_Y_SPACING = 10;
    final static  int PLAYER_INV_LABEL_XPOS = ShredderContainer.PLAYER_INVENTORY_XPOS;
    final static  int PLAYER_INV_LABEL_YPOS = ShredderContainer.PLAYER_INVENTORY_YPOS - FONT_Y_SPACING;

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    // Draw the Tool tip text if hovering over something of interest on the screen
    // renderHoveredToolTip
    @Override
    protected void renderHoveredTooltip(MatrixStack matrixStack, int mouseX, int mouseY) {
        if (!this.minecraft.player.inventory.getItemStack().isEmpty()) return;  // no tooltip if the player is dragging something

        List<ITextComponent> hoveringText = new ArrayList<ITextComponent>();

        // If the mouse is over the progress bar add the progress bar hovering text
        if (isInRect(guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, SHREDDER_BAR_WIDTH, SHREDDER_BAR_HEIGHT, mouseX, mouseY)){
            hoveringText.add(new StringTextComponent("Progress:"));
            int cookPercentage =(int)(shredderContainer.fractionOfShredderTimeComplete() * 100);
            hoveringText.add(new StringTextComponent(cookPercentage + "%"));
        }

        // If the mouse is over one of the burn time indicators, add the burn time indicator hovering text
        for (int i = 0; i < shredderContainer.FUEL_SLOTS_COUNT; ++i) {
            if (isInRect(guiLeft + FLAME_XPOS + FLAME_X_SPACING * i, guiTop + FLAME_YPOS, FLAME_WIDTH, FLAME_HEIGHT, mouseX, mouseY)) {
                hoveringText.add(new StringTextComponent("Fuel Time:"));
                hoveringText.add(new StringTextComponent(shredderContainer.secondsOfFuelRemaining(i) + "s"));
            }
        }

        // If hoveringText is not empty draw the hovering text.  Otherwise, use vanilla to render tooltip for the slots
        if (!hoveringText.isEmpty()){
            func_243308_b(matrixStack, hoveringText, mouseX, mouseY);  //renderToolTip
        } else {
            super.renderHoveredTooltip(matrixStack, mouseX, mouseY);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(TEXTURE);

        // width and height are the size provided to the window when initialised after creation.
        // xSize, ySize are the expected size of the texture-? usually seems to be left as a default.
        // The code below is typical for vanilla containers, so I've just copied that- it appears to centre the texture within
        //  the available window
        // draw the background for this window
        int edgeSpacingX = (this.width - this.xSize) / 2;
        int edgeSpacingY = (this.height - this.ySize) / 2;
        this.blit(matrixStack, edgeSpacingX, edgeSpacingY, 0, 0, this.xSize, this.ySize);

        // draw the cook progress bar
        double cookProgress = shredderContainer.fractionOfShredderTimeComplete();
        this.blit(matrixStack, guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, COOK_BAR_ICON_U, COOK_BAR_ICON_V,
                (int) (cookProgress * SHREDDER_BAR_WIDTH), SHREDDER_BAR_HEIGHT);

        // draw the fuel remaining bar for each fuel slot flame
        for (int i = 0; i < shredderContainer.FUEL_SLOTS_COUNT; ++i) {
            double shredderRemaining = shredderContainer.fractionOfFuelRemaining(i);
            int yOffset = (int)((1.0 - shredderRemaining) * FLAME_HEIGHT);
            this.blit(matrixStack, guiLeft + FLAME_XPOS + FLAME_X_SPACING * i, guiTop + FLAME_YPOS + yOffset,
                    FLAME_ICON_U, FLAME_ICON_V + yOffset, FLAME_WIDTH, FLAME_HEIGHT - yOffset);
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int mouseX, int mouseY) {
        // draw the label for the top of the screen
        final int LABEL_XPOS = 5;
        final int LABEL_YPOS = 5;
        this.font.func_243248_b(matrixStack, this.title, LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());     ///    this.font.drawString

        // draw the label for the player inventory slots
        this.font.func_243248_b(matrixStack, this.playerInventory.getDisplayName(),                  ///    this.font.drawString
                PLAYER_INV_LABEL_XPOS, PLAYER_INV_LABEL_YPOS, Color.darkGray.getRGB());
    }

    // Returns true if the given x,y coordinates are within the given rectangle
    public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY){
        return ((mouseX >= x && mouseX <= x+xSize) && (mouseY >= y && mouseY <= y+ySize));
    }

    // This is the resource location for the background image
    private static final ResourceLocation TEXTURE = new ResourceLocation("awesomeshop", "textures/gui/shredder.png");
}
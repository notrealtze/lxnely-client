package com.lxnely.client.gui.components;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GuiToggle {
    private final String label;
    private final Supplier<Boolean> getter;
    private final Consumer<Boolean> setter;
    public int x, y, width, height;

    public GuiToggle(String label, Supplier<Boolean> getter, Consumer<Boolean> setter) {
        this.label = label;
        this.getter = getter;
        this.setter = setter;
    }

    public void draw(int mouseX, int mouseY) {
        boolean active = getter.get();
        int bgColor = active ? 0xFF2ECC71 : 0xFFE74C3C;
        Gui.drawRect(x, y, x + width, y + height, bgColor);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(label, x + 4, y + (height - 8) / 2, 0xFFFFFF);
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 0 && mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
            setter.accept(!getter.get());
        }
    }
}

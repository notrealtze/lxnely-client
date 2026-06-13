package com.lxnely.client.gui.components;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.MathHelper;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GuiSlider {
    private final String label;
    private final int min, max;
    private final Supplier<Integer> getter;
    private final Consumer<Integer> setter;
    public int x, y, width, height;
    private boolean dragging = false;

    public GuiSlider(String label, int min, int max, Supplier<Integer> getter, Consumer<Integer> setter) {
        this.label = label;
        this.min = min;
        this.max = max;
        this.getter = getter;
        this.setter = setter;
    }

    public void draw(int mouseX, int mouseY) {
        int currentVal = getter.get();
        float sliderVal = (float) (currentVal - min) / (max - min);
        if (dragging) {
            sliderVal = (float) (mouseX - x) / width;
            sliderVal = MathHelper.clamp_float(sliderVal, 0.0F, 1.0F);
            int newVal = Math.round(min + (sliderVal * (max - min)));
            setter.accept(newVal);
        }
        Gui.drawRect(x, y, x + width, y + height, 0xFF34495E);
        int handleWidth = (int) (sliderVal * width);
        Gui.drawRect(x, y, x + handleWidth, y + height, 0xFF3498DB);
        String text = label + ": " + currentVal;
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(text, x + 4, y + (height - 8) / 2, 0xFFFFFF);
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 0 && mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
            dragging = true;
        }
    }

    public void mouseReleased(int mouseX, int mouseY, int state) {
        if (state == 0) dragging = false;
    }
}

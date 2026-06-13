package com.lxnely.client.gui.components;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import java.util.ArrayList;
import java.util.List;

public class CategoryPanel {
    public String name;
    public int x, y, width;
    public List<GuiToggle> toggles = new ArrayList<>();

    public CategoryPanel(String name, int x, int y, int width) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public void draw(int mouseX, int mouseY) {
        Gui.drawRect(x, y, x + width, y + 15, 0xFF2980B9);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(name, x + 5, y + 4, 0xFFFFFFFF);
        int offset = 15;
        for (GuiToggle t : toggles) {
            t.x = x;
            t.y = y + offset;
            t.width = width;
            t.height = 15;
            t.draw(mouseX, mouseY);
            offset += 15;
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        for (GuiToggle t : toggles) t.mouseClicked(mouseX, mouseY, mouseButton);
    }
}

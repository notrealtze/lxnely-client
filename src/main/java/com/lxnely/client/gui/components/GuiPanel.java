package com.lxnely.client.gui.components;

import com.lxnely.client.config.ClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import java.util.ArrayList;
import java.util.List;

public class GuiPanel {
    private final String title;
    private final int x, y, width, headerHeight;
    private final List<GuiToggle> toggles = new ArrayList<>();
    private final List<GuiSlider> sliders = new ArrayList<>();

    public GuiPanel(String title, int x, int y, int width) {
        this.title = title;
        this.x = x;
        this.y = y;
        this.width = width;
        this.headerHeight = 20;

        toggles.add(new GuiToggle("Show FPS", () -> ClientConfig.showFPS, val -> ClientConfig.showFPS = val));
        toggles.add(new GuiToggle("Smooth Lighting", () -> ClientConfig.smoothLighting, val -> ClientConfig.smoothLighting = val));
        sliders.add(new GuiSlider("Render Distance", 2, 16, () -> ClientConfig.renderDistance, val -> ClientConfig.renderDistance = val));
        layoutComponents();
    }

    private void layoutComponents() {
        int currentY = y + headerHeight;
        int compHeight = 18;
        for (GuiToggle t : toggles) {
            t.x = x;
            t.y = currentY;
            t.width = width;
            t.height = compHeight;
            currentY += compHeight;
        }
        for (GuiSlider s : sliders) {
            s.x = x;
            s.y = currentY;
            s.width = width;
            s.height = compHeight;
            currentY += compHeight;
        }
    }

    public void draw(int mouseX, int mouseY) {
        Gui.drawRect(x, y, x + width, y + headerHeight, 0xFF2C3E50);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(title, x + 6, y + (headerHeight - 8) / 2, 0xFFFFFF);
        for (GuiToggle t : toggles) t.draw(mouseX, mouseY);
        for (GuiSlider s : sliders) s.draw(mouseX, mouseY);
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        for (GuiToggle t : toggles) t.mouseClicked(mouseX, mouseY, mouseButton);
        for (GuiSlider s : sliders) s.mouseClicked(mouseX, mouseY, mouseButton);
    }

    public void mouseReleased(int mouseX, int mouseY, int state) {
        for (GuiSlider s : sliders) s.mouseReleased(mouseX, mouseY, state);
    }
}

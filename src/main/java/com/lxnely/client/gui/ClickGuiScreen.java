package com.lxnely.client.gui;

import com.lxnely.client.config.ClientConfig;
import com.lxnely.client.gui.components.CategoryPanel;
import com.lxnely.client.gui.components.GuiToggle;
import net.minecraft.client.gui.GuiScreen;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClickGuiScreen extends GuiScreen {
    private List<CategoryPanel> panels = new ArrayList<>();

    @Override
    public void initGui() {
        panels.clear();
        CategoryPanel movement = new CategoryPanel("Movement", 40, 40, 90);
        movement.toggles.add(new GuiToggle("ToggleSprint", () -> ClientConfig.toggleSprint, v -> ClientConfig.toggleSprint = v));
        
        CategoryPanel visuals = new CategoryPanel("Visuals", 140, 40, 90);
        visuals.toggles.add(new GuiToggle("Keystrokes", () -> ClientConfig.showKeystrokes, v -> ClientConfig.showKeystrokes = v));
        visuals.toggles.add(new GuiToggle("FPS Display", () -> ClientConfig.showFPS, v -> ClientConfig.showFPS = v));
        
        panels.add(movement);
        panels.add(visuals);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        for (CategoryPanel p : panels) p.draw(mouseX, mouseY);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        for (CategoryPanel p : panels) p.mouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean doesGuiPauseGame() { return false; }
}

package com.lxnely.client.gui;

import com.lxnely.client.gui.components.GuiPanel;
import net.minecraft.client.gui.GuiScreen;
import java.io.IOException;

public class ClickGuiScreen extends GuiScreen {
    private GuiPanel mainPanel;

    @Override
    public void initGui() {
        mainPanel = new GuiPanel("Lxnely Client Settings", this.width / 2 - 100, this.height / 2 - 50, 200);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        mainPanel.draw(mouseX, mouseY);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        mainPanel.mouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        mainPanel.mouseReleased(mouseX, mouseY, state);
        super.mouseReleased(mouseX, mouseY, state);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}

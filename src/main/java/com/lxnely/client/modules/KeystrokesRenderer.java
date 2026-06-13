package com.lxnely.client.modules;

import com.lxnely.client.config.ClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Mouse;

public class KeystrokesRenderer {
    private final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {
        if (event.type != RenderGameOverlayEvent.ElementType.ALL || !ClientConfig.showKeystrokes || mc.gameSettings.showDebugInfo) return;
        int x = 5, y = 5;
        drawKey(mc.gameSettings.keyBindForward, x + 22, y, 20, 20, "W");
        drawKey(mc.gameSettings.keyBindLeft, x, y + 22, 20, 20, "A");
        drawKey(mc.gameSettings.keyBindBack, x + 22, y + 22, 20, 20, "S");
        drawKey(mc.gameSettings.keyBindRight, x + 44, y + 22, 20, 20, "D");
        drawMouseKey(0, x, y + 44, 31, 20, "LMB");
        drawMouseKey(1, x + 33, y + 44, 31, 20, "RMB");
        if (ClientConfig.showFPS) {
            String fps = Minecraft.getDebugFPS() + " FPS";
            mc.fontRendererObj.drawStringWithShadow(fps, 5, y + 68, 0xFFFFFF);
        }
    }

    private void drawKey(KeyBinding key, int x, int y, int w, int h, String name) {
        boolean pressed = key.isKeyDown();
        Gui.drawRect(x, y, x + w, y + h, pressed ? 0xAAFFFFFF : 0x66000000);
        mc.fontRendererObj.drawStringWithShadow(name, x + (w/2) - (mc.fontRendererObj.getStringWidth(name)/2), y + (h/2) - 4, pressed ? 0xFF000000 : 0xFFFFFFFF);
    }

    private void drawMouseKey(int button, int x, int y, int w, int h, String name) {
        boolean pressed = Mouse.isButtonDown(button);
        Gui.drawRect(x, y, x + w, y + h, pressed ? 0xAAFFFFFF : 0x66000000);
        mc.fontRendererObj.drawStringWithShadow(name, x + (w/2) - (mc.fontRendererObj.getStringWidth(name)/2), y + (h/2) - 4, pressed ? 0xFF000000 : 0xFFFFFFFF);
    }
}

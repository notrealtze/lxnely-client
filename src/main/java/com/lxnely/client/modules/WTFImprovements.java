package com.lxnely.client.modules;

import com.lxnely.client.config.ClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class WTFImprovements {
    private final Minecraft mc = Minecraft.getMinecraft();
    private boolean applied = false;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.START || mc.theWorld == null || applied) return;
        applied = true;
        if (ClientConfig.smoothLighting && mc.gameSettings.ambientOcclusion != 2) {
            mc.gameSettings.ambientOcclusion = 2;
            mc.renderGlobal.loadRenderers();
        }
        if (mc.gameSettings.renderDistanceChunks != ClientConfig.renderDistance) {
            mc.gameSettings.renderDistanceChunks = ClientConfig.renderDistance;
            mc.renderGlobal.loadRenderers();
        }
    }

    @SubscribeEvent
    public void onWorldUnload(WorldEvent.Unload event) {
        applied = false;
    }

    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent.Post event) {
        if (event.type != RenderGameOverlayEvent.ElementType.ALL || !ClientConfig.showFPS || mc.gameSettings.showDebugInfo) return;
        FontRenderer fr = mc.fontRendererObj;
        ScaledResolution sr = new ScaledResolution(mc);
        String text = Minecraft.getDebugFPS() + " FPS";
        fr.drawStringWithShadow(text, sr.getScaledWidth() - fr.getStringWidth(text) - 2, 2, 0xFFFFFF);
    }
}

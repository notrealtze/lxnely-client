package com.lxnely.client.modules;

import com.lxnely.client.config.ClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ToggleSprint {
    private final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) {
        if (ClientConfig.toggleSprint && mc.thePlayer != null && event.phase == TickEvent.Phase.START) {
            if (mc.thePlayer.moveForward > 0 && !mc.thePlayer.isSneaking() && !mc.thePlayer.isCollidedHorizontally && (mc.thePlayer.getFoodStats().getFoodLevel() > 6 || mc.thePlayer.capabilities.isFlying)) {
                mc.thePlayer.setSprinting(true);
            }
        }
    }
}

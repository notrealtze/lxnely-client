package com.lxnely.client;

import com.lxnely.client.config.ClientConfig;
import com.lxnely.client.gui.ClickGuiScreen;
import com.lxnely.client.modules.WTFImprovements;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = LxnelyClient.MODID, version = LxnelyClient.VERSION, name = LxnelyClient.NAME, acceptedMinecraftVersions = "1.8.9")
public class LxnelyClient {
    public static final String MODID = "lxnelyclient";
    public static final String VERSION = "1.0.0";
    public static final String NAME = "Lxnely Client";

    @Mod.Instance(MODID)
    public static LxnelyClient instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ClientConfig.init(event.getSuggestedConfigurationFile());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new WTFImprovements());
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_RSHIFT) {
            if (Minecraft.getMinecraft().currentScreen == null) {
                Minecraft.getMinecraft().displayGuiScreen(new ClickGuiScreen());
            }
        }
    }
}

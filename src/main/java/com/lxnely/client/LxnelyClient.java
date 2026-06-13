package com.lxnely.client;

import com.lxnely.client.config.ClientConfig;
import com.lxnely.client.modules.WTFImprovements;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
    }
}

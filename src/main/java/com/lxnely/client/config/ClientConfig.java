package com.lxnely.client.config;

import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ClientConfig {
    public static boolean showFPS;
    public static boolean smoothLighting;
    public static int renderDistance;

    public static void init(File file) {
        Configuration cfg = new Configuration(file);
        cfg.load();
        showFPS = cfg.getBoolean("showFPS", "wtf", true, "");
        smoothLighting = cfg.getBoolean("smoothLighting", "wtf", true, "");
        renderDistance = cfg.getInt("renderDistance", "wtf", 8, 2, 16, "");
        if (cfg.hasChanged()) cfg.save();
    }
}

package com.lxnely.client.config;

import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ClientConfig {
    public static boolean toggleSprint = true;
    public static boolean showKeystrokes = true;
    public static boolean showFPS = true;

    public static void init(File file) {
        Configuration cfg = new Configuration(file);
        cfg.load();
        toggleSprint = cfg.getBoolean("toggleSprint", "Movement", true, "");
        showKeystrokes = cfg.getBoolean("showKeystrokes", "Visuals", true, "");
        showFPS = cfg.getBoolean("showFPS", "Visuals", true, "");
        if (cfg.hasChanged()) cfg.save();
    }
}

package com.thestone.anubis;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Anubis implements ModInitializer {
    public static String MOD_ID = "anubis";
    public static final Logger LOGGER = LoggerFactory.getLogger("anubis");

    @Override
    public void onInitialize() {
    }


    public static String getModId() {
        return MOD_ID;
    }
}

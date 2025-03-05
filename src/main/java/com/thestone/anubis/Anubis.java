package com.thestone.anubis;

import com.thestone.anubis.entity.AnubisEntity;
import com.thestone.anubis.main.ModEntities;
import com.thestone.anubis.main.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Anubis implements ModInitializer {
    public static String MOD_ID = "anubis";
    public static final Logger LOGGER = LoggerFactory.getLogger("anubis");

    @Override
    public void onInitialize() {
        ModItems.registerModItems();






        FabricDefaultAttributeRegistry.register(ModEntities.ANUBIS_ENTITY, AnubisEntity.createAttributes());
    }



}

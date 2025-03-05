package com.thestone.anubis;

import com.thestone.anubis.client.renderer.AnubisRenderer;
import com.thestone.anubis.main.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class AnubisClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.ANUBIS_ENTITY, AnubisRenderer::new);
    }
}

package com.thestone.anubis;

import com.thestone.anubis.client.gui.CustomBossBar;
import com.thestone.anubis.client.renderer.AnubisRenderer;
import com.thestone.anubis.entity.AnubisEntity;
import com.thestone.anubis.main.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;

public class AnubisClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        HudRenderCallback.EVENT.register(new CustomBossBar());
        EntityRendererRegistry.register(ModEntities.ANUBIS_ENTITY, AnubisRenderer::new);

    }




}

package com.thestone.anubis.client.gui;

import com.thestone.anubis.Anubis;
import com.thestone.anubis.entity.AnubisEntity;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;


public class CustomBossBar implements HudRenderCallback {
    private static final Identifier BAR_TEXTURE = new Identifier(Anubis.MOD_ID, "textures/gui/anubis_bar.png");


    @Override
    public void onHudRender(DrawContext context, float v) {
        MinecraftClient client = MinecraftClient.getInstance();
        Entity targetEntity = client.targetedEntity;
        if (targetEntity instanceof AnubisEntity a) {
            if (a.getHealth() > 0.01) {
                int i = context.getScaledWindowWidth();
                int k = i / 2 - 127;
                int j = -2;
                context.drawTexture(BAR_TEXTURE, k, j, 0, 80, 256, 64, 256, 64);
            }
        }
    }

    private boolean hasBossBar(EntityType<?> entityType) {
        return true;
    }

}









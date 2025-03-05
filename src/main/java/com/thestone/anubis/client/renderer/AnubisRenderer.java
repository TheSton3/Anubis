package com.thestone.anubis.client.renderer;

import com.thestone.anubis.client.models.AnubisModel;
import com.thestone.anubis.entity.AnubisEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AnubisRenderer extends GeoEntityRenderer<AnubisEntity> {
    public AnubisRenderer(EntityRendererFactory.Context context) {
        super(context, new AnubisModel());
    }
}

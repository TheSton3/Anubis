package com.thestone.anubis.client.models;

import com.thestone.anubis.Anubis;
import com.thestone.anubis.entity.AnubisEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class AnubisModel extends DefaultedEntityGeoModel<AnubisEntity>{

    public AnubisModel() {
        super(new Identifier(Anubis.MOD_ID, "anubis"));
    }
}

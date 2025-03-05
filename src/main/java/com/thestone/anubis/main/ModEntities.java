package com.thestone.anubis.main;

import com.thestone.anubis.Anubis;
import com.thestone.anubis.entity.AnubisEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<AnubisEntity> ANUBIS_ENTITY = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Anubis.MOD_ID, "anubis"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AnubisEntity::new)
                    .dimensions(EntityDimensions.fixed(2.0f, 5.45f)).build());
}

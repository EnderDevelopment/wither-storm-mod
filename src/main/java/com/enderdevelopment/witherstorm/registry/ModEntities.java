package com.enderdevelopment.witherstorm.registry;

import com.enderdevelopment.witherstorm.WitherStormMod;
import com.enderdevelopment.witherstorm.entity.WitherStormEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<WitherStormEntity> WITHER_STORM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(WitherStormMod.MOD_ID, "wither_storm"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WitherStormEntity::new)
                    .dimensions(EntityDimensions.fixed(3.0f, 6.0f))
                    .build()
    );

    public static void registerModEntities() {
        WitherStormMod.LOGGER.info("Registering Mod Entities for " + WitherStormMod.MOD_ID);
    }
}
package com.enderdevelopment.witherstorm.registry;

import com.enderdevelopment.witherstorm.WitherStormMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final DefaultParticleType WITHER_STORM_GRAB_PARTICLE = registerParticle("wither_storm_grab_particle");
    public static final DefaultParticleType WITHER_STORM_SLAP_PARTICLE = registerParticle("wither_storm_slap_particle");
    public static final DefaultParticleType WITHER_STORM_SLAM_PARTICLE = registerParticle("wither_storm_slam_particle");
    public static final DefaultParticleType WITHER_STORM_CRUSH_PARTICLE = registerParticle("wither_storm_crush_particle");
    public static final DefaultParticleType WITHER_STORM_EAT_PARTICLE = registerParticle("wither_storm_eat_particle");

    private static DefaultParticleType registerParticle(String name) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(WitherStormMod.MOD_ID, name),
                FabricParticleTypes.simple());
    }

    public static void registerModParticles() {
        WitherStormMod.LOGGER.info("Registering Mod Particles for " + WitherStormMod.MOD_ID);
    }
}
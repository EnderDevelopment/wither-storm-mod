package com.enderdevelopment.witherstorm.ability;

import com.enderdevelopment.witherstorm.entity.WitherStormEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;

public class WitherStormAbilities {
    public static void grabPlayer(WitherStormEntity witherStorm, PlayerEntity target) {
        // Implementation for Grab Player ability
        if (witherStorm.getWorld() instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(ModParticles.WITHER_STORM_GRAB_PARTICLE, target.getX(), target.getY(), target.getZ(), 20, 0.5, 0.5, 0.5, 0.1);
            witherStorm.playSound(ModSounds.WITHER_STORM_GRAB, 1.0F, 1.0F);
        }
    }

    public static void tentacleSlap(WitherStormEntity witherStorm, PlayerEntity target) {
        // Implementation for Tentacle Slap ability
        if (witherStorm.getWorld() instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(ModParticles.WITHER_STORM_SLAP_PARTICLE, target.getX(), target.getY(), target.getZ(), 30, 0.5, 0.5, 0.5, 0.1);
            witherStorm.playSound(ModSounds.WITHER_STORM_SLAP, 1.0F, 1.0F);
        }
    }

    public static void groundSlam(WitherStormEntity witherStorm) {
        // Implementation for Ground Slam ability
        if (witherStorm.getWorld() instanceof ServerWorld serverWorld) {
            Vec3d pos = witherStorm.getPos();
            serverWorld.spawnParticles(ModParticles.WITHER_STORM_SLAM_PARTICLE, pos.x, pos.y, pos.z, 50, 2.0, 0.5, 2.0, 0.1);
            witherStorm.playSound(ModSounds.WITHER_STORM_SLAM, 1.0F, 1.0F);
        }
    }

    public static void playerCrushing(WitherStormEntity witherStorm, PlayerEntity target) {
        // Implementation for Player Crushing ability
        if (witherStorm.getWorld() instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(ModParticles.WITHER_STORM_CRUSH_PARTICLE, target.getX(), target.getY(), target.getZ(), 40, 0.5, 0.5, 0.5, 0.1);
            witherStorm.playSound(ModSounds.WITHER_STORM_CRUSH, 1.0F, 1.0F);
        }
    }

    public static void eatPlayer(WitherStormEntity witherStorm, PlayerEntity target) {
        // Implementation for Eat Player ability
        if (witherStorm.getWorld() instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(ModParticles.WITHER_STORM_EAT_PARTICLE, target.getX(), target.getY(), target.getZ(), 30, 0.5, 0.5, 0.5, 0.1);
            witherStorm.playSound(ModSounds.WITHER_STORM_EAT, 1.0F, 1.0F);
        }
    }
}
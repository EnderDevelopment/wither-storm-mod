package com.enderdevelopment.witherstorm.registry;

import com.enderdevelopment.witherstorm.WitherStormMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent WITHER_STORM_GRAB = registerSoundEvent("wither_storm_grab");
    public static final SoundEvent WITHER_STORM_SLAP = registerSoundEvent("wither_storm_slap");
    public static final SoundEvent WITHER_STORM_SLAM = registerSoundEvent("wither_storm_slam");
    public static final SoundEvent WITHER_STORM_CRUSH = registerSoundEvent("wither_storm_crush");
    public static final SoundEvent WITHER_STORM_EAT = registerSoundEvent("wither_storm_eat");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(WitherStormMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds() {
        WitherStormMod.LOGGER.info("Registering Mod Sounds for " + WitherStormMod.MOD_ID);
    }
}
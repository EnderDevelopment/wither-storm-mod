package com.enderdevelopment.witherstorm;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WitherStormMod implements ModInitializer {
    public static final String MOD_ID = "wither_storm";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Wither Storm Mod");
        ModEntities.registerModEntities();
        ModScreenHandlers.registerModScreenHandlers();
        ModSounds.registerModSounds();
        ModParticles.registerModParticles();
    }
}
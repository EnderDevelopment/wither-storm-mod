package com.enderdevelopment.witherstorm.registry;

import com.enderdevelopment.witherstorm.WitherStormMod;
import com.enderdevelopment.witherstorm.gui.WitherStormScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<WitherStormScreenHandler> WITHER_STORM_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(WitherStormMod.MOD_ID, "wither_storm"),
                    new ExtendedScreenHandlerType<>(WitherStormScreenHandler::new));

    public static void registerModScreenHandlers() {
        WitherStormMod.LOGGER.info("Registering Mod Screen Handlers for " + WitherStormMod.MOD_ID);
    }
}
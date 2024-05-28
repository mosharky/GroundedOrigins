package com.momo.grounded_origins;

import com.momo.grounded_origins.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;

public class GroundedOriginsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        handleRegistration();
        // GroundedOrigins.LOG.info("Hello Fabric world!");
        GroundedOrigins.init();
    }

    public static void handleRegistration() {
        ModItems.registerItems(Registry::register);
    }
}

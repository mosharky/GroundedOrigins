package com.momo.grounded_origins;

import com.momo.grounded_origins.platform.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroundedOrigins {

    public static final String MOD_ID = "grounded_origins";
    public static final String MOD_NAME = "Grounded Origins";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        // LOG.info("Hello from Common init on {}! we are currently in a {} environment!", Services.PLATFORM.getPlatformName(), Services.PLATFORM.getEnvironmentName());
        // LOG.info("The ID for diamonds is {}", BuiltInRegistries.ITEM.getKey(Items.DIAMOND));

        if (Services.PLATFORM.isModLoaded("grounded_origins")) {
            LOG.info("Hello to grounded_origins");
        }
    }
}
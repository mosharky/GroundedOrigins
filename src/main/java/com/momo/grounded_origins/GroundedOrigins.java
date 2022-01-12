package com.momo.grounded_origins;

import com.momo.grounded_origins.item.ModItems;
import com.momo.grounded_origins.util.ModSoundEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GroundedOrigins.MOD_ID)
public class GroundedOrigins
{
    public static final String MOD_ID = "grounded_origins";
    public static final String MOD_NAME = "OriginsPowerExpansion";
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    public GroundedOrigins() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModSoundEvents.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

}

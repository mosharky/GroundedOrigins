package momo.grounded_origins;

import momo.grounded_origins.registry.Icons;
import momo.grounded_origins.registry.RaveSound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GroundedOrigins.MOD_ID)
public class GroundedOrigins
{
    public static final String MOD_ID = "grounded_origins";

    public GroundedOrigins() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Icons.register(eventBus);
        RaveSound.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

}

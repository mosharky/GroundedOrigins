package momo.grounded_origins;

import momo.grounded_origins.registry.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GroundedOrigins.MOD_ID)
public class GroundedOrigins {
    public static final String MOD_ID = "grounded_origins";

    public GroundedOrigins() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.init(eventBus);
        ModPowers.init(eventBus);
        ModEntityConditions.init(eventBus);
        RaveSound.init(eventBus);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ModKeybinds::init);

        MinecraftForge.EVENT_BUS.register(this);
    }
}

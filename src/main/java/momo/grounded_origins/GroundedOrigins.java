package momo.grounded_origins;

import momo.grounded_origins.data.GOBlockTagsProvider;
import momo.grounded_origins.data.GOPowerGenerator;
import momo.grounded_origins.registry.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

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
        eventBus.addListener(this::dataGen);
    }

    private void dataGen(GatherDataEvent event) {
        if (event.includeServer()) {
            event.getGenerator().addProvider(new GOBlockTagsProvider(event.getGenerator(), event.getExistingFileHelper()));
            event.getGenerator().addProvider(new GOPowerGenerator(event.getGenerator(), event.getExistingFileHelper()));
        }
    }
}

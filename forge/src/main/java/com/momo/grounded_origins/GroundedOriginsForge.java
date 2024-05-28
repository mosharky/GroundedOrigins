package com.momo.grounded_origins;

import com.momo.grounded_origins.registry.ModItems;
import com.momo.grounded_origins.registry.RegistrationCallback;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

import java.util.function.Consumer;

@Mod(GroundedOrigins.MOD_ID)
public class GroundedOriginsForge {

    @Mod.EventBusSubscriber(modid = GroundedOrigins.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModBusEvents {

        @SubscribeEvent
        public static void registerContent(RegisterEvent event)
        {
            if (event.getRegistryKey() == Registries.ITEM) register(event, ModItems::registerItems);
        }

        private static <T> void register(RegisterEvent event, Consumer<RegistrationCallback<T>> consumer) {
            consumer.accept((registry, id, value) -> event.register(registry.key(), id, () -> value));
        }
    }

    public GroundedOriginsForge() {
        // GroundedOrigins.LOG.info("Hello Forge world!");
        GroundedOrigins.init();
    }
}
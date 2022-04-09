package momo.grounded_origins.registry;

import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import io.github.edwinmindcraft.apoli.api.registry.ApoliRegistries;
import momo.grounded_origins.GroundedOrigins;
import momo.grounded_origins.power.CubeCheckPowerForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPowers {
	public static final DeferredRegister<PowerFactory<?>> POWER_FACTORIES = DeferredRegister.create(ApoliRegistries.POWER_FACTORY_CLASS, GroundedOrigins.MOD_ID);
	public static final RegistryObject<CubeCheckPowerForge> CUBE_CHECK = POWER_FACTORIES.register("cube_check", CubeCheckPowerForge::new);

	public static void init(IEventBus eventBus) {
		POWER_FACTORIES.register(eventBus);
	}
}

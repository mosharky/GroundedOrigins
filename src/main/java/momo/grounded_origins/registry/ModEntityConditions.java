package momo.grounded_origins.registry;

import io.github.edwinmindcraft.apoli.api.power.factory.EntityCondition;
import io.github.edwinmindcraft.apoli.api.registry.ApoliRegistries;
import momo.grounded_origins.GroundedOrigins;
import momo.grounded_origins.power.CubeCheckConditionForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityConditions {

	public static final DeferredRegister<EntityCondition<?>> ENTITY_CONDITIONS = DeferredRegister.create(ApoliRegistries.ENTITY_CONDITION_CLASS, GroundedOrigins.MOD_ID);
	public static final RegistryObject<CubeCheckConditionForge> CUBE_CHECK = ENTITY_CONDITIONS.register("cube_check", CubeCheckConditionForge::new);

	public static void init(IEventBus eventBus) {
		ENTITY_CONDITIONS.register(eventBus);
	}
}

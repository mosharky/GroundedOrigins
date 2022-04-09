package momo.grounded_origins.registry;

import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import momo.grounded_origins.GroundedOrigins;
import momo.grounded_origins.power.CubeCheckConditionFabric;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Function;

public class ModEntityConditions {

	public static final ConditionFactory<Entity> CUBE_CHECK = register("cube_check", CubeCheckConditionFabric::factory);

	public static void init() {
	}

	private static ConditionFactory<Entity> register(String name, Function<Identifier, ConditionFactory<Entity>> factory) {
		Identifier identifier = new Identifier(GroundedOrigins.MOD_ID, name);
		return Registry.register(ApoliRegistries.ENTITY_CONDITION, identifier, factory.apply(identifier));
	}
}

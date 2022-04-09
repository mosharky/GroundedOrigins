package momo.grounded_origins.registry;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import momo.grounded_origins.GroundedOrigins;
import momo.grounded_origins.power.CubeCheckPowerFabric;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Function;

public class ModPowers {
	public static final PowerFactory<CubeCheckPowerFabric> CUBE_CHECK = register("cube_check", CubeCheckPowerFabric::factory);

	public static void init() {}

	private static <T extends Power> PowerFactory<T> register(String name, Function<Identifier, PowerFactory<T>> factory) {
		Identifier identifier = new Identifier(GroundedOrigins.MOD_ID, name);
		return Registry.register(ApoliRegistries.POWER_FACTORY, identifier, factory.apply(identifier));
	}
}

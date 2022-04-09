package momo.grounded_origins.power;

import io.github.apace100.apoli.component.PowerHolderComponent;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerTypeReference;
import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import momo.grounded_origins.configuration.CubeCheckConditionConfiguration;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

import java.util.function.Predicate;

public class CubeCheckConditionFabric implements Predicate<Entity> {
	private final CubeCheckConditionConfiguration configuration;

	public CubeCheckConditionFabric(CubeCheckConditionConfiguration configuration) {
		this.configuration = configuration;
	}

	@Override
	public boolean test(Entity entity) {
		PowerHolderComponent component = PowerHolderComponent.KEY.getNullable(entity);
		if (component == null)
			return false;
		PowerTypeReference<Power> ref = new PowerTypeReference<>(this.configuration.power());
		Power power = component.getPower(ref);
		if (power instanceof CubeCheckPowerFabric ccp)
			return ccp.check(this.configuration.name(), this.configuration.range());
		//DistanceFromCoordinatesConditionRegistry.warnOnce("Entity %s doesn't have the %s power".formatted(entity.getName().getString(), this.configuration.power()));
		return false;
	}

	public static ConditionFactory<Entity> factory(Identifier identifier) {
		return new ConditionFactory<>(identifier, CubeCheckConditionConfiguration.SERIALIZABLE_DATA, (instance, entity) -> new CubeCheckConditionFabric(CubeCheckConditionConfiguration.fromInstance(instance)).test(entity));
	}
}

package momo.grounded_origins.power;

import io.github.apace100.apoli.power.factory.condition.DistanceFromCoordinatesConditionRegistry;
import io.github.edwinmindcraft.apoli.api.component.IPowerContainer;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredPower;
import io.github.edwinmindcraft.apoli.api.power.factory.EntityCondition;
import momo.grounded_origins.configuration.CubeCheckConditionConfiguration;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

public class CubeCheckConditionForge extends EntityCondition<CubeCheckConditionConfiguration> {
	public CubeCheckConditionForge() {
		super(CubeCheckConditionConfiguration.SERIALIZABLE_DATA.xmap(CubeCheckConditionConfiguration::fromInstance, CubeCheckConditionConfiguration::toInstance).codec());
	}

	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
	protected boolean check(@NotNull CubeCheckConditionConfiguration configuration, @NotNull Entity entity) {
		LazyOptional<IPowerContainer> containerLazyOptional = IPowerContainer.get(entity);
		if (!containerLazyOptional.isPresent())
			return false;
		IPowerContainer container = containerLazyOptional.orElseThrow(RuntimeException::new);
		ConfiguredPower power = container.getPower(configuration.power());
		if (power != null && power.getFactory() instanceof CubeCheckPowerForge ccp)
			return ccp.check(power, entity, configuration.name(), configuration.range());
		DistanceFromCoordinatesConditionRegistry.warnOnce("Entity %s doesn't have the %s power".formatted(entity.getName().getString(), configuration.power()));
		return false;
	}
}

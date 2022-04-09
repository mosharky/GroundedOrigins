package momo.grounded_origins.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import momo.grounded_origins.configuration.CubeCheckCache;
import momo.grounded_origins.configuration.CubeCheckConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class CubeCheckPowerFabric extends Power {
	private final CubeCheckConfiguration configuration;
	private final CubeCheckCache cache;

	public CubeCheckPowerFabric(PowerType<?> type, LivingEntity entity, CubeCheckConfiguration configuration) {
		super(type, entity);
		this.configuration = configuration;
		this.cache = new CubeCheckCache(this.configuration);
	}

	@Override
	public void tick() {
		if (this.entity.tickCount % this.configuration.tickInterval() == 0)
			this.cache.updateCache(this.entity.getLevel(), this.entity.blockPosition());
	}

	public static PowerFactory<CubeCheckPowerFabric> factory(ResourceLocation id) {
		return new PowerFactory<>(id, CubeCheckConfiguration.SERIALIZABLE_DATA, instance -> {
			CubeCheckConfiguration config = CubeCheckConfiguration.fromInstance(instance);
			return (type, living) -> new CubeCheckPowerFabric(type, living, config);
		});
	}

	public void invalidate(BlockPos pos) {
		this.cache.invalidate(pos);
	}
}

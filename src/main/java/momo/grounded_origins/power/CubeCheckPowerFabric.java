package momo.grounded_origins.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import momo.grounded_origins.configuration.CubeCheckCache;
import momo.grounded_origins.configuration.CubeCheckConfiguration;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class CubeCheckPowerFabric extends Power {
	private final CubeCheckConfiguration configuration;
	private final CubeCheckCache cache;

	public CubeCheckPowerFabric(PowerType<?> type, LivingEntity entity, CubeCheckConfiguration configuration) {
		super(type, entity);
		this.configuration = configuration;
		this.cache = new CubeCheckCache(this.configuration);
		this.setTicking();
	}

	@Override
	public void tick() {
		if (this.entity.age % this.configuration.tickInterval() == 0)
			this.cache.updateCache(this.entity.getWorld(), this.entity.getBlockPos());
	}

	public static PowerFactory<CubeCheckPowerFabric> factory(Identifier id) {
		return new PowerFactory<>(id, CubeCheckConfiguration.SERIALIZABLE_DATA, instance -> {
			CubeCheckConfiguration config = CubeCheckConfiguration.fromInstance(instance);
			return (type, living) -> new CubeCheckPowerFabric(type, living, config);
		});
	}

	public void invalidate(BlockPos pos) {
		this.cache.invalidate(pos);
	}

	public boolean check(String name, int range) {
		return this.cache.check(name, range);
	}
}

package momo.grounded_origins.power;

import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredPower;
import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import momo.grounded_origins.configuration.CubeCheckCache;
import momo.grounded_origins.configuration.CubeCheckConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class CubeCheckPowerForge extends PowerFactory<CubeCheckConfiguration> {
	public CubeCheckPowerForge() {
		super(CubeCheckConfiguration.SERIALIZABLE_DATA.xmap(CubeCheckConfiguration::fromInstance, CubeCheckConfiguration::toInstance).codec(), false);
		this.ticking();
	}

	@Override
	protected int tickInterval(@NotNull CubeCheckConfiguration configuration, @NotNull Entity entity) {
		return configuration.tickInterval();
	}

	@NotNull
	private CubeCheckCache getCache(@NotNull ConfiguredPower<CubeCheckConfiguration, ?> configuration, @NotNull Entity entity) {
		return configuration.getPowerData(entity, () -> new CubeCheckCache(configuration.getConfiguration()));
	}

	@Override
	public void tick(@NotNull ConfiguredPower<CubeCheckConfiguration, ?> configuration, @NotNull Entity entity) {
		this.getCache(configuration, entity).updateCache(entity.getLevel(), entity.blockPosition());
	}

	public void invalidate(@NotNull ConfiguredPower<CubeCheckConfiguration, ?> configuration, @NotNull Entity entity, BlockPos pos) {
		this.getCache(configuration, entity).invalidate(pos);
	}

	public boolean check(@NotNull ConfiguredPower<CubeCheckConfiguration, ?> configuration, @NotNull Entity entity, String name, int range) {
		return this.getCache(configuration, entity).check(name, range);
	}
}

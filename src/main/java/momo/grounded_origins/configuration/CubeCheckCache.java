package momo.grounded_origins.configuration;

import io.github.apace100.apoli.component.PowerHolderComponent;
import momo.grounded_origins.power.CubeCheckPowerFabric;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CubeCheckCache {
	public static void invalidate(Entity entity, BlockPos pos) {
		PowerHolderComponent.getPowers(entity, CubeCheckPowerFabric.class).forEach(x -> x.invalidate(pos));
	}

	private final CubeCheckConfiguration config;
	private final Set<BlockPos>[] currentCache;
	private int lX;
	private int lY;
	private int lZ;
	private int uX;
	private int uY;
	private int uZ;
	private final Set<BlockPos> dirty = new HashSet<>();

	public CubeCheckCache(CubeCheckConfiguration config) {
		this.config = config;
		this.currentCache = new Set[this.config.entries().size()];
		for (int i = 0; i < this.currentCache.length; i++)
			this.currentCache[i] = new HashSet<>();
	}

	public void updateCache(World level, BlockPos root) {
		int xStart = root.getX() - this.config.radius();
		int yStart = root.getY() - this.config.radius();
		int zStart = root.getZ() - this.config.radius();
		int xEnd = root.getX() + this.config.radius();
		int yEnd = root.getY() + this.config.radius();
		int zEnd = root.getZ() + this.config.radius();
		BlockPos.Mutable mbp = new BlockPos.Mutable();
		for (int x = xStart; x <= xEnd; ++x) {
			for (int y = yStart; y <= yEnd; ++y) {
				for (int z = zStart; z <= zEnd; ++z) {
					if (x >= this.lX && x <= this.uX &&
						y >= this.lY && y <= this.uY &&
						z >= this.lZ && z <= this.uZ) continue;
					mbp.set(x, y, z);
					this.applyChecks(level.getBlockState(mbp), mbp);
				}
			}
		}
		for (BlockPos pos : this.dirty)
			this.applyChecks(level.getBlockState(pos), pos);
		this.dirty.clear();
		this.lX = xStart;
		this.lY = yStart;
		this.lZ = zStart;
		this.uX = xEnd;
		this.uY = yEnd;
		this.uZ = zEnd;
		for (Set<BlockPos> set : this.currentCache)
			set.removeIf(this::isOutside);
	}

	private boolean isOutside(BlockPos pos) {
		return pos.getX() < this.lX || pos.getX() > this.uX ||
			   pos.getY() < this.lY || pos.getY() > this.uY ||
			   pos.getZ() < this.lZ || pos.getZ() > this.uX;
	}

	private boolean isWithin(BlockPos pos, int range) {
		int cX = (this.lX + this.uX) / 2;
		int cY = (this.lY + this.uY) / 2;
		int cZ = (this.lZ + this.uZ) / 2;
		return pos.getX() >= (cX - range) && pos.getX() <= (cX + range) &&
			   pos.getY() >= (cY - range) && pos.getY() <= (cY + range) &&
			   pos.getZ() >= (cZ - range) && pos.getZ() <= (cZ + range);
	}

	private void applyChecks(BlockState state, BlockPos pos) {
		for (int i = 0; i < this.config.entries().size(); i++) {
			CubeCheckConfiguration.Entry entry = this.config.entries().get(i);
			if (state.isIn(entry.tag()))
				this.currentCache[i].add(pos.toImmutable());
			else
				this.currentCache[i].remove(pos.toImmutable());
		}
	}

	public void invalidate(BlockPos pos) {
		this.dirty.add(pos.toImmutable());
	}

	public boolean check(String name, int range) {
		int index = -1;
		for (int i = 0; i < this.config.entries().size(); i++) {
			if (Objects.equals(this.config.entries().get(i).name(), name)) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			try {
				index = Integer.parseInt(name, 10);
			} catch (NumberFormatException nfe) {
				return false;
			}
		}
		if (index < 0 || index >= this.config.entries().size())
			return false;
		CubeCheckConfiguration.Entry entry = this.config.entries().get(index);
		if (range <= 0)
			return entry.comparison().compare(this.currentCache[index].size(), entry.compareTo());
		int count = (int) this.currentCache[index].stream().filter(x -> this.isWithin(x, range)).count();
		return entry.comparison().compare(count, entry.compareTo());
	}
}

package momo.grounded_origins.configuration;

import com.google.common.collect.ImmutableSet;
import io.github.apace100.origins.Origins;
import io.github.edwinmindcraft.apoli.api.component.IPowerContainer;
import momo.grounded_origins.registry.ModPowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CauldronBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CubeCheckCache {
	public static void invalidate(Entity entity, BlockPos pos) {
		IPowerContainer.getPowers(entity, ModPowers.CUBE_CHECK.get()).forEach(x -> x.getFactory().invalidate(x, entity, pos));
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

	public void updateCache(Level level, BlockPos root) {
		int xStart = root.getX() - this.config.radius();
		int yStart = root.getY() - this.config.radius();
		int zStart = root.getZ() - this.config.radius();
		int xEnd = root.getX() + this.config.radius();
		int yEnd = root.getY() + this.config.radius();
		int zEnd = root.getZ() + this.config.radius();
		BlockPos.MutableBlockPos mbp = new BlockPos.MutableBlockPos();
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
		Origins.LOGGER.info("Cube Check Cache update status: {}", IntStream.range(0, this.currentCache.length).mapToObj(x -> this.config.entries().get(x).name() + ": " + this.currentCache[x].size()).collect(Collectors.joining(",")));
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
			if (state.m_60620_(entry.tag()))
				this.currentCache[i].add(pos.immutable());
			else
				this.currentCache[i].remove(pos.immutable());
		}
	}

	public void invalidate(BlockPos pos) {
		this.dirty.add(pos.immutable());
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

package momo.grounded_origins.mixin;

import momo.grounded_origins.configuration.CubeCheckCache;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.LevelEntityGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Level.class)
public abstract class LevelMixin {

	@Shadow
	protected abstract LevelEntityGetter<Entity> getEntities();

	@Inject(method = "setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", at = @At("RETURN"))
	public void invalidateCaches(BlockPos pPos, BlockState pNewState, int pFlags, CallbackInfoReturnable<Boolean> cir) {
		if (cir.getReturnValueZ()) {
			for (Entity entity : this.getEntities().getAll())
				CubeCheckCache.invalidate(entity, pPos);
		}
	}
}

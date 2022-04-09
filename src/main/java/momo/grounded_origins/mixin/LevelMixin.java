package momo.grounded_origins.mixin;

import momo.grounded_origins.configuration.CubeCheckCache;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.entity.EntityLookup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public abstract class LevelMixin {

	@Shadow
	protected abstract EntityLookup<Entity> getEntityLookup();

	@Inject(method = "setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;II)Z", at = @At("RETURN"))
	public void invalidateCaches(BlockPos pos, BlockState state, int flags, int maxUpdateDepth, CallbackInfoReturnable<Boolean> cir) {
		if (cir.getReturnValueZ()) {
			for (Entity entity : this.getEntityLookup().iterate())
				CubeCheckCache.invalidate(entity, pos);
		}
	}
}

package momo.grounded_origins.data;

import momo.grounded_origins.GroundedOrigins;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public class GOBlockTags {
	public static IOptionalNamedTag<Block> create(String name) {
		return BlockTags.createOptional(new ResourceLocation(GroundedOrigins.MOD_ID, name));
	}

	public static final IOptionalNamedTag<Block> MOTH_GLOWSTONE_LIGHTS = create("moth/glowstone_lights");
	public static final IOptionalNamedTag<Block> MOTH_LANTERNS = create("moth/lanterns");
	public static final IOptionalNamedTag<Block> MOTH_PUMPKIN_LIGHTS = create("moth/pumpkin_lights");
	public static final IOptionalNamedTag<Block> MOTH_SEA_LIGHTS = create("moth/sea_lights");
	public static final IOptionalNamedTag<Block> MOTH_SOUL_LIGHTS = create("moth/soul_lights");
	public static final IOptionalNamedTag<Block> MOTH_SPORE_BLOSSOM = create("moth/spore_blossom");
}

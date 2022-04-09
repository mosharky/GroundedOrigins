package momo.grounded_origins.data;

import momo.grounded_origins.GroundedOrigins;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class GOBlockTagsProvider extends BlockTagsProvider {
	public GOBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
		super(pGenerator, GroundedOrigins.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.m_126548_(GOBlockTags.MOTH_GLOWSTONE_LIGHTS).add(Blocks.GLOWSTONE, Blocks.SHROOMLIGHT);
		this.m_126548_(GOBlockTags.MOTH_LANTERNS).add(Blocks.LANTERN, Blocks.REDSTONE_LAMP);
		this.m_126548_(GOBlockTags.MOTH_PUMPKIN_LIGHTS).add(Blocks.JACK_O_LANTERN);
		this.m_126548_(GOBlockTags.MOTH_SEA_LIGHTS).add(Blocks.SEA_LANTERN);
		this.m_126548_(GOBlockTags.MOTH_SOUL_LIGHTS).add(Blocks.SOUL_LANTERN, Blocks.SOUL_TORCH, Blocks.SOUL_CAMPFIRE);
		this.m_126548_(GOBlockTags.MOTH_SPORE_BLOSSOM).add(Blocks.SPORE_BLOSSOM);
	}
}

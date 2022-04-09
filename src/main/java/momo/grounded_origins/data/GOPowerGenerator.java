package momo.grounded_origins.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.github.apace100.apoli.util.Comparison;
import io.github.apace100.apoli.util.HudRender;
import io.github.edwinmindcraft.apoli.api.configuration.FieldConfiguration;
import io.github.edwinmindcraft.apoli.api.configuration.ListConfiguration;
import io.github.edwinmindcraft.apoli.api.configuration.NoConfiguration;
import io.github.edwinmindcraft.apoli.api.generator.PowerGenerator;
import io.github.edwinmindcraft.apoli.api.power.ConditionData;
import io.github.edwinmindcraft.apoli.api.power.IActivePower;
import io.github.edwinmindcraft.apoli.api.power.PowerData;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredEntityAction;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredEntityCondition;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredPower;
import io.github.edwinmindcraft.apoli.common.action.configuration.OffsetConfiguration;
import io.github.edwinmindcraft.apoli.common.action.meta.StreamConfiguration;
import io.github.edwinmindcraft.apoli.common.condition.configuration.BiomeConfiguration;
import io.github.edwinmindcraft.apoli.common.power.configuration.ActiveSelfConfiguration;
import io.github.edwinmindcraft.apoli.common.power.configuration.MultipleConfiguration;
import io.github.edwinmindcraft.apoli.common.power.configuration.StackingStatusEffectConfiguration;
import io.github.edwinmindcraft.apoli.common.registry.ApoliPowers;
import io.github.edwinmindcraft.apoli.common.registry.action.ApoliBlockActions;
import io.github.edwinmindcraft.apoli.common.registry.action.ApoliEntityActions;
import io.github.edwinmindcraft.apoli.common.registry.condition.ApoliEntityConditions;
import momo.grounded_origins.GroundedOrigins;
import momo.grounded_origins.configuration.CubeCheckConditionConfiguration;
import momo.grounded_origins.configuration.CubeCheckConfiguration;
import momo.grounded_origins.registry.ModEntityConditions;
import momo.grounded_origins.registry.ModPowers;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Map;

public class GOPowerGenerator extends PowerGenerator {
	public GOPowerGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, GroundedOrigins.MOD_ID, existingFileHelper);
	}

	@Override
	protected void populate() {
		this.add("moth/block_lookup", ModPowers.CUBE_CHECK.get().configure(new CubeCheckConfiguration(20, ImmutableList.of(
				new CubeCheckConfiguration.Entry("lanterns", GOBlockTags.MOTH_LANTERNS, Comparison.GREATER_THAN_OR_EQUAL, 1),
				new CubeCheckConfiguration.Entry("glowstone_lights", GOBlockTags.MOTH_GLOWSTONE_LIGHTS, Comparison.GREATER_THAN_OR_EQUAL, 1),
				new CubeCheckConfiguration.Entry("pumpkin_lights", GOBlockTags.MOTH_PUMPKIN_LIGHTS, Comparison.GREATER_THAN_OR_EQUAL, 1),
				new CubeCheckConfiguration.Entry("soul_lights", GOBlockTags.MOTH_SOUL_LIGHTS, Comparison.GREATER_THAN_OR_EQUAL, 1),
				new CubeCheckConfiguration.Entry("sea_lights", GOBlockTags.MOTH_SEA_LIGHTS, Comparison.GREATER_THAN_OR_EQUAL, 1),
				new CubeCheckConfiguration.Entry("flowers", BlockTags.FLOWERS, Comparison.GREATER_THAN_OR_EQUAL, 15),
				new CubeCheckConfiguration.Entry("spore_blossom", GOBlockTags.MOTH_SPORE_BLOSSOM, Comparison.GREATER_THAN_OR_EQUAL, 1)
		), 20), PowerData.DEFAULT));
		this.add("moth/phototactic", ApoliPowers.MULTIPLE.get().configure(new MultipleConfiguration<>(ImmutableMap.of(
				"lanterns_buff", makeEntry("lanterns", new MobEffectInstance(MobEffects.REGENERATION, 100, 0, true, false, false)),
				"glowstones_buff", makeEntry("glowstone_lights", new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 0, true, false, false)),
				"pumpkins_buff", makeEntry("pumpkin_lights", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0, true, false, false)),
				"souls_buff", makeEntry("soul_lights", new MobEffectInstance(MobEffects.DIG_SPEED, 100, 0, true, false, false)),
				"sea_buff", makeEntry("sea_lights", new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100, 0, true, false, false))
		)), PowerData.DEFAULT));
		this.add("moth/pollenator", ApoliPowers.MULTIPLE.get().configure(new MultipleConfiguration<>(makePollenator()), PowerData.DEFAULT));
	}

	private static Map<String, ConfiguredPower<?, ?>> makePollenator() {
		ConfiguredEntityCondition<?, ?> flowers = ApoliEntityConditions.or(
				ModEntityConditions.CUBE_CHECK.get().configure(new CubeCheckConditionConfiguration(new ResourceLocation(GroundedOrigins.MOD_ID, "moth/block_lookup"), "flowers", -1)),
				ModEntityConditions.CUBE_CHECK.get().configure(new CubeCheckConditionConfiguration(new ResourceLocation(GroundedOrigins.MOD_ID, "moth/block_lookup"), "spore_blossom", -1))
		);
		ImmutableMap.Builder<String, ConfiguredPower<?, ?>> builder = ImmutableMap.builder();
		builder.put("resistance", ApoliPowers.STACKING_STATUS_EFFECT.get().configure(
				new StackingStatusEffectConfiguration(ListConfiguration.of(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 2, true, false, false)), -30, 120, 10, 10),
				PowerData.builder().addCondition(flowers).build()));
		ConfiguredEntityAction<?, ?> bonemeal = ApoliEntityActions.BLOCK_ACTION_AT.get().configure(FieldConfiguration.of(
				ApoliBlockActions.AND.get().configure(
						StreamConfiguration.and(ImmutableList.of(
										ApoliBlockActions.OFFSET.get().configure(new OffsetConfiguration<>(
												ApoliBlockActions.BONEMEAL.get().configure(FieldConfiguration.of(true)),
												0, -1, 0
										)),
										ApoliBlockActions.BONEMEAL.get().configure(FieldConfiguration.of(true))
								),
								ApoliBlockActions.EXECUTOR))));
		builder.put("bonemeal", ApoliPowers.ACTIVE_SELF.get().configure(
				new ActiveSelfConfiguration(50, new HudRender(true, 2, new ResourceLocation(GroundedOrigins.MOD_ID, "textures/gui/custom_bars.png"), null, false), bonemeal, IActivePower.Key.SECONDARY),
				PowerData.builder()
						.addCondition(ApoliEntityConditions.and(ApoliEntityConditions.EXPOSED_TO_SUN.get().configure(NoConfiguration.INSTANCE, new ConditionData(true)), flowers))
						.build()));
		builder.put("flower_forest_strength", ApoliPowers.STACKING_STATUS_EFFECT.get().configure(
				new StackingStatusEffectConfiguration(ListConfiguration.of(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 2, true, false, false)), -30, 120, 10, 10),
				PowerData.builder()
						.addCondition(ApoliEntityConditions.BIOME.get().configure(new BiomeConfiguration(ListConfiguration.of(Biomes.FLOWER_FOREST), null)))
						.build()));
		return builder.build();
	}

	private static ConfiguredPower<?, ?> makeEntry(String name, MobEffectInstance... effects) {
		return ApoliPowers.STACKING_STATUS_EFFECT.get().configure(
				new StackingStatusEffectConfiguration(ListConfiguration.of(effects), -30, 120, 10, 10),
				PowerData.builder()
						.addCondition(
								ApoliEntityConditions.and(
										ApoliEntityConditions.EXPOSED_TO_SUN.get().configure(NoConfiguration.INSTANCE, new ConditionData(true)),
										ModEntityConditions.CUBE_CHECK.get().configure(new CubeCheckConditionConfiguration(new ResourceLocation(GroundedOrigins.MOD_ID, "moth/block_lookup"), name, 15))
								))
						.build());
	}
}

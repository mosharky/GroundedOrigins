package momo.grounded_origins.configuration;

import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import io.github.edwinmindcraft.apoli.api.IDynamicFeatureConfiguration;
import net.minecraft.resources.ResourceLocation;

public record CubeCheckConditionConfiguration(ResourceLocation power, String name,
											  int range) implements IDynamicFeatureConfiguration {

	public static final SerializableData SERIALIZABLE_DATA = new SerializableData()
			.add("power", SerializableDataTypes.IDENTIFIER)
			.add("name", SerializableDataTypes.STRING)
			.add("range", SerializableDataTypes.INT, -1);

	public static CubeCheckConditionConfiguration fromInstance(SerializableData.Instance instance) {
		return new CubeCheckConditionConfiguration(instance.get("power"), instance.getString("name"), instance.getInt("range"));
	}

	public static SerializableData.Instance toInstance(SerializableData data, CubeCheckConditionConfiguration config) {
		return config.toInstance(data);
	}

	public SerializableData.Instance toInstance(SerializableData data) {
		SerializableData.Instance instance = data.new Instance();
		instance.set("power", this.power());
		instance.set("name", this.name());
		instance.set("range", this.range());
		return instance;
	}

	public SerializableData.Instance toInstance() {
		return this.toInstance(SERIALIZABLE_DATA);
	}
}

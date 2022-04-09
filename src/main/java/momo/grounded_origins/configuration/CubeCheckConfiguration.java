package momo.grounded_origins.configuration;

import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.util.Comparison;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataType;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;

import java.util.List;

public record CubeCheckConfiguration(int radius, List<Entry> entries,
									 int tickInterval) {
	public record Entry(String name, Tag<Block> tag, Comparison comparison, int compareTo) {}

	public static final SerializableDataType<Entry> ENTRY = SerializableDataType.compound(Entry.class, new SerializableData()
					.add("name", SerializableDataTypes.STRING)
					.add("tag", SerializableDataTypes.BLOCK_TAG)
					.add("comparison", ApoliDataTypes.COMPARISON)
					.add("compare_to", SerializableDataTypes.INT),
			instance -> new Entry(instance.get("name"), instance.get("tag"), instance.get("comparison"), instance.getInt("compare_to")),
			(serializableData, entry) -> {
				SerializableData.Instance instance = serializableData.new Instance();
				instance.set("name", entry.name());
				instance.set("tag", entry.tag());
				instance.set("comparison", entry.comparison());
				instance.set("compare_to", entry.compareTo());
				return instance;
			});

	public static final SerializableDataType<List<Entry>> ENTRIES = SerializableDataType.list(ENTRY);
	public static final SerializableData SERIALIZABLE_DATA = new SerializableData()
			.add("radius", SerializableDataTypes.INT)
			.add("entries", ENTRIES)
			.add("interval", SerializableDataTypes.INT, 20);

	public static CubeCheckConfiguration fromInstance(SerializableData.Instance instance) {
		return new CubeCheckConfiguration(instance.get("radius"), instance.get("entries"), instance.getInt("interval"));
	}

	public static SerializableData.Instance toInstance(SerializableData data, CubeCheckConfiguration config) {
		return config.toInstance(data);
	}

	public SerializableData.Instance toInstance(SerializableData data) {
		SerializableData.Instance instance = data.new Instance();
		instance.set("radius", this.radius());
		instance.set("entries", this.entries());
		instance.set("interval", this.tickInterval());
		return instance;
	}

	public SerializableData.Instance toInstance() {
		return this.toInstance(SERIALIZABLE_DATA);
	}
}

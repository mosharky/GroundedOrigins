package momo.grounded_origins;

import momo.grounded_origins.item.ModItems;
import momo.grounded_origins.sounds.ModSounds;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GroundedOrigins implements ModInitializer {
	public static final String MOD_ID = "grounded_origins";
	public static final Logger LOGGER = LogManager.getLogger("grounded_origins");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModSounds.registerSounds();
	}
}

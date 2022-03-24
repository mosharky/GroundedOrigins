package momo.grounded_origins;

import momo.grounded_origins.registry.ModItems;
import momo.grounded_origins.registry.RaveSound;
import net.fabricmc.api.ModInitializer;


public class GroundedOrigins implements ModInitializer {
	public static final String MOD_ID = "grounded_origins";

	@Override
	public void onInitialize() {
		RaveSound.init();
		ModItems.init();
	}
}

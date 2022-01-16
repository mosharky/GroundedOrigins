package momo.grounded_origins;

import momo.grounded_origins.registry.Icons;
import momo.grounded_origins.registry.RaveSound;
import momo.grounded_origins.registry.TernaryKeybind;
import net.fabricmc.api.ModInitializer;


public class GroundedOrigins implements ModInitializer {
	public static final String MOD_ID = "grounded_origins";

	@Override
	public void onInitialize() {
		RaveSound.init();
		Icons.init();
		TernaryKeybind.init();
	}
}

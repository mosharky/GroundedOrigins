package momo.grounded_origins.common;

import io.github.apace100.apoli.ApoliClient;
import io.github.apace100.origins.Origins;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class TernaryKeybind implements ClientModInitializer {

    private static KeyBinding keyBinding;

    @Override
    public void onInitializeClient() {

        keyBinding = new KeyBinding(
                "key.origins.ternary_active",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                "category." + Origins.MODID
        );
        ApoliClient.registerPowerKeybinding("key.origins.ternary_active", keyBinding);
        ApoliClient.registerPowerKeybinding("ternary", keyBinding);
        KeyBindingHelper.registerKeyBinding(keyBinding);
    }

}

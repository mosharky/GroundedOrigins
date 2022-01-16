package momo.grounded_origins.registry;

import io.github.apace100.apoli.ApoliClient;
import io.github.apace100.origins.Origins;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class TernaryKeybind {

    private static KeyBinding keyBinding;

    public static void init() {
        if (FabricLoader.getInstance().isModLoaded("extrakeybinds")) return;
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

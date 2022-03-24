package momo.grounded_origins.registry;

import com.mojang.blaze3d.platform.InputConstants;
import io.github.apace100.apoli.ApoliClient;
import io.github.apace100.origins.Origins;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
public class ModKeybinds {

    public static KeyMapping useTernaryActivePowerKeybind;
    public static KeyMapping useQuaternaryActivePowerKeybind;

    public static void init() {
        useTernaryActivePowerKeybind = new KeyMapping("key.origins.ternary_active",  InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category." + Origins.MODID);
        useQuaternaryActivePowerKeybind = new KeyMapping("key.origins.quaternary_active",  InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category." + Origins.MODID);
        ApoliClient.registerPowerKeybinding("key.origins.ternary_active", useTernaryActivePowerKeybind);
        ApoliClient.registerPowerKeybinding("key.origins.quaternary_active", useQuaternaryActivePowerKeybind);
        ApoliClient.registerPowerKeybinding("ternary", useTernaryActivePowerKeybind);
        ApoliClient.registerPowerKeybinding("quaternary", useQuaternaryActivePowerKeybind);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(ModKeybinds::clientSetup);
    }

    public static  void clientSetup(FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(useTernaryActivePowerKeybind);
        ClientRegistry.registerKeyBinding(useQuaternaryActivePowerKeybind);
    }
}

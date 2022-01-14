package momo.grounded_origins.sounds;

import momo.grounded_origins.GroundedOrigins;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static SoundEvent RAVE = registerSoundEvent("rave");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(GroundedOrigins.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerSounds() {
        System.out.println("Registering sounds for " + GroundedOrigins.MOD_ID);
    }
}

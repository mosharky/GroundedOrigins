package momo.grounded_origins.registry;

import momo.grounded_origins.GroundedOrigins;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RaveSound {
    public static final SoundEvent RAVE = new SoundEvent(new Identifier(GroundedOrigins.MOD_ID, "rave"));

    public static void init() {
        Registry.register(Registry.SOUND_EVENT, RAVE.getId(), RAVE);
    }
}

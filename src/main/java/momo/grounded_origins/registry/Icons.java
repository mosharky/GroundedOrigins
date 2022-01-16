package momo.grounded_origins.registry;

import momo.grounded_origins.GroundedOrigins;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Icons {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GroundedOrigins.MOD_ID);

    public static final RegistryObject<Item> BEACH_CRAB_ICON = ITEMS.register("beach_crab_icon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DEER_ICON = ITEMS.register("deer_icon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOTH_ICON = ITEMS.register("moth_icon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PENGUIN_ICON = ITEMS.register("penguin_icon",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

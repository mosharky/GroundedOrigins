package momo.grounded_origins.item;

import momo.grounded_origins.GroundedOrigins;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems {

    public static final Item BEACH_CRAB_ICON = registerItem("beach_crab_icon",
            new Item(new FabricItemSettings()));
    public static final Item DEER_ICON = registerItem("deer_icon",
            new Item(new FabricItemSettings()));
    public static final Item MOTH_ICON = registerItem("moth_icon",
            new Item(new FabricItemSettings()));
    public static final Item PENGUIN_ICON = registerItem("penguin_icon",
            new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(GroundedOrigins.MOD_ID, name), item);
    }

    public static void registerModItems() {
        GroundedOrigins.LOGGER.info("Registering icons for " + GroundedOrigins.MOD_ID);
    }

}

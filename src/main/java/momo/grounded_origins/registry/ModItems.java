package momo.grounded_origins.registry;

import momo.grounded_origins.GroundedOrigins;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GroundedOrigins.MOD_ID);

    // Icons
    public static final RegistryObject<Item> BEACH_CRAB_ICON = ITEMS.register("beach_crab_icon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DEER_ICON = ITEMS.register("deer_icon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOTH_ICON = ITEMS.register("moth_icon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PENGUIN_ICON = ITEMS.register("penguin_icon", () -> new Item(new Item.Properties()));

    // Moth foods
    public static final RegistryObject<Item> FLOWER_STAMENS = ITEMS.register("flower_stamens", () -> new Item(new Item.Properties()
            .tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder().alwaysEat().build()))
    );
    public static final RegistryObject<Item> FIBROUS_STRING = ITEMS.register("fibrous_string", () -> new Item(new Item.Properties()
            .tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder().alwaysEat().build()))
    );
    public static final RegistryObject<Item> PAPER_SHREDS = ITEMS.register("paper_shreds", () -> new Item(new Item.Properties()
            .tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder().alwaysEat().build()))
    );
    public static final RegistryObject<Item> BOOK_BITE = ITEMS.register("book_bite", () -> new Item(new Item.Properties()
            .tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder().alwaysEat().build()))
    );

    public static void init(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

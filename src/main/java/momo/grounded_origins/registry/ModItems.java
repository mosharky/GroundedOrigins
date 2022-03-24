package momo.grounded_origins.registry;

import momo.grounded_origins.GroundedOrigins;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems {

    // Icons
    public static final Item BEACH_CRAB_ICON = new Item(new FabricItemSettings());
    public static final Item DEER_ICON = new Item(new FabricItemSettings());
    public static final Item MOTH_ICON = new Item(new FabricItemSettings());
    public static final Item PENGUIN_ICON = new Item(new FabricItemSettings());

    // Moth foods
    public static final Item FLOWER_STAMENS = new Item(new FabricItemSettings().group(ItemGroup.FOOD)
            .food(new FoodComponent.Builder().alwaysEdible().build())
    );
    public static final Item FIBROUS_STRING = new Item(new FabricItemSettings().group(ItemGroup.FOOD)
            .food(new FoodComponent.Builder().alwaysEdible().build())
    );
    public static final Item PAPER_SHREDS = new Item(new FabricItemSettings().group(ItemGroup.FOOD)
            .food(new FoodComponent.Builder().alwaysEdible().build())
    );
    public static final Item BOOK_BITE = new Item(new FabricItemSettings().group(ItemGroup.FOOD)
            .food(new FoodComponent.Builder().alwaysEdible().build())
    );

    public static void init() {
        // Icons
        Registry.register(Registry.ITEM, new Identifier(GroundedOrigins.MOD_ID, "beach_crab_icon"), BEACH_CRAB_ICON);
        Registry.register(Registry.ITEM, new Identifier(GroundedOrigins.MOD_ID, "deer_icon"), DEER_ICON);
        Registry.register(Registry.ITEM, new Identifier(GroundedOrigins.MOD_ID, "moth_icon"), MOTH_ICON);
        Registry.register(Registry.ITEM, new Identifier(GroundedOrigins.MOD_ID, "penguin_icon"), PENGUIN_ICON);
        // Moth foods
        Registry.register(Registry.ITEM, new Identifier(GroundedOrigins.MOD_ID, "flower_stamens"), FLOWER_STAMENS);
        Registry.register(Registry.ITEM, new Identifier(GroundedOrigins.MOD_ID, "fibrous_string"), FIBROUS_STRING);
        Registry.register(Registry.ITEM, new Identifier(GroundedOrigins.MOD_ID, "paper_shreds"), PAPER_SHREDS);
        Registry.register(Registry.ITEM, new Identifier(GroundedOrigins.MOD_ID, "book_bite"), BOOK_BITE);
    }
}

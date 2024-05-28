package com.momo.grounded_origins.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import static com.momo.grounded_origins.GroundedOrigins.MOD_ID;

public class ModItems {
    public static final Item BEACH_CRAB_ICON = new Item(new Item.Properties());
    public static final Item DEER_ICON = new Item(new Item.Properties());
    public static final Item MOTH_ICON = new Item(new Item.Properties());
    public static final Item PENGUIN_ICON = new Item(new Item.Properties());

    public static void registerItems(RegistrationCallback<Item> callback) {
        callback.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, "beach_crab_icon"), BEACH_CRAB_ICON);
        callback.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, "deer_icon"), DEER_ICON);
        callback.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, "moth_icon"), MOTH_ICON);
        callback.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, "penguin_icon"), PENGUIN_ICON);
    }
}

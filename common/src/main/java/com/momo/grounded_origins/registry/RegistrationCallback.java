package com.momo.grounded_origins.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

// thank you pug
@FunctionalInterface
public interface RegistrationCallback<T> {
    void register(Registry<T> registry, ResourceLocation id, T block);
}
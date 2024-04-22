package com.amiriox;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.networking.v1.C2SPlayChannelEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Aegirtech implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("aegirtech");
	public static final Item SRC =
			Registry.register(Registries.ITEM, new Identifier("test", "src"),
					new Item(new Item.Settings()));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(
				content -> {
					content.add(SRC);
				}
		);
		LOGGER.info("Hello Fabric world!");
	}
}
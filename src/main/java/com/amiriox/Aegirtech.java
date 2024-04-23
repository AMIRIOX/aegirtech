package com.amiriox;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Aegirtech implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your moh id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("aegirtech");

	// Rules
	public static final RegistryKey<PlacedFeature> ENERGY_ORE_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("aegirtech", "ore_custom"));

	// Item, Blocks
	public static final Item SRC =
			Registry.register(Registries.ITEM, new Identifier("aegirtech", "src"),
					new Item(new FabricItemSettings().maxCount(2400)));

	public static final EnergyOre ENERGY_ORE = new EnergyOre(FabricBlockSettings.create().strength(5.0f).requiresTool());
	public static final EnergyCrystal ENERGY_CRYSTAL = new EnergyCrystal(new FabricItemSettings().maxCount(2048));

	// Item Groups
	public static final ItemGroup aegir_group = FabricItemGroup.builder()
			.icon(() -> new ItemStack(SRC))
			.displayName(Text.translatable("itemGroup.aegirtech.aegir_group"))
			.entries((context, entries) -> {
				entries.add(SRC);
				entries.add(ENERGY_ORE);
				entries.add(ENERGY_CRYSTAL);
			})
			.build();

	@Override
	public void onInitialize() {
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ENERGY_ORE_KEY);

		// Register Items (waiting for rebuild)
		Registry.register(Registries.BLOCK, new Identifier("aegirtech", "energy_ore"), ENERGY_ORE);
		Registry.register(Registries.ITEM, new Identifier("aegirtech", "energy_ore"), new BlockItem(ENERGY_ORE, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier("aegirtech", "energy_crystal"), ENERGY_CRYSTAL);
		FuelRegistry.INSTANCE.add(ENERGY_CRYSTAL, 300);

		// Register Item Groups
		Registry.register(Registries.ITEM_GROUP, new Identifier("aegirtech", "aegir_group"), aegir_group);

		LOGGER.info("Aegir Technology Load Successfully!");
	}
}
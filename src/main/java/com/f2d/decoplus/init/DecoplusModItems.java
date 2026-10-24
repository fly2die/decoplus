/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.f2d.decoplus.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import java.util.function.Function;

import com.f2d.decoplus.item.ProcessorItem;
import com.f2d.decoplus.item.MotherboardItem;
import com.f2d.decoplus.item.DisplayboardItem;
import com.f2d.decoplus.DecoplusMod;

public class DecoplusModItems {
	public static Item LAPTOP;
	public static Item MONITOR;
	public static Item COMPUTER;
	public static Item IMONITOR;
	public static Item VMONITOR;
	public static Item PAD;
	public static Item NUKE;
	public static Item WASHER;
	public static Item ELECTRIC_STOVE;
	public static Item FRIDGE;
	public static Item TELEVISOR;
	public static Item SMART_TV;
	public static Item KITCHEN_HOOD;
	public static Item KITCHEN_SINK;
	public static Item SINK;
	public static Item CONSOLE_XCRAFTX;
	public static Item CONSOLE_PLAYCRAFT_5;
	public static Item TOILET;
	public static Item PROCESSOR;
	public static Item MOTHERBOARD;
	public static Item DISPLAYBOARD;

	public static void load() {
		LAPTOP = block(DecoplusModBlocks.LAPTOP, "laptop");
		MONITOR = block(DecoplusModBlocks.MONITOR, "monitor");
		COMPUTER = block(DecoplusModBlocks.COMPUTER, "computer");
		IMONITOR = block(DecoplusModBlocks.IMONITOR, "imonitor");
		VMONITOR = block(DecoplusModBlocks.VMONITOR, "vmonitor");
		PAD = block(DecoplusModBlocks.PAD, "pad");
		NUKE = block(DecoplusModBlocks.NUKE, "nuke");
		WASHER = block(DecoplusModBlocks.WASHER, "washer");
		ELECTRIC_STOVE = block(DecoplusModBlocks.ELECTRIC_STOVE, "electric_stove");
		FRIDGE = block(DecoplusModBlocks.FRIDGE, "fridge");
		TELEVISOR = block(DecoplusModBlocks.TELEVISOR, "televisor");
		SMART_TV = block(DecoplusModBlocks.SMART_TV, "smart_tv");
		KITCHEN_HOOD = block(DecoplusModBlocks.KITCHEN_HOOD, "kitchen_hood");
		KITCHEN_SINK = block(DecoplusModBlocks.KITCHEN_SINK, "kitchen_sink");
		SINK = block(DecoplusModBlocks.SINK, "sink");
		CONSOLE_XCRAFTX = block(DecoplusModBlocks.CONSOLE_XCRAFTX, "console_xcraftx");
		CONSOLE_PLAYCRAFT_5 = block(DecoplusModBlocks.CONSOLE_PLAYCRAFT_5, "console_playcraft_5");
		TOILET = block(DecoplusModBlocks.TOILET, "toilet");
		PROCESSOR = register("processor", ProcessorItem::new);
		MOTHERBOARD = register("motherboard", MotherboardItem::new);
		DISPLAYBOARD = register("displayboard", DisplayboardItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> I register(String name, Function<Item.Properties, ? extends I> supplier) {
		return (I) Items.registerItem(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(DecoplusMod.MODID, name)), (Function<Item.Properties, Item>) supplier);
	}

	private static Item block(Block block, String name) {
		return block(block, name, new Item.Properties());
	}

	private static Item block(Block block, String name, Item.Properties properties) {
		return Items.registerItem(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(DecoplusMod.MODID, name)), prop -> new BlockItem(block, prop), properties);
	}
}
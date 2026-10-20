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

import com.f2d.decoplus.DecoplusMod;

public class DecoplusModItems {
	public static Item LAPTOP;
	public static Item MONITOR;
	public static Item COMPUTER;
	public static Item IMONITOR;
	public static Item VMONITOR;
	public static Item PAD;
	public static Item WHEEL_BLOCK;

	public static void load() {
		LAPTOP = block(DecoplusModBlocks.LAPTOP, "laptop");
		MONITOR = block(DecoplusModBlocks.MONITOR, "monitor");
		COMPUTER = block(DecoplusModBlocks.COMPUTER, "computer");
		IMONITOR = block(DecoplusModBlocks.IMONITOR, "imonitor");
		VMONITOR = block(DecoplusModBlocks.VMONITOR, "vmonitor");
		PAD = block(DecoplusModBlocks.PAD, "pad");
		WHEEL_BLOCK = block(DecoplusModBlocks.WHEEL_BLOCK, "wheel_block");
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
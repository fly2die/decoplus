/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.f2d.decoplus.init;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import java.util.function.Function;

import com.f2d.decoplus.block.*;
import com.f2d.decoplus.DecoplusMod;

public class DecoplusModBlocks {
	public static Block LAPTOP;
	public static Block MONITOR;
	public static Block COMPUTER;
	public static Block IMONITOR;
	public static Block VMONITOR;
	public static Block PAD;
	public static Block NUKE;
	public static Block WASHER;
	public static Block ELECTRIC_STOVE;
	public static Block FRIDGE;
	public static Block TELEVISOR;
	public static Block SMART_TV;
	public static Block KITCHEN_HOOD;
	public static Block KITCHEN_SINK;
	public static Block SINK;
	public static Block CONSOLE_XCRAFTX;
	public static Block CONSOLE_PLAYCRAFT_5;
	public static Block IRON_TABLE;

	public static void load() {
		LAPTOP = register("laptop", LaptopBlock::new);
		MONITOR = register("monitor", MonitorBlock::new);
		COMPUTER = register("computer", ComputerBlock::new);
		IMONITOR = register("imonitor", ImonitorBlock::new);
		VMONITOR = register("vmonitor", VmonitorBlock::new);
		PAD = register("pad", PadBlock::new);
		NUKE = register("nuke", NukeBlock::new);
		WASHER = register("washer", WasherBlock::new);
		ELECTRIC_STOVE = register("electric_stove", ElectricStoveBlock::new);
		FRIDGE = register("fridge", FridgeBlock::new);
		TELEVISOR = register("televisor", TelevisorBlock::new);
		SMART_TV = register("smart_tv", SmartTVBlock::new);
		KITCHEN_HOOD = register("kitchen_hood", KitchenHoodBlock::new);
		KITCHEN_SINK = register("kitchen_sink", KitchenSinkBlock::new);
		SINK = register("sink", SinkBlock::new);
		CONSOLE_XCRAFTX = register("console_xcraftx", ConsoleXcraftxBlock::new);
		CONSOLE_PLAYCRAFT_5 = register("console_playcraft_5", ConsolePlaycraft5Block::new);
		IRON_TABLE = register("iron_table", IronTableBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> B register(String name, Function<BlockBehaviour.Properties, B> supplier) {
		return (B) Blocks.register(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DecoplusMod.MODID, name)), (Function<BlockBehaviour.Properties, Block>) supplier, BlockBehaviour.Properties.of());
	}
}
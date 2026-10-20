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
	public static Block WHEEL_BLOCK;

	public static void load() {
		LAPTOP = register("laptop", LaptopBlock::new);
		MONITOR = register("monitor", MonitorBlock::new);
		COMPUTER = register("computer", ComputerBlock::new);
		IMONITOR = register("imonitor", ImonitorBlock::new);
		VMONITOR = register("vmonitor", VmonitorBlock::new);
		PAD = register("pad", PadBlock::new);
		WHEEL_BLOCK = register("wheel_block", WheelBlockBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> B register(String name, Function<BlockBehaviour.Properties, B> supplier) {
		return (B) Blocks.register(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DecoplusMod.MODID, name)), (Function<BlockBehaviour.Properties, Block>) supplier, BlockBehaviour.Properties.of());
	}
}
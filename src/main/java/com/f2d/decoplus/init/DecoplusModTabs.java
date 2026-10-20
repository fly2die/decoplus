/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.f2d.decoplus.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import com.f2d.decoplus.DecoplusMod;

public class DecoplusModTabs {
	public static ResourceKey<CreativeModeTab> TAB_DECOPLUS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(DecoplusMod.MODID, "decoplus"));

	public static void load() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAB_DECOPLUS,
				CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).title(Component.translatable("item_group.decoplus.decoplus")).icon(() -> new ItemStack(DecoplusModBlocks.COMPUTER)).displayItems((parameters, tabData) -> {
					tabData.accept(DecoplusModBlocks.LAPTOP.asItem());
					tabData.accept(DecoplusModBlocks.IMONITOR.asItem());
					tabData.accept(DecoplusModBlocks.VMONITOR.asItem());
					tabData.accept(DecoplusModBlocks.MONITOR.asItem());
					tabData.accept(DecoplusModBlocks.COMPUTER.asItem());
					tabData.accept(DecoplusModBlocks.PAD.asItem());
					tabData.accept(DecoplusModBlocks.WHEEL_BLOCK.asItem());
				}).build());
	}
}
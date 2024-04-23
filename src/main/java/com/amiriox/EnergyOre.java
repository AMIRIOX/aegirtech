package com.amiriox;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;

import java.util.List;

public class EnergyOre extends Block {

    public EnergyOre(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("block.aegirtech.energy_ore.tooltip"));
    }
}

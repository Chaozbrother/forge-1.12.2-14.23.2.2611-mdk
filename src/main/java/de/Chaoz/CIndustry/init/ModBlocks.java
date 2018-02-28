package de.Chaoz.CIndustry.init;

import java.util.ArrayList;
import java.util.List;

import de.Chaoz.CIndustry.blocks.UraniumBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {


    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block URANIUM_BLOCK = new UraniumBlock("uranium_block", Material.IRON, null, 1, 1);
}

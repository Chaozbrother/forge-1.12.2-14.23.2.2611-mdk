package de.Chaoz.CIndustry.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class UraniumBlock extends BlockBase {

    public UraniumBlock(String name, Material material){
        this(name, material, null, 1, 1);
    }

    public UraniumBlock(String name, Material material, Item itemToDrop) {
        this(name, material, itemToDrop, 1, 1);
    }

    public UraniumBlock(String name, Material material, Item itemToDrop, int dropAmount) {
        this(name, material, itemToDrop, dropAmount, dropAmount);
    }

    public UraniumBlock(String name, Material material, Item itemToDrop, int minDropAmount, int maxDropAmount) {
        super(name, material, itemToDrop, minDropAmount, maxDropAmount);
        init();
    }

    private void init() {
        setSoundType(SoundType.METAL);
        setHardness(5.0F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 2);
        setLightLevel(1.0F);
        //setLightOpacity();
        //setBlockUnbreakable();
    }
}

package de.Chaoz.CIndustry.blocks;

import de.Chaoz.CIndustry.CIndustry;
import de.Chaoz.CIndustry.init.ModBlocks;
import de.Chaoz.CIndustry.init.ModItems;
import de.Chaoz.CIndustry.util.IHasModel;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.block.Block;

import java.util.Random;


public class BlockBase extends Block implements IHasModel {

    private Item itemToDrop;
    private int minDropAmount = 1;
    private int maxDropAmount = 0;

    public BlockBase(String name, Material material){
        this(name, material, null, 1, 1);
    }

    public BlockBase(String name, Material material, Item itemToDrop) {
        this(name, material, itemToDrop, 1, 1);
    }

    public BlockBase(String name, Material material, Item itemToDrop, int dropAmount) {
        this(name, material, itemToDrop, dropAmount, dropAmount);
    }

    public BlockBase(String name, Material material, Item itemToDrop, int minDropAmount, int maxDropAmount) {
        super(material);

        this.itemToDrop = itemToDrop; //neu
        this.maxDropAmount = maxDropAmount;
        this.minDropAmount = minDropAmount;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    /**
     * Defines which item is going to be dropped
     * @param p_getItemDropped_1_ The state of the block
     * @param p_getItemDropped_2_ The chance
     * @param p_getItemDropped_3_ ...
     * @return If the item was null, the item would be the block itself otherwise it is going to be the defined item
     */
    @Override
    public Item getItemDropped(IBlockState p_getItemDropped_1_, Random p_getItemDropped_2_, int p_getItemDropped_3_) {

        if (itemToDrop == null) {
            return itemToDrop.getItemFromBlock(this);
        } else {
            return itemToDrop;
        }

        // macht genau das gleiche...
        // return toDrop==null?Item.getItemFromBlock(this):toDrop;
    }

    /**
     * Defines the quantity of the dropped item
     * Before the quantity is being returned, the method checks whether the minDropAmount is smaller than the maxDropAmount
     * @param random The chance
     * @return Returns the items quantity
     */
    @Override
    public int quantityDropped(Random random) {

        if (this.minDropAmount > this.maxDropAmount) {
            int i = this.minDropAmount;
            this.minDropAmount = this.maxDropAmount;
            this.maxDropAmount = i;
        }
        return this.minDropAmount + random.nextInt(this.maxDropAmount - this.minDropAmount + 1);
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;
            if (i < 0)
            {
                i = 0;
            }
            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }

    @Override
    public void registerModels(){
        CIndustry.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }


}

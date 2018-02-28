package de.Chaoz.CIndustry.items;

import de.Chaoz.CIndustry.CIndustry;
import de.Chaoz.CIndustry.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import de.Chaoz.CIndustry.util.IHasModel;

public class ItemBase extends Item implements IHasModel {


    public ItemBase(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);


        ModItems.ITEMS.add(this);
    }
    @Override
    public void registerModels()
    {
     CIndustry.proxy.registerItemRenderer(this, 0, "inventory");
        
    }

}

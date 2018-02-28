package de.Chaoz.CIndustry;

import de.Chaoz.CIndustry.Proxy.CommonProxy;
import de.Chaoz.CIndustry.gen.OreGen;
import de.Chaoz.CIndustry.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_Name, version = Reference.VERSION)
public class CIndustry {

    @Mod.Instance
    public static CIndustry INSTANCE;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }


}


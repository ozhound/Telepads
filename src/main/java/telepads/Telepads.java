package telepads;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import telepads.block.BlockTelepad;
import telepads.block.TETelepad;
import telepads.item.ItemPadLocations;
import telepads.util.DataTracker;
import telepads.util.PadEvents;
import telepads.util.TelePadGuiHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Telepads.modID, name = Telepads.modName, version = Telepads.version)
public class Telepads {

	protected static final String version = "1.6.4 v5";
	protected static final String modID = "telepads";
	protected static final String modName = "Teleportation Pads";

	public static BlockTelepad telepad;
	public static ItemPadLocations register;

	@SidedProxy(serverSide = "telepads.TelepadProxyServer", clientSide = "telepads.TelepadProxyClient")
	public static TelepadProxyServer proxy;
	public static Telepads instance;

	public static FMLEventChannel Channel;
	public static final String packetChannel = "TelepadPackets";

	@EventHandler
	public void load(FMLInitializationEvent evt){

		instance = this;

		proxy.registerSound();

		GameRegistry.addRecipe(new ItemStack(telepad,2),new Object[] {"GGG", "RER", "RIR",
			'G', Blocks.glass, 'R', Items.redstone, 'E', Items.ender_pearl, 'I', Blocks.iron_block});

		proxy.registerTileEntity();
		GameRegistry.registerTileEntity(TETelepad.class, "TETelepad");
		proxy.registerItemRenderer();

		Channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(packetChannel);
		proxy.registerPacketHandlers();

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new TelePadGuiHandler());
		FMLCommonHandler.instance().bus().register(new DataTracker());
		MinecraftForge.EVENT_BUS.register(new PadEvents());
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent e){

		register = (ItemPadLocations) new ItemPadLocations().setUnlocalizedName("register");
		GameRegistry.registerItem(register, "ItemPadLocations");

		telepad = (BlockTelepad) new BlockTelepad(Material.wood).setBlockName("telepad").setLightLevel(0.2f).setCreativeTab(CreativeTabs.tabTransport).setBlockUnbreakable().setBlockTextureName("wool_colored_pink");
		GameRegistry.registerBlock(telepad, "TelePad");
	}
}

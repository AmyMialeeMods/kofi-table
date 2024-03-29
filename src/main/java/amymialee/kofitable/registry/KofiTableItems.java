package amymialee.kofitable.registry;

import amymialee.kofitable.KofiTable;
import amymialee.kofitable.items.KofiCupItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

@SuppressWarnings("unused")
public class KofiTableItems {
    public static final Item KOFI_CUP = registerItem("kofi_cup", new KofiCupItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    public static void init() {}

    public static Item registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, KofiTable.id(name), item);
        return item;
    }
}
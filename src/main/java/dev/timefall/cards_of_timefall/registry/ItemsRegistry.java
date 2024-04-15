package dev.timefall.cards_of_timefall.registry;

import dev.emi.trinkets.api.TrinketItem;
import dev.timefall.cards_of_timefall.CardsOfTimefall;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemsRegistry {

    private static Item register(Item item, String id){
        return Registry.register(Registries.ITEM, CardsOfTimefall.identity(id), item);
    }

    public static final Item CARD_CHRONOS = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_chronos");
    public static final Item CARD_CUP = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_cup");
    public static final Item CARD_ETERNAL = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_eternal");
    public static final Item CARD_FZZY = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_fzzy");
    public static final Item CARD_GHOST = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_ghost");
    public static final Item CARD_KAMI = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_kami");
    public static final Item CARD_KUDOS = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_kudos");
    public static final Item CARD_MTIJGER = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_mtijger");
    public static final Item CARD_PHOENIX = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_phoenix");
    public static final Item CARD_SNOW = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_snow");
    public static final Item CARD_SOLACE = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_solace");
    public static final Item CARD_SWEENEY = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_sweeney");
    public static final Item CARD_TAMAKI = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_tamaki");
    public static final Item CARD_TIMEFALL = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_timefall");
    public static final Item CARD_TOBOE = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_toboe");
    public static final Item CARD_WAGON = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_wagon");
    public static final Item CARD_ZARRA = register(new TrinketItem(new FabricItemSettings().maxCount(1)),"card_zarra");

    public static void init(){}
}
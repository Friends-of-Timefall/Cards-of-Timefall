package dev.timefall.cards_of_timefall.registry;

import dev.timefall.cards_of_timefall.CardsOfTimefall;
import dev.timefall.cards_of_timefall.item.CardPackItem;
import dev.timefall.cards_of_timefall.item.HolographicCardItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

public class ItemsRegistry {

    private static Item register(Item item, String id){
        return Registry.register(Registries.ITEM, CardsOfTimefall.identity(id), item);
    }

    public static final Item CARD_PACK = register(new CardPackItem(new FabricItemSettings().maxCount(16).rarity(Rarity.UNCOMMON)),"card_pack");
    public static final Item CARD_TIMEFALL = register(new HolographicCardItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)),"card_timefall");

    public static final Item CARD_CHORSE = register(new HolographicCardItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)),"card_chorse");
    public static final Item CARD_ELDER_GUARDIAN = register(new HolographicCardItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)),"card_elder_guardian");
    public static final Item CARD_WARDEN = register(new HolographicCardItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)),"card_warden");
    public static final Item CARD_WITHER = register(new HolographicCardItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)),"card_wither");

    public static final Item CARD_BLAZE = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_blaze");
    public static final Item CARD_CAVE_SPIDER = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_cave_spider");
    public static final Item CARD_CREEPER = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_creeper");
    public static final Item CARD_ENDERMAN = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_enderman");
    public static final Item CARD_IRON_GOLEM = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_iron_golem");
    public static final Item CARD_SKELETON = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_skeleton");
    public static final Item CARD_ZOMBIE = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_zombie");

    public static final Item CARD_CHRONOS = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_chronos");
    public static final Item CARD_CUP = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_cup");
    public static final Item CARD_ETERNAL = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_eternal");
    public static final Item CARD_FZZY = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_fzzy");
    public static final Item CARD_GHOST = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_ghost");
    public static final Item CARD_KAMI = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_kami");
    public static final Item CARD_KUDOS = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_kudos");
    public static final Item CARD_MTIJGER = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_mtijger");
    public static final Item CARD_PHOENIX = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_phoenix");
    public static final Item CARD_SNOW = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_snow");
    public static final Item CARD_SOLACE = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_solace");
    public static final Item CARD_SWEENEY = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_sweeney");
    public static final Item CARD_TAMAKI = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_tamaki");
    public static final Item CARD_TOBOE = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_toboe");
    public static final Item CARD_TOLLISH = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_tollish");
    public static final Item CARD_WAGON = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_wagon");
    public static final Item CARD_ZARRA = register(new HolographicCardItem(new FabricItemSettings().maxCount(1)),"card_zarra");

    public static void init(){}
}
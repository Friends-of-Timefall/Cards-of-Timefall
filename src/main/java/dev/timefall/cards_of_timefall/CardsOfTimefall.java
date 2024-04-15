package dev.timefall.cards_of_timefall;

import dev.timefall.cards_of_timefall.registry.ItemsRegistry;
import dev.timefall.cards_of_timefall.registry.ModifiersRegistry;
import dev.timefall.cards_of_timefall.registry.StatusEffectsRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.TagEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.ResourceManager;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CardsOfTimefall implements ModInitializer {

    public static String MODID = "cards_of_timefall";

    public static TagKey<Item> cards = TagKey.of(RegistryKeys.ITEM,new Identifier(MODID,"cards"));

    public static Identifier identity(String name){
        return new Identifier(MODID,name);
    }

    @Override
    public void onInitialize() {
        ItemsRegistry.init();
        StatusEffectsRegistry.init();
        ModifiersRegistry.init();

        LootTableEvents.MODIFY.register((ResourceManager resourceManager, LootManager lootManager, Identifier id, LootTable.Builder tableBuilder, LootTableSource source) -> {
            if (id.getPath().startsWith("chests")) {
                LootPool.Builder builder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1.0F))
                    .conditionally(RandomChanceLootCondition.builder(0.0075f))
                    .with(TagEntry.expandBuilder(cards));
                tableBuilder.pool(builder);
            }
        });

        Registry.register(Registries.ITEM_GROUP,identity("item_group"), FabricItemGroup.builder()
                .displayName(Text.translatable("itemGroup.cards_of_timefall.item_group"))
                .icon(()-> new ItemStack(ItemsRegistry.CARD_TIMEFALL))
                .entries((ItemGroup.DisplayContext var1, ItemGroup.Entries var2) -> {
                    var2.add(ItemsRegistry.CARD_CHRONOS);
                    var2.add(ItemsRegistry.CARD_CUP);
                    var2.add(ItemsRegistry.CARD_ETERNAL);
                    var2.add(ItemsRegistry.CARD_FZZY);
                    var2.add(ItemsRegistry.CARD_GHOST);
                    var2.add(ItemsRegistry.CARD_KAMI);
                    var2.add(ItemsRegistry.CARD_KUDOS);
                    var2.add(ItemsRegistry.CARD_MTIJGER);
                    var2.add(ItemsRegistry.CARD_PHOENIX);
                    var2.add(ItemsRegistry.CARD_SNOW);
                    var2.add(ItemsRegistry.CARD_SWEENEY);
                    var2.add(ItemsRegistry.CARD_SOLACE);
                    var2.add(ItemsRegistry.CARD_TAMAKI);
                    var2.add(ItemsRegistry.CARD_TIMEFALL);
                    var2.add(ItemsRegistry.CARD_TOBOE);
                    var2.add(ItemsRegistry.CARD_WAGON);
                    var2.add(ItemsRegistry.CARD_ZARRA);
                })
                .build()
        );
    }
}
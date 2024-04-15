package dev.timefall.cards_of_timefall;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.timefall.cards_of_timefall.registry.ItemsRegistry;
import dev.timefall.cards_of_timefall.registry.ModifiersRegistry;
import dev.timefall.cards_of_timefall.registry.StatusEffectsRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.ResourceManager;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class CardsOfTimefall implements ModInitializer {

    public static String MODID = "cards_of_timefall";

    public static final Identifier cardsLoot = new Identifier(MODID,"card_pack");
    public static final TagKey<Item> cards = TagKey.of(RegistryKeys.ITEM,new Identifier(MODID,"cards"));
    public static final TagKey<Item> specialCards = TagKey.of(RegistryKeys.ITEM,new Identifier(MODID,"special_cards"));

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Float chestChance = null;

    private float getChestChance(){
        if (chestChance == null){
            chestChance = readOrCreate(Config::new).cardPackChestChance;
        }
        return chestChance;
    }

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
                    .rolls(BinomialLootNumberProvider.create(2,0.5f))
                    .conditionally(RandomChanceLootCondition.builder(getChestChance()))
                    .with(ItemEntry.builder(ItemsRegistry.CARD_PACK).weight(1));
                tableBuilder.pool(builder);
                /*LootPool.Builder builder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(RandomChanceLootCondition.builder(0.0025f))
                        .with(ItemEntry.builder(ItemsRegistry.CARD_PACK).weight(1));
                tableBuilder.pool(builder2);*/
            }
        });

        Registry.register(Registries.ITEM_GROUP,identity("item_group"), FabricItemGroup.builder()
                .displayName(Text.translatable("itemGroup.cards_of_timefall.item_group"))
                .icon(()-> new ItemStack(ItemsRegistry.CARD_TIMEFALL))
                .entries((ItemGroup.DisplayContext var1, ItemGroup.Entries var2) -> {
                    var2.add(ItemsRegistry.CARD_PACK);
                    var2.add(ItemsRegistry.CARD_TIMEFALL);
                    var2.add(ItemsRegistry.CARD_CHORSE);
                    var2.add(ItemsRegistry.CARD_ELDER_GUARDIAN);
                    var2.add(ItemsRegistry.CARD_WARDEN);
                    var2.add(ItemsRegistry.CARD_WITHER);
                    var2.add(ItemsRegistry.CARD_BLAZE);
                    var2.add(ItemsRegistry.CARD_CAVE_SPIDER);
                    var2.add(ItemsRegistry.CARD_CREEPER);
                    var2.add(ItemsRegistry.CARD_ENDERMAN);
                    var2.add(ItemsRegistry.CARD_IRON_GOLEM);
                    var2.add(ItemsRegistry.CARD_SKELETON);
                    var2.add(ItemsRegistry.CARD_ZOMBIE);
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
                    var2.add(ItemsRegistry.CARD_TOBOE);
                    var2.add(ItemsRegistry.CARD_TOLLISH);
                    var2.add(ItemsRegistry.CARD_WAGON);
                    var2.add(ItemsRegistry.CARD_ZARRA);
                })
                .build()
        );
    }

    private Config readOrCreate(Supplier<Config> configSupplier){
        File dir = FabricLoader.getInstance().getConfigDir().toFile();
        if (!dir.exists() && !dir.mkdirs()) {
            System.out.println("Could not create Cards of Timefall directory, using default configs.");
            return configSupplier.get();
        }
        File f = new File(dir,"cards_of_timefall.json");
        try{
            if (f.exists()){
                return gson.fromJson(new InputStreamReader(new FileInputStream(f)), Config.class);
            } else if (!f.createNewFile()){
                System.out.println("Could not create Cards of Timefall config file, using default configs.");
                return configSupplier.get();
            } else {
                Config newConfig = configSupplier.get();
                FileWriter fw = new FileWriter(f);
                String json = gson.toJson(newConfig);
                fw.write(json);
                fw.close();
                return newConfig;
            }
        } catch (Exception e){
            System.out.println("Could not generate Cards of Timefall configs, using default configs.");
            return configSupplier.get();
        }
    }


    private static class Config{
        float cardPackChestChance = 0.02f;
    }
}
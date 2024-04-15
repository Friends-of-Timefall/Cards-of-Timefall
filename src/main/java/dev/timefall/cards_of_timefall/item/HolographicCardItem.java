package dev.timefall.cards_of_timefall.item;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Pair;
import net.minecraft.util.Rarity;

import java.util.*;

public class HolographicCardItem extends TrinketItem {
    public HolographicCardItem(Settings settings) {
        super(settings);
    }

    private static final ArrayList<Pair<EntityAttribute,EntityAttributeModifier>> attributes =
            new ArrayList<>( List.of(
                    new Pair<>(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.fromString("5b579426-fb38-11ee-a951-0242ac120002"), "card_attribute_modifier", 1.0, EntityAttributeModifier.Operation.ADDITION)),
                    new Pair<>(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.fromString("5b579426-fb38-11ee-a951-0242ac120002"), "card_attribute_modifier", 0.05, EntityAttributeModifier.Operation.MULTIPLY_BASE)),
                    new Pair<>(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(UUID.fromString("5b579426-fb38-11ee-a951-0242ac120002"), "card_attribute_modifier", 2.0, EntityAttributeModifier.Operation.ADDITION)),
                    new Pair<>(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(UUID.fromString("5b579426-fb38-11ee-a951-0242ac120002"), "card_attribute_modifier", 0.1, EntityAttributeModifier.Operation.MULTIPLY_BASE)),
                    new Pair<>(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(UUID.fromString("5b579426-fb38-11ee-a951-0242ac120002"), "card_attribute_modifier", 0.5, EntityAttributeModifier.Operation.ADDITION)),
                    new Pair<>(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(UUID.fromString("5b579426-fb38-11ee-a951-0242ac120002"), "card_attribute_modifier", 0.025, EntityAttributeModifier.Operation.MULTIPLY_BASE)),
                    new Pair<>(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(UUID.fromString("5b579426-fb38-11ee-a951-0242ac120002"), "card_attribute_modifier", 0.05, EntityAttributeModifier.Operation.MULTIPLY_BASE)),
                    new Pair<>(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(UUID.fromString("5b579426-fb38-11ee-a951-0242ac120002"), "card_attribute_modifier", 0.05, EntityAttributeModifier.Operation.MULTIPLY_BASE)),
                    new Pair<>(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(UUID.fromString("5b579426-fb38-11ee-a951-0242ac120002"), "card_attribute_modifier", 0.025, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)),
                    new Pair<>(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(UUID.fromString("5b579426-fb38-11ee-a951-0242ac120002"), "card_attribute_modifier", 0.25, EntityAttributeModifier.Operation.ADDITION)),
                    new Pair<>(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(UUID.fromString("5b579426-fb38-11ee-a951-0242ac120002"), "card_attribute_modifier", 0.025, EntityAttributeModifier.Operation.ADDITION)),
                    new Pair<>(EntityAttributes.GENERIC_LUCK, new EntityAttributeModifier(UUID.fromString("5b579426-fb38-11ee-a951-0242ac120002"), "card_attribute_modifier", 1.0, EntityAttributeModifier.Operation.ADDITION)),
                    new Pair<>(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(UUID.fromString("5b579426-fb38-11ee-a951-0242ac120002"), "card_attribute_modifier", 0.1, EntityAttributeModifier.Operation.MULTIPLY_BASE))
            ));

    public static void assignHolographic(ItemStack stack, PlayerEntity entity) {
        NbtCompound nbt = stack.getOrCreateNbt();
        if (!nbt.contains("holographic")) {
            int holo = entity.getRandom().nextInt(10);
            nbt.putBoolean("holographic",holo == 0);
            if (holo == 0){
                int selection = entity.getRandom().nextInt(attributes.size());
                nbt.putInt("attribute_selection",selection);
            }
        }
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        Multimap<EntityAttribute, EntityAttributeModifier> map = super.getModifiers(stack, slot, entity, uuid);
        NbtCompound nbt = stack.getOrCreateNbt();
        if (nbt.getBoolean("holographic")) {
            int selection = nbt.getInt("attribute_selection");
            Pair<EntityAttribute,EntityAttributeModifier> pair = attributes.get(selection);
            map.put(pair.getLeft(),pair.getRight());
        }
        return map;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        if (nbt == null) return false;
        return nbt.getBoolean("holographic");
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        if (nbt == null) return super.getRarity(stack);
        return nbt.getBoolean("holographic") ? Rarity.EPIC : super.getRarity(stack);
    }
}
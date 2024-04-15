package dev.timefall.cards_of_timefall.registry;

import dev.timefall.cards_of_timefall.CardsOfTimefall;
import dev.timefall.cards_of_timefall.status.CustomStatusEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class StatusEffectsRegistry {

    public static final StatusEffect QUICKENING = Registry.register(Registries.STATUS_EFFECT, CardsOfTimefall.identity("quickening"), new CustomStatusEffect(StatusEffectCategory.BENEFICIAL, 0x7F7F2E)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,"d56f2fcc-fab5-11ee-a951-0242ac120002",0.01, EntityAttributeModifier.Operation.MULTIPLY_BASE));

    public static final StatusEffect STRENGTHENING = Registry.register(Registries.STATUS_EFFECT, CardsOfTimefall.identity("strengthening"),new CustomStatusEffect(StatusEffectCategory.BENEFICIAL, 0x7F7F2E)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,"803a4e24-fabf-11ee-a951-0242ac120002",0.01, EntityAttributeModifier.Operation.MULTIPLY_BASE));

    public static final StatusEffect HASTENING = Registry.register(Registries.STATUS_EFFECT, CardsOfTimefall.identity("hastening"),new CustomStatusEffect(StatusEffectCategory.BENEFICIAL, 0x7F7F2E)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,"c51def9c-fac8-11ee-a951-0242ac120002",0.1, EntityAttributeModifier.Operation.MULTIPLY_BASE));

    public static void init() {
    }

}
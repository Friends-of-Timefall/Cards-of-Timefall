package dev.timefall.cards_of_timefall.registry;

import dev.timefall.cards_of_timefall.CardsOfTimefall;
import dev.timefall.cards_of_timefall.modifier.ModifierConsumers;
import dev.timefall.cards_of_timefall.modifier.ModifierFunctions;
import me.fzzyhmstrs.fzzy_core.registry.ModifierRegistry;
import me.fzzyhmstrs.gear_core.modifier_util.EquipmentModifier;
import net.minecraft.util.Formatting;

public class ModifiersRegistry {

    public static final EquipmentModifier CHRONOS = new EquipmentModifier(CardsOfTimefall.identity("modifier_chronos"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withPostHit(ModifierConsumers.CHRONOS_CONSUMER)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier CUP = new EquipmentModifier(CardsOfTimefall.identity("modifier_cup"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.CUP_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier ETERNAL = new EquipmentModifier(CardsOfTimefall.identity("modifier_eternal"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnDamaged(ModifierFunctions.ETERNAL_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier FZZY = new EquipmentModifier(CardsOfTimefall.identity("modifier_fzzy"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withPostMine(ModifierConsumers.FZZY_CONSUMER)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier GHOST = new EquipmentModifier(CardsOfTimefall.identity("modifier_ghost"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnDamaged(ModifierFunctions.GHOST_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier KAMI = new EquipmentModifier(CardsOfTimefall.identity("modifier_kami"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.KAMI_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier KUDOS = new EquipmentModifier(CardsOfTimefall.identity("modifier_kudos"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withTick(ModifierConsumers.KUDOS_CONSUMER)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier MTIJGER = new EquipmentModifier(CardsOfTimefall.identity("modifier_mtijger"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.MTIJGER_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier PHOENIX = new EquipmentModifier(CardsOfTimefall.identity("modifier_phoenix"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withTick(ModifierConsumers.PHOENIX_CONSUMER)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier SNOW = new EquipmentModifier(CardsOfTimefall.identity("modifier_snow"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.SNOW_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier SOLACE = new EquipmentModifier(CardsOfTimefall.identity("modifier_solace"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.SOLACE_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier SWEENEY = new EquipmentModifier(CardsOfTimefall.identity("modifier_sweeney"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withPostHit(ModifierConsumers.SWEENEY_CONSUMER)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier TAMAKI = new EquipmentModifier(CardsOfTimefall.identity("modifier_tamaki"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.TAMAKI_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier TIMEFALL = new EquipmentModifier(CardsOfTimefall.identity("modifier_timefall"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.TIMEFALL_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier TOBOE = new EquipmentModifier(CardsOfTimefall.identity("modifier_toboe"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withKilledOther(ModifierConsumers.TOBOE_CONSUMER)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier WAGON = new EquipmentModifier(CardsOfTimefall.identity("modifier_wagon"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.WAGON_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);
    public static final EquipmentModifier ZARRA = new EquipmentModifier(CardsOfTimefall.identity("modifier_zarra"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withTick(ModifierConsumers.ZARRA_CONSUMER)
            .withCustomFormatting(Formatting.GOLD);

    public static void init(){
        ModifierRegistry.INSTANCE.register(CHRONOS);
        ModifierRegistry.INSTANCE.register(CUP);
        ModifierRegistry.INSTANCE.register(ETERNAL);
        ModifierRegistry.INSTANCE.register(FZZY);
        ModifierRegistry.INSTANCE.register(GHOST);
        ModifierRegistry.INSTANCE.register(KAMI);
        ModifierRegistry.INSTANCE.register(KUDOS);
        ModifierRegistry.INSTANCE.register(MTIJGER);
        ModifierRegistry.INSTANCE.register(PHOENIX);
        ModifierRegistry.INSTANCE.register(SNOW);
        ModifierRegistry.INSTANCE.register(SOLACE);
        ModifierRegistry.INSTANCE.register(SWEENEY);
        ModifierRegistry.INSTANCE.register(TAMAKI);
        ModifierRegistry.INSTANCE.register(TIMEFALL);
        ModifierRegistry.INSTANCE.register(TOBOE);
        ModifierRegistry.INSTANCE.register(WAGON);
        ModifierRegistry.INSTANCE.register(ZARRA);
    }

}
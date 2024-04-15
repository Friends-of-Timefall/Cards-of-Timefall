package dev.timefall.cards_of_timefall.registry;

import dev.timefall.cards_of_timefall.CardsOfTimefall;
import dev.timefall.cards_of_timefall.modifier.ModifierConsumers;
import dev.timefall.cards_of_timefall.modifier.ModifierFunctions;
import me.fzzyhmstrs.fzzy_core.registry.ModifierRegistry;
import me.fzzyhmstrs.gear_core.modifier_util.EquipmentModifier;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Formatting;

public class ModifiersRegistry {

    public static final EquipmentModifier TIMEFALL = new EquipmentModifier(CardsOfTimefall.identity("modifier_timefall"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.TIMEFALL_FUNCTION)
            .withAttributeModifier(EntityAttributes.GENERIC_ARMOR,1.0, EntityAttributeModifier.Operation.ADDITION)
            .withAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,1.0, EntityAttributeModifier.Operation.ADDITION)
            .withAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.05, EntityAttributeModifier.Operation.MULTIPLY_BASE)
            .withCustomFormatting(Formatting.GOLD);

    //////////////////////

    public static final EquipmentModifier CHORSE = new EquipmentModifier(CardsOfTimefall.identity("modifier_chorse"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.CHORSE_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);

    public static final EquipmentModifier ELDER_GUARDIAN = new EquipmentModifier(CardsOfTimefall.identity("modifier_elder_guardian"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.ELDER_GUARDIAN_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);

    public static final EquipmentModifier WARDEN = new EquipmentModifier(CardsOfTimefall.identity("modifier_warden"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withTick(ModifierConsumers.WARDEN_CONSUMER)
            .withAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH,2.0, EntityAttributeModifier.Operation.ADDITION)
            .withAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,2.0, EntityAttributeModifier.Operation.ADDITION)
            .withCustomFormatting(Formatting.GOLD);

    public static final EquipmentModifier WITHER = new EquipmentModifier(CardsOfTimefall.identity("modifier_wither"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withPostHit(ModifierConsumers.WITHER_CONSUMER)
            .withCustomFormatting(Formatting.GOLD);

    ////////////////////////////

    public static final EquipmentModifier BLAZE = new EquipmentModifier(CardsOfTimefall.identity("modifier_blaze"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.BLAZE_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);

    public static final EquipmentModifier CAVE_SPIDER = new EquipmentModifier(CardsOfTimefall.identity("modifier_cave_spider"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withPostHit(ModifierConsumers.CAVE_SPIDER_CONSUMER)
            .withCustomFormatting(Formatting.GOLD);

    public static final EquipmentModifier CREEPER = new EquipmentModifier(CardsOfTimefall.identity("modifier_creeper"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.CREEPER_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);

    public static final EquipmentModifier ENDERMAN = new EquipmentModifier(CardsOfTimefall.identity("modifier_enderman"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withTick(ModifierConsumers.ENDERMAN_CONSUMER)
            .withAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH,4.0, EntityAttributeModifier.Operation.ADDITION)
            .withCustomFormatting(Formatting.GOLD);

    public static final EquipmentModifier IRON_GOLEM = new EquipmentModifier(CardsOfTimefall.identity("modifier_iron_golem"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withAttributeModifier(EntityAttributes.GENERIC_ARMOR,4.0, EntityAttributeModifier.Operation.ADDITION)
            .withAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,-0.15, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .withCustomFormatting(Formatting.GOLD);

    public static final EquipmentModifier SKELETON = new EquipmentModifier(CardsOfTimefall.identity("modifier_skeleton"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.SKELETON_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);

    public static final EquipmentModifier ZOMBIE = new EquipmentModifier(CardsOfTimefall.identity("modifier_zombie"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withAttributeModifier(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,0.5, EntityAttributeModifier.Operation.ADDITION)
            .withCustomFormatting(Formatting.GOLD);

    ////////////////////////////

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

    public static final EquipmentModifier TOBOE = new EquipmentModifier(CardsOfTimefall.identity("modifier_toboe"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withKilledOther(ModifierConsumers.TOBOE_CONSUMER)
            .withCustomFormatting(Formatting.GOLD);

    public static final EquipmentModifier TOLLISH = new EquipmentModifier(CardsOfTimefall.identity("modifier_tollish"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnDamaged(ModifierFunctions.TOLLISH_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);

    public static final EquipmentModifier WAGON = new EquipmentModifier(CardsOfTimefall.identity("modifier_wagon"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withOnAttack(ModifierFunctions.WAGON_FUNCTION)
            .withCustomFormatting(Formatting.GOLD);

    public static final EquipmentModifier ZARRA = new EquipmentModifier(CardsOfTimefall.identity("modifier_zarra"), EquipmentModifier.EquipmentModifierTarget.Companion.getTRINKET(),1, EquipmentModifier.Rarity.RARE,true,false)
            .withTick(ModifierConsumers.ZARRA_CONSUMER)
            .withCustomFormatting(Formatting.GOLD);


    public static void init(){
        ModifierRegistry.INSTANCE.register(CHORSE);
        ModifierRegistry.INSTANCE.register(ELDER_GUARDIAN);
        ModifierRegistry.INSTANCE.register(WARDEN);
        ModifierRegistry.INSTANCE.register(WITHER);

        ModifierRegistry.INSTANCE.register(BLAZE);
        ModifierRegistry.INSTANCE.register(CAVE_SPIDER);
        ModifierRegistry.INSTANCE.register(CREEPER);
        ModifierRegistry.INSTANCE.register(ENDERMAN);
        ModifierRegistry.INSTANCE.register(IRON_GOLEM);
        ModifierRegistry.INSTANCE.register(SKELETON);
        ModifierRegistry.INSTANCE.register(ZOMBIE);

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
        ModifierRegistry.INSTANCE.register(TOLLISH);
        ModifierRegistry.INSTANCE.register(WAGON);
        ModifierRegistry.INSTANCE.register(ZARRA);
    }

}
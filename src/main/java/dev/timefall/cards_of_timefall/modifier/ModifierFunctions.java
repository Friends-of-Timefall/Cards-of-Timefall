package dev.timefall.cards_of_timefall.modifier;

import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import me.fzzyhmstrs.gear_core.modifier_util.EquipmentModifier;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.Objects;
import java.util.Optional;

public class ModifierFunctions {

    private static final TagKey<Item> daggers = TagKey.of(RegistryKeys.ITEM,new Identifier("c","weapons/daggers"));
    private static final TagKey<Item> shinies = TagKey.of(RegistryKeys.ITEM,new Identifier("cards_of_timefall","shinies"));

    public static EquipmentModifier.DamageFunction CHORSE_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        if(a == null) return am;
        if (u.getVehicle() == null) return am;
        return  am * 1.075f;
    };

    public static EquipmentModifier.DamageFunction ELDER_GUARDIAN_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        if (a == null) return am;
        a.damage(u.getDamageSources().thorns(a),3.0f);
        return am;
    };

    ////////////////////

    public static EquipmentModifier.DamageFunction BLAZE_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        if(!ds.isIn(DamageTypeTags.IS_FIRE)) return am;
        return  am * 0.8f;
    };

    public static EquipmentModifier.DamageFunction CREEPER_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        if(!ds.isIn(DamageTypeTags.IS_EXPLOSION)) return am;
        return  am * 0.8f;
    };

    public static EquipmentModifier.DamageFunction SKELETON_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        if(!ds.isIn(DamageTypeTags.IS_PROJECTILE)) return am;
        return  am * 1.03f;
    };

    ////////////////////

    public static EquipmentModifier.DamageFunction CUP_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        if(a == null) return am;
        float uRot = u.bodyYaw;
        float aRot = a.bodyYaw;
        if (MathHelper.angleBetween(uRot,aRot) <= 90f) return am * 1.05f;
        return  am;
    };

    public static EquipmentModifier.DamageFunction ETERNAL_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        int armor = u.getArmor();
        if (armor <= 16) return Math.max(0.5f,am - 0.25f);
        return  am;
    };

    public static EquipmentModifier.DamageFunction KAMI_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        if (!s.isIn(daggers)) return am;
        return am * 1.05f;
    };

    public static EquipmentModifier.DamageFunction GHOST_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        if(a == null) return am;
        if (ds.getAttacker() == null || !(ds.getAttacker() instanceof LivingEntity)) return am;
        if (a.getGroup() != EntityGroup.UNDEAD && ((LivingEntity)ds.getAttacker()).getGroup() != EntityGroup.UNDEAD) return am;
        return am * 0.95f;
    };

    public static EquipmentModifier.DamageFunction MTIJGER_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        Optional<TrinketComponent> optional = TrinketsApi.getTrinketComponent(u);
        int count = 0;
        if (optional.isPresent()){
            count += optional.get().getAllEquipped().size();
        }
        if (u instanceof PlayerEntity){
            for (ItemStack stack : ((PlayerEntity)u).getInventory().main){
                if (stack.isIn(shinies) || stack.getItem() instanceof Trinket)
                    count++;
            }
            for (ItemStack stack : ((PlayerEntity)u).getInventory().offHand){
                if (stack.isIn(shinies) || stack.getItem() instanceof Trinket)
                    count++;
            }
            for (ItemStack stack : ((PlayerEntity)u).getInventory().armor){
                if (stack.isIn(shinies) || stack.getItem() instanceof Trinket)
                    count++;
            }
        }
        return am * (1f + (count * 0.006f));
    };

    public static EquipmentModifier.DamageFunction SNOW_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        if (a == null) return am;
        if (a.getLastAttacker() == null) {
            a.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,100,1));
            return am * 1.1f;
        }
        return am;
    };

    public static EquipmentModifier.DamageFunction SOLACE_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        if(u.getWorld().isNight()) {
            return switch (u.getWorld().getMoonPhase()) {
                case 0 -> am * 1.125f;
                case 1, 7 -> am * 1.075f;
                case 3, 5 -> am * 1.02f;
                case 4 -> am * 0.975f;
                default -> am * 1.05f;
            };
        }
        return am;
    };

    public static EquipmentModifier.DamageFunction TAMAKI_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        Item item = s.getItem();
        if (!(item instanceof BowItem) && !(item instanceof CrossbowItem)) return am;
        return u.getRandom().nextFloat() < 0.05f ? am * 1.5f : am;
    };

    public static EquipmentModifier.DamageFunction TIMEFALL_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        Identifier id = Registries.ITEM.getId(s.getItem());
        if (Objects.equals(id.getNamespace(), "mcdw") || Objects.equals(id.getNamespace(), "simplyswords")) return am * 1.075f;
        return am;
    };

    public static EquipmentModifier.DamageFunction TOLLISH_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        if (!ds.isIn(DamageTypeTags.IS_FALL) && !ds.isIn(DamageTypeTags.DAMAGES_HELMET)) return am;
        return am * 0.75f;
    };


    public static EquipmentModifier.DamageFunction WAGON_FUNCTION = (ItemStack s, LivingEntity u, LivingEntity a, DamageSource ds, float am) -> {
        if(u.isFallFlying()) return am * 1.05f;
        return am;
    };

}
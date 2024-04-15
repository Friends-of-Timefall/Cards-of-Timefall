package dev.timefall.cards_of_timefall.modifier;

import dev.timefall.cards_of_timefall.registry.StatusEffectsRegistry;
import me.fzzyhmstrs.gear_core.modifier_util.EquipmentModifier;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModifierConsumers {

    private static final TagKey<Item> daggers = TagKey.of(RegistryKeys.ITEM,new Identifier("c","weapons/daggers"));
    private static final TagKey<Item> gauntlets = TagKey.of(RegistryKeys.ITEM,new Identifier("c","weapons/gaunlets"));
    private static List<StatusEffect> effects = null;

    public static EquipmentModifier.ToolConsumer WARDEN_CONSUMER = (itemStack, user, target) -> {
        if (user.getWorld().getTime() % 20 != 0L) return;
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,100));
    };

    public static EquipmentModifier.ToolConsumer WITHER_CONSUMER = (itemStack, user, target) -> {
        if (target == null) return;
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,80,1));
    };

    ///////////////////////

    public static EquipmentModifier.ToolConsumer CAVE_SPIDER_CONSUMER = (itemStack, user, target) -> {
        if (target == null) return;
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,100,0));
    };

    public static EquipmentModifier.ToolConsumer ENDERMAN_CONSUMER = (itemStack, user, target) -> {
        if (user.getWorld().getTime() % 40 != 0L) return;
        if (user.isWet())
            user.damage(user.getDamageSources().drown(), 1.0f);
    };

    ///////////////////////

    public static EquipmentModifier.ToolConsumer CHRONOS_CONSUMER = (itemStack, user, target) -> {
        ItemStack main = user.getMainHandStack();
        ItemStack off = user.getMainHandStack();
        if (main.isEmpty() || off.isEmpty()) return;
        if (user.getWorld().random.nextFloat() > 0.25f) return;
        if (!main.isIn(daggers) && !main.isIn(gauntlets)) return;
        if (!off.isIn(daggers) && !off.isIn(gauntlets)) return;
        if (user.hasStatusEffect(StatusEffectsRegistry.QUICKENING)){
            StatusEffectInstance instance = user.getStatusEffect(StatusEffectsRegistry.QUICKENING);
            if (instance == null) return;
            int amp = Math.min(9, instance.getAmplifier() + 1);
            user.addStatusEffect(new StatusEffectInstance(StatusEffectsRegistry.QUICKENING,160,amp));
        } else {
            user.addStatusEffect(new StatusEffectInstance(StatusEffectsRegistry.QUICKENING,160,0));
        }
    };

    public static EquipmentModifier.MiningConsumer FZZY_CONSUMER = (itemStack, world, blockState, blockPos, playerEntity) -> {
        if (world.isClient()) return;
        if (!(blockState.getBlock() instanceof ExperienceDroppingBlock)) return;
        if (playerEntity.getRandom().nextFloat() > 0.25f) return;
        ExperienceOrbEntity.spawn((ServerWorld) world, blockPos.toCenterPos(), 1);
    };

    public static EquipmentModifier.ToolConsumer KUDOS_CONSUMER = (itemStack, user, target) -> {
        if (user.getWorld().getTime() % 20 != 0L) return;
        if(user.getWorld().getBiome(user.getBlockPos()).isIn(BiomeTags.IS_FOREST)){
            user.addStatusEffect(new StatusEffectInstance(StatusEffectsRegistry.HASTENING,200,0));
        }
    };

    public static EquipmentModifier.ToolConsumer PHOENIX_CONSUMER = (itemStack, user, target) -> {
        if (user.getWorld().getTime() % 20 != 0L) return;
        if (user.getFireTicks() == 0) return;
        List<Entity> entities = user.getWorld().getOtherEntities(null,user.getBoundingBox().expand(6.0),e -> e instanceof Tameable || e instanceof PlayerEntity);
        for (Entity entity : entities){
            if (!(entity instanceof LivingEntity)) continue;
            ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,100,0));
        }
    };

    public static EquipmentModifier.ToolConsumer SWEENEY_CONSUMER = (itemStack, user, target) -> {
        if (user.getRandom().nextFloat() > 0.35f) return;

        if (!(itemStack.getItem() instanceof SwordItem && user.getOffHandStack().isEmpty())) return;
        if (effects == null) {
            effects = Registries.STATUS_EFFECT.stream().filter(StatusEffect::isBeneficial).toList();
        }
        int size = effects.size();
        int rand = user.getRandom().nextInt(size);
        user.addStatusEffect(new StatusEffectInstance(effects.get(rand),140,0));
    };

    public static EquipmentModifier.ToolConsumer TOBOE_CONSUMER = (itemStack, user, target) -> {
        List<Entity> entities = user.getWorld().getOtherEntities(user,user.getBoundingBox().expand(6.0),e -> e instanceof Tameable);
        for (Entity entity : entities){
            if (!(entity instanceof LivingEntity)) continue;
            ((LivingEntity)entity).heal(0.5f);
        }
        if (entities.size() > 0){
            if (user.hasStatusEffect(StatusEffectsRegistry.STRENGTHENING)){
                StatusEffectInstance instance = user.getStatusEffect(StatusEffectsRegistry.STRENGTHENING);
                if (instance == null) return;
                int amp = Math.min(9, instance.getAmplifier() + 1);
                user.addStatusEffect(new StatusEffectInstance(StatusEffectsRegistry.STRENGTHENING,200,amp));
            } else {
                user.addStatusEffect(new StatusEffectInstance(StatusEffectsRegistry.STRENGTHENING,200,0));
            }
        }
    };

    public static EquipmentModifier.ToolConsumer ZARRA_CONSUMER = (itemStack, user, target) -> {
        if (user.getWorld().getTime() % 20 != 0L) return;
        List<Entity> entities = user.getWorld().getOtherEntities(user,user.getBoundingBox().expand(6.0),e -> e instanceof Tameable);
        for (Entity entity : entities){
            if (!(entity instanceof LivingEntity)) continue;
            ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffectsRegistry.STRENGTHENING,100,4));
        }
    };


}
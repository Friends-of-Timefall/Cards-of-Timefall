package dev.timefall.cards_of_timefall.item;

import dev.timefall.cards_of_timefall.CardsOfTimefall;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class CardPackItem extends Item {
    public CardPackItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("item.cards_of_timefall.card_pack.flavor").formatted(Formatting.ITALIC));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (stack.isEmpty()) return TypedActionResult.fail(stack);
        if (user.getWorld().isClient()) return TypedActionResult.fail(stack);
        LootTable lootTable = Objects.requireNonNull(user.getWorld().getServer()).getLootManager().getLootTable(CardsOfTimefall.cardsLoot);
        LootContextParameterSet.Builder builder = new LootContextParameterSet.Builder((ServerWorld)user.getWorld()).add(LootContextParameters.THIS_ENTITY,user).add(LootContextParameters.ORIGIN, user.getPos());
        LootContextParameterSet lootContextParameterSet = builder.build(LootContextTypes.ADVANCEMENT_REWARD);
        ObjectArrayList<ItemStack> stacks =  lootTable.generateLoot(lootContextParameterSet, user.getLootTableSeed());
        if (!user.isCreative())
            stack.decrement(1);
        for (ItemStack s : stacks){
            if (s.getItem() instanceof HolographicCardItem) {
                HolographicCardItem.assignHolographic(s, user);
            }
            user.getInventory().offerOrDrop(s);
        }
        user.getWorld().playSound(null,user.getBlockPos(), SoundEvents.ITEM_BOOK_PAGE_TURN, SoundCategory.PLAYERS,0.75f,1f);
        return TypedActionResult.success(stack);
    }
}
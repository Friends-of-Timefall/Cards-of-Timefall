package dev.timefall.cards_of_timefall.client;

import dev.timefall.cards_of_timefall.registry.ItemsRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class CardsOfTimefallClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelPredicateProviderRegistry.register(ItemsRegistry.CARD_ENDERMAN,new Identifier("selected"),(stack,world,entity,seed) -> {
            if (entity == null) return 0.0f;
            if (!(entity instanceof PlayerEntity playerEntity)) return 0.0f;
            if (playerEntity.getInventory().getSlotWithStack(stack) == playerEntity.getInventory().selectedSlot) return 1.0f;
            return 0.0f;
        });
    }
}
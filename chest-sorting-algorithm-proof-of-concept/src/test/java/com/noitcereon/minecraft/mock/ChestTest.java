package com.noitcereon.minecraft.mock;

import com.noitcereon.exceptions.OperationException;
import com.noitcereon.helpers.ChestFactory;
import com.noitcereon.helpers.ItemStackFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChestTest {

    @Test
    void givenEmptyChestAndAnItem_whenAddingItem_thenReturnAddedItem() {
        Chest chest = ChestFactory.createSingleChestEmpty();
        ItemStack expected = ItemStackFactory.createRandomItemStack();

        ItemStack actual = chest.addToStorage(1, expected);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenNonEmptyChestAndAnItem_whenAddingItemToOccupiedSpot_thenThrowOperationException() {
        Chest chest = ChestFactory.createSingleChestWithItems();
        ItemStack itemStack = ItemStackFactory.createRandomItemStack();

        Assertions.assertThrows(OperationException.class, () -> {
            chest.addToStorage(1, itemStack);
        });
    }
}
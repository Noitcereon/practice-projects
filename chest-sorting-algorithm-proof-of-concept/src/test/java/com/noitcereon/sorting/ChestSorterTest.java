package com.noitcereon.sorting;

import com.noitcereon.helpers.ChestFactory;
import com.noitcereon.minecraft.mock.Chest;
import com.noitcereon.minecraft.mock.ItemStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ChestSorterTest {

    private ChestSorter chestSorter;

    @BeforeEach
    void setUp() {
        chestSorter = new ChestSorter();
    }

    @Test
    void givenEmptySingleChest_whenSortingChest_thenReturnEmptyChest() {
        Chest chest = ChestFactory.createSingleChestEmpty();
        boolean expected = true;
        Chest sortedChest = chestSorter.sort(chest);
        boolean actual = sortedChest.isEmpty();

        assertEquals(expected, actual);
    }

    @Test
    void givenPartiallyFilledSingleChest_whenSortingChest_thenReturnChestSortedByAscendingId() {
        Chest chest = ChestFactory.createSingleChestWithItems();
        Chest sortedChest = chestSorter.sort(chest);

        assertChestContentIsInAscendingOrder(sortedChest);
    }

    private void assertChestContentIsInAscendingOrder(Chest sortedChest) {
        int previousValueItemId = -1;
        int previousKey = -1;
        for (Map.Entry<Integer, ItemStack> entry : sortedChest.getInventoryMap().entrySet()) {
            int key = entry.getKey();
            ItemStack value = entry.getValue();
            if (previousValueItemId == -1) {
                previousValueItemId = value.getItem().getItemId();
                previousKey = key;
                continue;
            }

            if (!itemIdIsLargerOrEqualComparedToPreviousValue(previousValueItemId, previousKey, key, value))
                fail("Not sorted in ascending order");
            previousValueItemId = value.getItem().getItemId();
            previousKey = key;
        }
    }

    private boolean itemIdIsLargerOrEqualComparedToPreviousValue(int previousValueItemId, int previousKey, int key, ItemStack value) {
        // Current item id is larger AND key is larger than previous
        return value.getItem().getItemId() >= previousValueItemId && key > previousKey;
    }
}
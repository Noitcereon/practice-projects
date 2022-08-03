package com.noitcereon.sorting;

import com.noitcereon.helpers.ChestFactory;
import com.noitcereon.minecraft.mock.Chest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void givenPartiallyFilledSingleChest_whenSortingChest_thenReturnChestSortedByAscendingId(){
        // TODO: implement givenPartiallyFilledSingleChest_whenSortingChest_thenReturnChestSortedByAscendingId test
        fail("Test not implemented");
    }
}
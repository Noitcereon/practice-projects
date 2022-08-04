package com.noitcereon.helpers;

import com.noitcereon.minecraft.mock.Chest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChestFactoryTest {

    @Test
    void givenAnEmptyChestNeedsToBeCreated_whenCreatingEmptySingleChest_thenChestIsEmpty() {
        Chest chest = ChestFactory.createSingleChestEmpty();
        int expected = 0;
        int actual = chest.getInventoryMap().size();
        assertEquals(expected, actual);
    }

    @Test
    void givenAnEmptyChestNeedsToBeCreated_whenCreatingEmptyDoubleChest_thenChestIsEmpty() {
        Chest chest = ChestFactory.createDoubleChestEmpty();
        int expected = 0;
        int actual = chest.getInventoryMap().size();
        assertEquals(expected, actual);
    }

    @Test
    void givenAPartiallyFilledChestNeedsToBeCreated_whenCreatingSingleChest_thenChestIsNotEmpty() {
        Chest chest = ChestFactory.createSingleChestWithItems();
        boolean expected = false;
        boolean actual = chest.getInventoryMap().isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    void givenAPartiallyFilledChestNeedsToBeCreated_whenCreatingDoubleChest_thenChestIsNotEmpty() {
        Chest chest = ChestFactory.createDoubleChestWithItems();
        boolean expected = false;
        boolean actual = chest.getInventoryMap().isEmpty();
        assertEquals(expected, actual);
    }
    @Test
    void givenAChestWith4StacksOf32DirtNeedsToBeCreated_whenCreatingSaidChest_thenItContains4Stacks(){
        Chest chest = ChestFactory.createChest(false, 4, ItemFactory.createDirt(), 32);
        int expected = 4;
        int actual = chest.getInventoryMap().size();
        assertEquals(expected, actual);
    }
}
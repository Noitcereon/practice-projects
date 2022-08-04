package com.noitcereon.helpers;

import com.noitcereon.exceptions.NotImplementedException;
import com.noitcereon.minecraft.mock.Chest;
import com.noitcereon.minecraft.mock.Item;
import com.noitcereon.minecraft.mock.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ChestFactory {
    public static Chest createSingleChestEmpty(){
        return new Chest(false);
    }
    public static Chest createDoubleChestEmpty(){
        return new Chest(true);
    }
    public static Chest createSingleChestWithItems(){
        Chest chest = new Chest(false);
        return addMultipleItems(chest);
    }
    public static Chest createDoubleChestWithItems(){
        Chest chest = new Chest(true);
        return addMultipleItems(chest);
    }
    public static Chest createChest(boolean isDoubleChest, int itemStacksWithin, Item itemInStack, int amountInEachStack){
        Chest chest = new Chest(isDoubleChest);

        Map<Integer, ItemStack> inventory = new HashMap<>();
        for(int i=1; i <= itemStacksWithin; i++){
            ItemStack stack = ItemStackFactory.createItemStack(amountInEachStack, itemInStack);
            inventory.put(i, stack);
        }
        chest.setInventoryMap(inventory);
        return chest;
    }
    public static Chest createChest(boolean isDoubleChest, Map<Integer, ItemStack> chestInventory){
        return new Chest(isDoubleChest, chestInventory);
    }

    private static Chest addMultipleItems(Chest chest) {
        chest.addToStorage(1, ItemStackFactory.createRandomItemStack());
        chest.addToStorage(2, ItemStackFactory.createRandomItemStack());
        chest.addToStorage(3, ItemStackFactory.createRandomItemStack());
        chest.addToStorage(4, ItemStackFactory.createRandomItemStack());
        chest.addToStorage(5, ItemStackFactory.createRandomItemStack());
        chest.addToStorage(6, ItemStackFactory.createRandomItemStack());
        chest.addToStorage(7, ItemStackFactory.createRandomItemStack());
        chest.addToStorage(8, ItemStackFactory.createRandomItemStack());
        chest.addToStorage(9, ItemStackFactory.createRandomItemStack());
        return chest;
    }
}

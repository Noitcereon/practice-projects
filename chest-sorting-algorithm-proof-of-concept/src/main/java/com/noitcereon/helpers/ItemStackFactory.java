package com.noitcereon.helpers;

import com.noitcereon.minecraft.mock.Item;
import com.noitcereon.minecraft.mock.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public class ItemStackFactory {

    private static final ArrayList<Item> availableItems = ItemFactory.getItems();

    public static ItemStack createRandomItemStack(){
        Random random = new Random();
        int index = random.nextInt(availableItems.size());

        Item item = availableItems.get(index);
        return new ItemStack(item);
    }
    public static ItemStack createItemStack(int amount, Item item){
        return new ItemStack(amount, item);
    }
}

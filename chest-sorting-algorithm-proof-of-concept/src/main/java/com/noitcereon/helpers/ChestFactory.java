package com.noitcereon.helpers;

import com.noitcereon.exceptions.NotImplementedException;
import com.noitcereon.minecraft.mock.Chest;

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

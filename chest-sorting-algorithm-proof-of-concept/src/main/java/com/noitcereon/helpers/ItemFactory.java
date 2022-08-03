package com.noitcereon.helpers;

import com.noitcereon.minecraft.mock.Item;

import java.util.ArrayList;

public class ItemFactory {
    public static Item createPickaxe(){
        return new Item(1, "Stone Pickaxe");
    }
    public static Item createWoodBlock(){
        return new Item(2, "Oak Wood");
    }
    public static Item createDirt(){
        return new Item(3, "Dirt");
    }
    public static Item createStone(){
        return new Item(4, "Stone");
    }
    public static Item createEgg(){
        return new Item(5, "Egg");
    }

    public static ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<>();
        items.add(createPickaxe());
        items.add(createDirt());
        items.add(createStone());
        items.add(createEgg());
        items.add(createWoodBlock());
        return items;
    }
}

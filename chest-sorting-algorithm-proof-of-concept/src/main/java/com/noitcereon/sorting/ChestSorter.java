package com.noitcereon.sorting;


import com.noitcereon.minecraft.mock.Chest;
import com.noitcereon.minecraft.mock.ItemStack;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class ChestSorter {
    public Chest sort(Chest chest) {
        Chest output = new Chest(chest.isDoubleChest(), chest.getInventoryMap());



        return output;
    }
}

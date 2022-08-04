package com.noitcereon.sorting;


import com.noitcereon.minecraft.mock.Chest;
import com.noitcereon.minecraft.mock.ItemStack;

import java.util.*;
import java.util.stream.Collectors;

public class ChestSorter {
    public Chest sort(Chest chest) {
        Chest output = new Chest(chest.isDoubleChest(), chest.getInventoryMap());

        Map<Integer, ItemStack> inventoryMap = output.getInventoryMap();

        List<Map.Entry<Integer, ItemStack>> sortedEntries = inventoryMap.entrySet().stream().sorted((entry, entry2) -> {
            int itemId = entry.getValue().getItem().getItemId();
            int itemId2 = entry2.getValue().getItem().getItemId();

            return Integer.compare(itemId, itemId2);
        }).toList();
        Map<Integer, ItemStack> sortedInventoryMap = new HashMap<>();
        int nextSpot = 1;
        for(var entry : sortedEntries){
            sortedInventoryMap.putIfAbsent(nextSpot, entry.getValue());
            nextSpot++;
        }
        output.setInventoryMap(sortedInventoryMap);
        return output;
    }
}

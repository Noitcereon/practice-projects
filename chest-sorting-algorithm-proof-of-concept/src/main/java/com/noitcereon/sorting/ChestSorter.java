package com.noitcereon.sorting;


import com.noitcereon.minecraft.mock.Chest;
import com.noitcereon.minecraft.mock.Item;
import com.noitcereon.minecraft.mock.ItemStack;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChestSorter {
    public Chest sort(Chest chest) {
        Chest output = new Chest(chest.isDoubleChest(), chest.getInventoryMap());

        Map<Integer, ItemStack> inventoryMap = output.getInventoryMap();

        List<Map.Entry<Integer, ItemStack>> entriesWithValueSorted = inventoryMap.entrySet().stream().sorted((entry, entry2) -> {
            int itemId = entry.getValue().getItem().getItemId();
            int itemId2 = entry2.getValue().getItem().getItemId();

            return Integer.compare(itemId, itemId2);
        }).toList();

        Map<Integer, ItemStack> sortedInventoryMap = new HashMap<>();

        int nextSpot = 1;
        ArrayList<Integer> entryKeysMarkedForRemoval = new ArrayList<>();
        for (var entry : entriesWithValueSorted) {
            if (entryKeysMarkedForRemoval.contains(entry.getKey())) continue;
            ItemStack stack = entry.getValue();
            if (itemStacksOfTheSameItemExists(entriesWithValueSorted, stack.getItem()) && stack.getItem().getMaxStackSize() != 1) {
                // Find all items with the same id
                List<Map.Entry<Integer, ItemStack>> stacksOfTheSameItem = entriesWithValueSorted
                        .stream()
                        .filter(entryValueHasTheSameItemId(stack))
                        .toList();

                // Combine them and...
                Collection<ItemStack> combinedStacks = combineStacksOfTheSameItem(stacksOfTheSameItem);
                // ... Add mark entries used during combination for removal
                stacksOfTheSameItem.forEach(x -> entryKeysMarkedForRemoval.add(x.getKey()));
                // Add the combined stacks to chest inventory
                for (ItemStack combinedStack : combinedStacks) {
                    sortedInventoryMap.put(nextSpot, combinedStack);
                    nextSpot++;
                }
            } else {
                sortedInventoryMap.putIfAbsent(nextSpot, entry.getValue());
            }
            nextSpot++;
        }
        output.setInventoryMap(sortedInventoryMap);
        return output;
    }

    private boolean itemStacksOfTheSameItemExists(List<Map.Entry<Integer, ItemStack>> entriesWithValueSorted, Item item) {
        int count = entriesWithValueSorted.stream().filter(entry -> entry.getValue().getItem().equals(item)).toList().size();
        return count > 1;
    }

    private Predicate<Map.Entry<Integer, ItemStack>> entryValueHasTheSameItemId(ItemStack stack) {
        return anyEntry -> anyEntry.getValue().getItem().getItemId()
                .equals(stack.getItem().getItemId());
    }

    private Collection<ItemStack> combineStacksOfTheSameItem(List<Map.Entry<Integer, ItemStack>> stacksOfTheSameItem) {
        Item item = stacksOfTheSameItem.get(1).getValue().getItem();
        ItemStack nonFullStack = new ItemStack(0, item);
        Collection<ItemStack> combinedStacks = new ArrayList<>();
        for (Map.Entry<Integer, ItemStack> entry : stacksOfTheSameItem) {
            int entryItemAmount = entry.getValue().getAmount();
            int newAmount = nonFullStack.getAmount() + entryItemAmount;
            if (newAmount >= item.getMaxStackSize()) {
                ItemStack fullStack = new ItemStack(item.getMaxStackSize(), item);
                combinedStacks.add(fullStack);
                newAmount -= item.getMaxStackSize();
            }
            nonFullStack.setAmount(newAmount);
        }
        if (nonFullStack.getAmount() > 0) combinedStacks.add(nonFullStack);
        return combinedStacks;
    }
}

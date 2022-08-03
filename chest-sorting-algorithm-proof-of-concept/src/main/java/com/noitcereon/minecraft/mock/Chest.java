package com.noitcereon.minecraft.mock;

import com.noitcereon.exceptions.OperationException;

import java.util.HashMap;
import java.util.Map;

public class Chest {
    private int storageSize;

    /**
     * Integer is the spot occupied in the Chest, ItemStack is the stack in that spot.
     */
    private Map<Integer, ItemStack> inventoryMap;
    private final int DOUBLE_CHEST_SIZE = 64;
    private final int SINGLE_CHEST_SIZE = 32;

    public Chest(boolean isDoubleChest) {
        if (isDoubleChest) storageSize = DOUBLE_CHEST_SIZE;
        else storageSize = SINGLE_CHEST_SIZE;
        inventoryMap = new HashMap<>(getStorageSize());
    }

    public Chest(boolean isDoubleChest, Map<Integer, ItemStack> inventoryMap) {
        if (isDoubleChest) storageSize = DOUBLE_CHEST_SIZE;
        else storageSize = SINGLE_CHEST_SIZE;
        setInventoryMap(inventoryMap);
    }

    public int getStorageSize() {
        return storageSize;
    }

    public boolean isDoubleChest() {
        return storageSize == DOUBLE_CHEST_SIZE;
    }
    public boolean isEmpty(){
        return getInventoryMap().isEmpty();
    }

    public Map<Integer, ItemStack> getInventoryMap() {
        return inventoryMap;
    }

    public void setInventoryMap(Map<Integer, ItemStack> inventoryMap) {
        if (inventoryMap.size() > storageSize)
            throw new IllegalArgumentException("The provided Map object is over the limit of" + storageSize, new Throwable("Size too large"));
        this.inventoryMap = inventoryMap;
    }

    /**
     * @param spot      The spot to place the item stack
     * @param itemStack A stack of items.
     * @return The itemStack added to the chest.
     */
    public ItemStack addToStorage(Integer spot, ItemStack itemStack) throws OperationException {
        if (inventoryMap.containsKey(spot)) {
            throw new OperationException(String.format("Tried to add %s in spot %d, but it was occupied", itemStack, spot));
        }
        inventoryMap.put(spot, itemStack);
        return inventoryMap.get(spot);
    }
}

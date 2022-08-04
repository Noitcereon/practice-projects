package com.noitcereon.minecraft.mock;

public class Item {
    private Integer itemId;
    private String name;
    private final Integer maxStackSize;

    public Item(Integer itemId, String name) {
        this.itemId = itemId;
        this.name = name;
        maxStackSize = 64;
    }
    public Item(Integer itemId, String name, Integer maxStackSize) {
        this.itemId = itemId;
        this.name = name;
        this.maxStackSize = maxStackSize;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getMaxStackSize() {
        return maxStackSize;
    }
    @Override
    public String toString() {
        return String.format("Item: { id: %d, name: %s}", getItemId(), getName());
    }


}

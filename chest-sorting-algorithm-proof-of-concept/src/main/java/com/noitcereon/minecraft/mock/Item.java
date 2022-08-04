package com.noitcereon.minecraft.mock;

public class Item {
    private Integer itemId;
    private String name;

    public Item(Integer itemId, String name) {
        this.itemId = itemId;
        this.name = name;
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

    @Override
    public String toString() {
        return String.format("Item: { id: %d, name: %s}", getItemId(), getName());
    }
}

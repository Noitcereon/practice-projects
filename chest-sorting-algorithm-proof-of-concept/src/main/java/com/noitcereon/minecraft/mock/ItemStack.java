package com.noitcereon.minecraft.mock;

import java.util.Map;

public class ItemStack {
    private int amount;
    private Item item;

    public ItemStack(Item item) {
        this.amount = 1;
        this.item = item;
    }

    public ItemStack(int amount, Item item) {
        this.amount = amount;
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return String.format("Amount: %d, Item: %s", amount, item);
    }
}

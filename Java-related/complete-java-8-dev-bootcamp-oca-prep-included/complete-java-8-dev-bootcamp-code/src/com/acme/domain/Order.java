package com.acme.domain;

import com.acme.utils.MyDate;

/**
 * The domain model representing an Order in the system.
 * Aside from holding information it can calculate the tax of an order or a specified amount based on the taxRate.
 */
public class Order {
    private MyDate orderDate;
    private double orderAmount = 0.00;
    private String customer;
    private String product;
    private int quantity;

    /**
     * The rate used to calculate the tax with. <br>
     * Default value: taxRate = 0.05.
     */
    private static double taxRate = 0.05;
    private static Rushable rushable;

    public Order(MyDate date, double amount, String customer, String productName, int quantity) {
        orderDate = date;
        orderAmount = amount;
        this.customer = customer;
        this.product = productName;
        this.quantity = quantity;
    }

    public static double computeTaxOn(double anAmount) {
        double tax = (anAmount * taxRate);
        System.out.println("The tax for " + anAmount + " is: " + tax);
        return tax;
    }

    public double computeTax() {
        double tax = (orderAmount * taxRate);
        System.out.println("The tax for this order is: " + tax);
        return tax;
    }


    public static void setTaxRate(double taxRate) {
        Order.taxRate = taxRate;
    }

    public boolean isPriorityOrder() {
        boolean priorityOrder = false;
        if (rushable != null) {
            priorityOrder = rushable.isRushable(orderDate, orderAmount);
        }
        return priorityOrder;
    }

    public MyDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(MyDate orderDate) {
        if (MyDate.isHoliday(orderDate)) {
            System.out.println("Order date (" + orderDate + ") cannot be set to a holiday!");
            return;
        }
        this.orderDate = orderDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static double getTaxRate() {
        return taxRate;
    }

    public static Rushable getRushable() {
        return rushable;
    }

    public static void setRushable(Rushable rushable) {
        Order.rushable = rushable;
    }

    public String toString() {
        return quantity + " ea. " + product + " for " + customer;
    }
}

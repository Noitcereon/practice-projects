package com.acme.domain;

import com.acme.utils.MyDate;

/**
 * The domain model representing an Order in the system.
 * Aside from holding information it can calculate the tax of an order or a specified amount based on the taxRate.
 */
public class Order {
    MyDate orderDate;
    double orderAmount = 0.00;
    String customer;
    String product;
    int quantity;
    /**
     * The rate used to calculate the tax with. <br>
     * Default value: taxRate = 0.05.
     */
    public static double taxRate = 0.05;

    public Order(MyDate date, double amount, String customer, String productName, int quantity) {
        orderDate = date;
        orderAmount = amount;
        this.customer = customer;
        this.product = productName;
        this.quantity = quantity;
    }
    public static double computeTaxOn(double anAmount){
        double tax = (anAmount * taxRate);
        System.out.println("The tax for " + anAmount + " is: " + tax);
        return tax;
    }
    public double computeTax(){
        double tax = (orderAmount * taxRate);
        System.out.println("The tax for this order is: " + tax);
        return tax;
    }
    public static void setTaxRate(double taxRate) {
        Order.taxRate = taxRate;
    }

    public String toString() {
        return quantity + " ea. " + product + " for " + customer;
    }
}

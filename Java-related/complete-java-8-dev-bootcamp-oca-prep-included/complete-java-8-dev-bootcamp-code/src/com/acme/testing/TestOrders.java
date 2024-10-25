package com.acme.testing;

import com.acme.utils.MyDate;
import com.acme.domain.Order;

import java.time.LocalDate;

public class TestOrders {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyDate date1 = new MyDate(1, 20, 2008);
        Order anvilOrder = new Order(date1, 2000.00, "Wile E Coyote", "Anvil", 10);

        MyDate date2 = new MyDate(4, 10, 2008);
        Order balloonOrder = new Order(date2, 1000.00, "Bugs Bunny", "Balloon", 125);

        System.out.println(anvilOrder);
        System.out.println(balloonOrder);

        System.out.println("The tax Rate is currently: " + Order.getTaxRate());
        Order.computeTaxOn(3000.00);
        anvilOrder.computeTax();
        balloonOrder.computeTax();

        Order.setTaxRate(0.06);
        System.out.println("The tax Rate is currently: " + Order.getTaxRate());
        Order.computeTaxOn(3000.00);
        anvilOrder.computeTax();
        balloonOrder.computeTax();

        printHeadline("Lab12_Lambda.pdf");
        Order.setRushable((orderDate, amount) -> amount > 1500);
        System.out.println(anvilOrder.getProduct() + " is a priority order: " + anvilOrder.isPriorityOrder()); // should return true.
        System.out.println(balloonOrder.getProduct() + " is a priority order: " + balloonOrder.isPriorityOrder()); // should return false.

        printHeadline("Lab13_DateTime.pdf");
        MyDate date3 = new MyDate(LocalDate.now().getMonthValue(), LocalDate.now().minusDays(15).getDayOfMonth(), LocalDate.now().getYear());
        Order hammerOrder = new Order(date3, 10.00, "Jake Custal", "Hammer", 2);
        Order.setRushable((orderDate, amount) -> {
            LocalDate oneMonthAfterOrderDate = LocalDate.of(orderDate.getYear(), orderDate.getMonth(), orderDate.getDay()).plusMonths(1);
            if (LocalDate.now().isAfter(oneMonthAfterOrderDate))
                return true; // LocalDate check added in Lab13_DateTime.pdf
            return amount > 1500;
        });
        System.out.println(anvilOrder.getProduct() + " is a priority order: " + anvilOrder.isPriorityOrder()); // should return true.
        System.out.println(hammerOrder.getProduct() + " is a priority order: " + hammerOrder.isPriorityOrder()); // should return false.

        printHeadline("Lab14_Arrays.pdf");
        MyDate aDateOnAHoliday = new MyDate(1, 1, 2023);
        anvilOrder.setOrderDate(aDateOnAHoliday); // should give a message that it can't set on a holiday.
    }

    private static void printHeadline(String headline) {
        System.out.println();
        System.out.println("##### " + headline);
    }
}

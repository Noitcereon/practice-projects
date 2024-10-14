package acme.order.system;

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

        System.out.println("The tax Rate is currently: " + Order.taxRate);
        Order.computeTaxOn(3000.00);
        anvilOrder.computeTax();
        balloonOrder.computeTax();

        Order.setTaxRate(0.06);
        System.out.println("The tax Rate is currently: " + Order.taxRate);
        Order.computeTaxOn(3000.00);
        anvilOrder.computeTax();
        balloonOrder.computeTax();
    }
}

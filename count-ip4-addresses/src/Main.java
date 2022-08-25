public class Main {
    public static void main(String[] args) {
        long count1 = CountIPAddresses.ipsBetween( "10.0.0.0", "10.0.0.50" );
        long count2 = CountIPAddresses.ipsBetween( "20.0.0.10", "20.0.1.0" );
        long count3 = CountIPAddresses.ipsBetween( "0.0.0.0", "255.255.255.255" );
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
    }
}
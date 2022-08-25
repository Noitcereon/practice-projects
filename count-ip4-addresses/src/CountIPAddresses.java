import java.util.Arrays;

public class CountIPAddresses {
    // https://www.codewars.com/kata/526989a41034285187000de4/train/java
    // Implement a function that receives two IPv4 addresses, and returns the number of addresses between them (including the first one, excluding the last one).
    //
    // All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater than the first one.
    // Examples:
    // * With input "10.0.0.0", "10.0.0.50"  => return   50
    // * With input "10.0.0.0", "10.0.1.0"   => return  256
    // * With input "20.0.0.10", "20.0.1.0"  => return  246


    // I gave up after trying for approximately 2 hours and looked at solutions.
    // This below solution is very similar to the top voted solution.
    public static long ipsBetween(String start, String end) {
        long startIpAsLong = convertIp4ToLong(start);
        long endIpAsLong = convertIp4ToLong(end);

        return endIpAsLong-startIpAsLong;
    }
    public static long convertIp4ToLong(String ip4){
        long[] ipSegments = Arrays.stream(ip4.split("\\.")).mapToLong(Long::parseLong).toArray();
        long accumulator = 0;
        for (long ipSegment : ipSegments) {
            accumulator = (accumulator * 256) + ipSegment;
        }
        accumulator+=1;
        return accumulator;
    }
}

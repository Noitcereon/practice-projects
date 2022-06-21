import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String... args) {
        // TODO: Explore most of the concepts in this article: https://medium.com/linkit-intecs/comparison-of-java-7-with-java-8-e99e407832af (see below comments)
        // Lambda Expressions
        // Null Reference Template (aka. Optional)
        // New Date and Time API
        // Java Stream API
        // Parallel Sorting

        Optional<String> s = Optional.of("Hello");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 65; i <= 100; i += 5) {
            numbers.add(i);
        }
       numbers.add(100);
        for (int i = 0; i < 56; i += 5) {
            numbers.add(i);
        }

        System.out.println(numbers);
        numbers.sort((num1, num2) -> {
            if (num1.equals(num2))
                return 0;
            else if (num1 > num2)
                return 1;
            else
                return -1;
        });
        System.out.println(numbers);
        List<Integer> filteredNumbers = numbers.stream().filter((number) -> number.equals(0) || number.equals(100)).collect(Collectors.toList());
        System.out.println(filteredNumbers);

    }
}




import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String... args) {
        // TODO: Explore most of the concepts in this article: https://medium.com/linkit-intecs/comparison-of-java-7-with-java-8-e99e407832af (see below comments)
        // Null Reference Template (aka. Optional)
        // New Date and Time API
        // Java Stream API
        // Parallel Sorting
        // Consumer/Supplier/Predicate
        Thread streamPractice = new Thread(new JavaStreamApi());
        streamPractice.start();
        try {
            streamPractice.join();
        } catch (InterruptedException ignored) {}
        Optional<String> s = Optional.of("Hello");
        System.out.println(s.get());
    }
}




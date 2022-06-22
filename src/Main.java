import Topics.*;

import java.util.*;

public class Main {
    public static void main(String... args) {
        // TODO: Explore most of the concepts in this article: https://medium.com/linkit-intecs/comparison-of-java-7-with-java-8-e99e407832af (see below comments)
        // Null Reference Template (aka. Optional)
        // New Date and Time API
        // Java Stream API
        // Parallel Sorting
        // Consumer/Supplier/Predicate

        Thread streamPractice = new Thread(new JavaStreamApi());
        //noinspection CallToThreadRun
        streamPractice.run(); // I intentionally call .run instead of .start to make it synchronous. I've used Thread here
                              // to showcase how to make something multithreaded. (by just .using start instead of .run)

        // One can use a class that implements Runnable without Thread (as was my original intention), but then I discovered Runnable was related to multithreading
        // The 2 lines below showcase what I originally had in mind.
//        JavaStreamApi streamPracticeNonThread = new JavaStreamApi();
//        streamPracticeNonThread.run();

        Thread optionalPractice = new Thread(new OptionalPractice());
        //noinspection CallToThreadRun
        optionalPractice.run();

        ParallelSorting parallelSorting = new ParallelSorting();
        parallelSorting.run();

        DateAndTime dateAndTime = new DateAndTime();
        dateAndTime.run();

        Predicates predicates = new Predicates();
        predicates.run();
    }
}

package annotationUsage;

import annotations.MyCustomAnnotation;
import annotations.RunImmediately;

@MyCustomAnnotation
public class MyAnnotationTester {
    public MyAnnotationTester() {
    }

    @RunImmediately(times = 5)
    public void printObiWanGreeting(){
        System.out.println("Hello there!");
    }
}

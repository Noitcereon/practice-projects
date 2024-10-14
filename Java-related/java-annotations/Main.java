import annotationUsage.MyAnnotationTester;
import annotations.MyCustomAnnotation;
import annotations.RunImmediately;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String... args) throws InvocationTargetException, IllegalAccessException {
        System.out.println();
        MyAnnotationTester annotationTester = new MyAnnotationTester();
        boolean usesMyCustomAnnotation = annotationTester.getClass().isAnnotationPresent(MyCustomAnnotation.class);
        if (usesMyCustomAnnotation) {
            System.out.println(annotationTester.getClass().getName() + " HAS " + MyCustomAnnotation.class.getName());
        } else {
            System.out.println(annotationTester.getClass() + " does NOT have " + MyCustomAnnotation.class.getName());
        }

        for (Method method : annotationTester.getClass().getMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                for (int i = 0; i < annotation.times(); i++) {
                    method.invoke(annotationTester);
                }
            }
        }


    }
}

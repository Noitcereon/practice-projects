package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE, ElementType.METHOD}) // @Target specifies WHERE this @annotation can be applied
// @Retention specifies how long the annotation should be available (RUNTIME, SOURCE, CLASS). RUNTIME is used most of the time.
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation { }

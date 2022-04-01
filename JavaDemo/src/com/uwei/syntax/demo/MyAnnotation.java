package com.uwei.syntax.demo;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited // 子类也会被注解修饰
public @interface MyAnnotation {
    int type() default 0;
    String value() default "";
}

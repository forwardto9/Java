package com.uwei.syntax.demo;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited // 子类也会被注解修饰
public @interface MyAnnotation {
    int type() default 0;
    String value() default "";
}

class TestAnnotation {
    @MyAnnotation(type = 1, value = "x")
    public void some(String name) {
        System.out.println(name);
    }


    public static void main(String[] args) throws Exception {
        TestAnnotation testAnnotation = new TestAnnotation();
        Class<TestAnnotation> c = TestAnnotation.class;
        Method some = c.getMethod("some", String.class);
        iteratorAnnotations(some, "x", testAnnotation);
    }

    public static void iteratorAnnotations(Method m, Object param, Object o) throws Exception {
        if (m.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation myAnnotation = m.getAnnotation(MyAnnotation.class);
            String value = myAnnotation.value();
            if (value.equals("x")) {
                throw  new RuntimeException("value is x");
            } else {
                Class<?>[] types = m.getParameterTypes();
                for (Class<?> t:types) {
                    System.out.println(t.getName());
                }
                if (types[0].equals(String.class)) {
                    m.invoke(o, param);
                }
            }
        }
    }
}

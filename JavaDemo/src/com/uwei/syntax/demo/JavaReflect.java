package com.uwei.syntax.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
* 动态加载
JVM在执行Java程序的时候，并不是一次性把所有用到的class全部加载到内存，而是第一次需要用到class时才加载
*
* */
public class JavaReflect {
    public static void main(String[] args) {
        String[] sa = new String[1];
        printClassInfo("".getClass());
        printClassInfo(sa.getClass());

        Class cla = String.class;
        try {
            String s =  (String) cla.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        /*
        * 先定义了接口Hello，但是我们并不去编写实现类，
        * 而是直接通过JDK提供的一个Proxy.newProxyInstance()创建了一个Hello接口对象。
        * 这种没有实现类但是在运行期动态创建了一个接口对象的方式，我们称为动态代码。
        * JDK提供的动态创建接口对象的方式，就叫动态代理*/
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[] { Hello.class }, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");

        /*静态实现类*/
        class HelloDynamicProxy implements Hello {
            InvocationHandler handler;
            public HelloDynamicProxy(InvocationHandler handler) {
                this.handler = handler;
            }
            public void morning(String name) {
                try {
                    handler.invoke(
                            this,
                            Hello.class.getMethod("morning", String.class),
                            new Object[] { name });
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("simple Name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package Name:" + cls.getPackageName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }

    interface Hello {
        void morning(String name);
    }
}

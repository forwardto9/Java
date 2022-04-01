package com.uwei.syntax.demo;

import java.util.logging.Logger;

/**
 * author: uwei
 * create:2022-04-01
 */
public class MyException extends RuntimeException {
    MyException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
    MyException(Throwable throwable) {
        super(throwable);
    }
    MyException(String msg) {
        super(msg);
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("myLogger");
        logger.info("test log");
        try {
//            test(-1);
            new MyException("x").testnull();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test(int x) throws MyException {
        if (x < 0) {
            throw new MyException("x > 0");
        }
    }

    private void testnull() {
        Person p = new Person();
        System.out.println(p.address.city.toLowerCase());
    }

    class Person {
        String[] name = new String[2];
        Address address = new Address();
    }

    class Address {
        String city;
        String street;
        String zipcode;
    }
}

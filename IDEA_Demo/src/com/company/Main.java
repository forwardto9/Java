package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hi Demo Java");
        Class<?> _class;
        String s = "test";
        _class = s.getClass();
        System.out.println(_class);
        try {
            String si = s.getClass().newInstance();
            System.out.println(si);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

package com.uwei.syntax.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: uwei
 * create:2022-05-10
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<String> line = Arrays.asList("x", "y", "z");
        List<String> newLines = line.stream().filter(l -> {
            if (l.equals("y")) {
                System.out.println("NO");
                return false;
            }
            return true;
        }).toList();

        System.out.println(newLines);
    }
}

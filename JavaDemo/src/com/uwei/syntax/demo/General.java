package com.uwei.syntax.demo;

/**
 * author: uwei
 * create:2022-05-07
 */
public class General {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        p.setFirst(1);  // 编译OK
        // 如果是Double类型，则set方法中的参数，就不可以是Double之外的类型
        // 即对象的方法参数签名被固定为Double
//        Pair<Double> p = new Pair<>(123.1, 456.1);
        int n = add(p);
        System.out.println(n);
    }

    // 泛型的继承关系：Pair<Integer>不是Pair<Number>的子类。
    static int add(Pair<? extends Number> p) {
        // 使用extends通配符表示可以读，不能写
//        p.setFirst(1);  // 编译报错!!!
        return p.getFirst().intValue() + p.getSecond().intValue();
    }

    // 凡是Integer的父类以上关系，都可以使用
    static int reduce(Pair<? super Integer> p) {
        // 使用<? super Integer>通配符作为方法参数，表示方法内部代码对于参数只能写，不能读
        p.setFirst(1); // 编译OK
        // 继承关系上，Object类型是不存在intValue方法的
//        return p.getFirst().intValue() + p.getSecond();
        return 0;
    }
}

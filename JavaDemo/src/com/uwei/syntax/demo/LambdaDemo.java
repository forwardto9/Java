package com.uwei.syntax.demo;

/**
 * author: uwei
 * create:2022-02-18
 */
public class LambdaDemo {
    public static void main(String[] args) {
        Calc c = (Integer i) -> i * 2;
        // 类型推断
        Calc s = (i) -> i * 2;
        System.out.println(c.calcInt(20));
        System.out.println(s.calcInt(40));
    }
}

interface Calc {
    /**
     * 将接口方法用作lambda表达式类型
     * @param i 参数
     * @return 返回值
     */
    Integer calcInt(Integer i);
}

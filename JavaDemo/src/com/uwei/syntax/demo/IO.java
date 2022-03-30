package com.uwei.syntax.demo;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * author: uwei
 * create:2022-03-30
 */
public class IO {
    public static void main(String[] args) throws IOException {
        fileIO();
        config();
    }

    public static void config() {
        System.out.println(System.getProperty("user.dir"));
    }

    private static void read() throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            c = (char)br.read();
            System.out.println(c);
        } while (c != 'q');
    }

    private static void readLine() throws IOException {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            str = br.readLine();
            System.out.println(str);
        } while (! str.equalsIgnoreCase("exit"));
    }

    private static void fileIO() throws IOException {
        File file = new File("/Users/uwei/java.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
        writer.write("测试内容");
        writer.write("\r\n");
        writer.write("English");
        writer.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer bf = new StringBuffer();
        while (reader.ready()) {
            // char 类型转换是必须的，否则就是按照ASCII数值写入的
            bf.append((char)reader.read());
        }
        System.out.println(bf);
        reader.close();
        fileInputStream.close();
    }
}

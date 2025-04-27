package com.yupi.yupicturebackend;

/**
 * @ClassName: CommonTest
 * @Author: zxh
 * @Date: 2025/4/25 21:38
 * @Description:
 */
public class CommonTest {
    private static void a() {
        System.out.println("a");
        b();
    }
    private static void b() {
        System.out.println("b");
        a();
    }

    public static void main(String[] args) {
        a();
    }
}

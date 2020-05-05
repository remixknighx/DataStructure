package com.algorithm;

/**
 * 位操作技巧
 *
 * @author wangjianfeng
 */
public class BinaryOperateMain {

    public static void main(String[] args) {
        // 1. 利用或操作 | 和空格将英文字符转换为小写
        System.out.println('a' | ' ');
        System.out.println('A' | ' ');

        // 2. 利用与操作 & 和下划线将英文字符转换为大写
        System.out.println('a' & '_');
        System.out.println('A' & '_');

        // 3. 利用异或操作 ^ 和空格进行英文字符大小写互换
        System.out.println('a' ^ ' ');
        System.out.println('A' ^ ' ');

        // 4. 判断两个数是否异号
        System.out.println((-1 ^ 2) < 0);
        System.out.println((3 ^ 2) < 0);

        // 5. 交换两个数
        int a = 1, b = 2;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("a = " + a + ", b = " + b);

        // 6. 加一
        System.out.println(-~2);

        // 7. 减一
        System.out.println(~-2);

        System.out.println(hammingWeight(2));
    }

    /**
     * n&(n-1)能消除二进制中的最后一个1
     */
    static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

}

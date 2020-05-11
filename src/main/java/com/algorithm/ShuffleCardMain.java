package com.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 洗牌算法
 *
 * @author wangjianfeng
 */
public class ShuffleCardMain {

    public static void main(String[] args) {
        int[] arr = {2,4,6,7,1};
        for (int i = 0; i < 10; i++) {
            shuffle(arr);
            for (int num: arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("=======================================");
        }

    }

    /**
     * 靠随机选取元素交换来获取随机性
     */
    private static void shuffle(int[] arr) {
        int n = arr.length;
        for (int i = 0 ; i < n; i++) {
            // 从 i 到最后随机选一个元素
            int rand = randInt(i, n - 1);

            // swap arr[i] and arr[rand]
            int temp = arr[i];
            arr[i] = arr[rand];
            arr[rand] = temp;
        }
    }

    private static int randInt(int start, int end) {
        Random random = new Random();
        return random.nextInt(end) % (end - start + 1) + start;
    }

}

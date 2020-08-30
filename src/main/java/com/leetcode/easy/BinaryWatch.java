package com.leetcode.easy;

import java.util.List;

/**
 * 401. Binary Watch
 * @link https://leetcode.com/problems/binary-watch/description/
 *
 * @author wangjf
 * @date 2017/8/23 0023.
 */
public class BinaryWatch {

    public static void main(String[] args) {
        BinaryWatch binaryWatch = new BinaryWatch();
        List<String> list = binaryWatch.readBinaryWatch(3);

        for (String singleTime: list) {
            System.out.println("时间：" + singleTime);
        }
    }

    public List<String> readBinaryWatch(int num) {
        // TODO https://www.jiuzhang.com/solution/binary-watch/
        return null;
    }

}

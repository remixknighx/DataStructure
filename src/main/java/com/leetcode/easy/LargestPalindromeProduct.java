package com.leetcode.easy;

/**
 * 479. Largest Palindrome Product
 * @link https://leetcode.com/problems/largest-palindrome-product/description/
 *
 * @author wangjf
 * @date 2018/4/6 0006.
 */
public class LargestPalindromeProduct {

    public static void main(String[] args) {
        System.out.println(Math.pow(6,2));
    }

    // TODO 没看懂 啥意思？
    public int largestPalindrome(int n) {
        // 边界处理
        if(n==1){
            return 9; // 单位数是回文数
        }
        int maxnumber = (int)Math.pow(10,n)-1;

        for(int i=maxnumber;i>maxnumber/10;i--){ // 保证了数值递减
            long num = toLong(i);

            for(long j=maxnumber;j*j>=num;j--){
                if(num%j==0){ // num已是回文数，只要mod为0就找到了结果
                    return (int)(num%1337);
                }
            }
        }
        return 0;
    }

    public long toLong(int number){

        StringBuffer b = new StringBuffer();
        String str = b.append(number).reverse().toString();

        return Long.valueOf(number+str);
    }

}

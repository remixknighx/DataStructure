package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 409. Longest Palindrome
 * @link https://leetcode.com/problems/longest-palindrome/description/
 *
 * @author wangjf
 * @date 2017/8/23 0023.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        LongestPalindrome longestPal = new LongestPalindrome();
        System.out.println(longestPal.longestPalindrome(s));
    }

    /**
     * 若要成为最大长度回文，其中奇数项只能出现一次，挑选出现奇数项最多的那个字符
     */
    public int longestPalindrome(String s) {
        char chars[] = s.toCharArray();
        int lowerCount[] = new int[26];
        int upperCount[] = new int[26];
        int odds = 0;
        int n = s.length();

        for(int i=0;i<n;i++){
            if(chars[i] < 'a') {
                upperCount[chars[i]-'A'] ++;
            }
            else {
                lowerCount[chars[i] - 'a']++;
            }
        }

        for(int i = 0; i < 26; i++){
            if(lowerCount[i] % 2 == 1) {
                odds++;
            }
            if(upperCount[i] % 2 == 1) {
                odds++;
            }
        }

        if(odds == 0) {
            return n;
        } else {
            return n - odds + 1;
        }
    }

}

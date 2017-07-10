package com.leetcode;

/**
 * @author wangjf
 * @date 2017/7/10.
 */
public class CountAndSay {

    public String countAndSay(int n) {

        StringBuilder result = new StringBuilder();
        char[] resultChar = "1".toCharArray();

        if (n <= 1) {
            return String.valueOf(n);
        }

        for (int i = 2; i <= n; i++) {
            int count = 0;
            int tempInt = convertCharToInt(resultChar[0]);
            for (int j = 0; j < resultChar.length; j++) {
                if (tempInt == convertCharToInt(resultChar[j])) {
                    count++;
                } else {
                    result.append(count).append(tempInt);
                    tempInt = convertCharToInt(resultChar[j]);
                    count = 1;
                }
            }
            result.append(count).append(tempInt);
            resultChar = result.toString().toCharArray();
            result = new StringBuilder();
        }

        return new String(resultChar);
    }

    private static int convertCharToInt(char charNum) {
        switch (charNum) {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
        }
        return 0;
    }
}

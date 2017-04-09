package com.leetcode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 * https://leetcode.com/problems/zigzag-conversion/#/description
 *
 */
public class ZigZageSolution {

    public static void main(String[] args) {
        Character[][] textMatrix = new Character[5][6];
        System.out.println(textMatrix.length);
        System.out.println(textMatrix[0].length);
    }

    public String convert(String text, int nRows){
        int nCols = getColumns(text, nRows);

        Character[][] textMatrix = new Character[nRows][nCols];

        return "tes";
    }

    /**
     * 获取二元数组的列数
     *
     * @param text 待计算的字符串
     * @param nRows 给定的行数
     * @return
     * */
    private static int getColumns(String text, int nRows){
        if(text.toCharArray().length % (nRows+1) == 0){
            return  (text.toCharArray().length / (nRows+1)) * 2;
        }else{
            return  (text.toCharArray().length / (nRows+1)) * 2 + 1;
        }
    }
}

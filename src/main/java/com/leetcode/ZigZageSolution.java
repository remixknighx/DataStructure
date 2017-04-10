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
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String text, int nRows){
        int nCols = getColumns(text, nRows);

        int count = 0;

        Character[][] textMatrix = new Character[nRows][nCols];

        for (int j = 0; j < nCols; j++) {
            if(j % 2 != 0) {
                textMatrix[nRows / 2][j] = text.toCharArray()[count++];
                continue;
            }
            for (int i = 0; i < nRows; i++) {
                textMatrix[i][j] = text.toCharArray()[count++];
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if(textMatrix[i][j] != null){
                    result.append(textMatrix[i][j]);
                }
            }
        }

        return result.toString();
    }

    /**
     * ��ȡ��Ԫ���������
     *
     * @param text ��������ַ���
     * @param nRows ����������
     * @return ����������
     * */
    private static int getColumns(String text, int nRows){
        if(text.toCharArray().length % (nRows+1) == 0){
            return  (text.toCharArray().length / (nRows+1)) * 2;
        }else{
            return  (text.toCharArray().length / (nRows+1)) * 2 + 1;
        }
    }
}

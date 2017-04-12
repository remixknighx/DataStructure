package com.leetcode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * <p>
 * https://leetcode.com/problems/zigzag-conversion/#/description
 */
public class ZigZageSolution {

    public static void main(String[] args) {
        String test = "PAYPAFSFASDLISHIRING";

        System.out.println(new ZigZageSolution().convert(test, 3));
    }

    public String convert(String text, int nRows) {
        int nCols = getColumns(text, nRows);

        Character[][] textMatrix = new Character[nRows][nCols];
        char[] textChar = text.toCharArray();

        for (int k = 0; k < textChar.length; ) {
            for (int j = 0; j < nCols; j++) {
                if (k == textChar.length) {
                    break;
                }
                if (nRows % 2 == 1 && j % 2 != 0) {
                    textMatrix[nRows / 2][j] = textChar[k++];
                    continue;
                }
                if (nRows % 2 == 0 && j % 2 != 0) {
                    textMatrix[nRows / 2 - 1][j] = textChar[k++];
                    textMatrix[nRows / 2][j] = textChar[k++];
                    continue;
                }
                for (int i = 0; i < nRows; i++) {
                    if (k == textChar.length) {
                        break;
                    }
                    textMatrix[i][j] = textChar[k++];
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (textMatrix[i][j] != null) {
                    result.append(textMatrix[i][j]);
                }
            }
        }

        return result.toString();
    }

    /**
     * 获取二元数组的列数
     *
     * @param text  待计算的字符串
     * @param nRows 给定的行数
     * @return 计算后的列数
     */
    private static int getColumns(String text, int nRows) {
        if (text.toCharArray().length % (nRows + 1) == 0) {
            return (text.toCharArray().length / (nRows + 1)) * 2;
        } else {
            return (text.toCharArray().length / (nRows + 1)) * 2 + 1;
        }
    }
}

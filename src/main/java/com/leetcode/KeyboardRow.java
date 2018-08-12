package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 500. Keyboard Row
 * @link https://leetcode.com/problems/keyboard-row/description/
 *
 * @author wangjf
 * @date 2018/8/12 0012.
 */
public class KeyboardRow {

    private char[] FIRST_ROW = {'q','w','e','r','t','y','u','i','o','p'};
    private char[] SECOND_ROW = {'a','s','d','f','g','h','j','k','l'};
    private char[] THIRD_ROW = {'z','x','c','v','b','n','m'};

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.asList(new KeyboardRow().findWords(words)));
    }

    public String[] findWords(String[] words) {

        if(words == null || words.length == 0){
            return new String[0];
        }

        List<String> result = new ArrayList<String>();
        for (int i = 0, size = words.length; i < size; i++) {
            if(checkWord(words[i].toLowerCase())){
                result.add(words[i]);
            }
        }

        return result.toArray(new String[result.size()]);
    }

    /**
     * 检查word中的单词是不是在同一行
     *
     * @param word
     * @return
     * */
    private boolean checkWord(String word){
        char[] row = null;
        if (checkChar(word.charAt(0), FIRST_ROW)) {
            row = FIRST_ROW;
        } else if (checkChar(word.charAt(0), SECOND_ROW)) {
            row = SECOND_ROW;
        } else if (checkChar(word.charAt(0), THIRD_ROW)) {
            row = THIRD_ROW;
        } else {
            return false;
        }

        for (int i = 1; i < word.length(); i++) {
            if(!checkChar(word.charAt(i), row)){
                return false;
            }
        }
        return true;
    }

    private boolean checkChar(char singleCahr, char[] row){
        for (int j = 0; j < row.length; j++) {
            if(row[j] == singleCahr){
                return true;
            }
        }
        return false;
    }

}

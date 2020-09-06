package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. Word Ladder
 * @link https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {

    private int shortest = Integer.MAX_VALUE;

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        List<String> wordList1 = new ArrayList<>();
        wordList1.add("hot");
        wordList1.add("dot");
        wordList1.add("dog");
        wordList1.add("log");
        wordList1.add("lot");
        wordList1.add("cog");
//        System.out.println(wordLadder.ladderLength("hit", "cog", wordList1));
        System.out.println(wordList1);
    }

    /**
     * Dijkstra算法
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> reached = new ArrayList<>();
        reached.add(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.add(endWord);

        int distance = 1;
        while (!reached.contains(endWord)) { //到达该目的地
            List<String> toAdd = new ArrayList<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String wd = new String(chars);
                        if (wordSet.contains(wd)) {
                            toAdd.add(wd);
                            wordSet.remove(wd); //记录访问状态
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) {
                return 0; //没有编辑距离为1的单词
            }
            reached = toAdd;
        }
        return distance;
    }

}

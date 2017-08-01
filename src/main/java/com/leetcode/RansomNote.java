package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 383. Ransom Note
 * @link https://leetcode.com/problems/ransom-note/description/
 *
 * @author wangjf
 * @date 2017/8/1 0001.
 */
public class RansomNote {

    public static void main(String[] args) {
        String ransomNote = "fffbfg";
        String magazine = "effjfggbffjdgbjjhhdegh";

        RansomNote ransom = new RansomNote();
        System.out.println(ransom.canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> magazineList = new LinkedList<Character>();

        for (int i = 0; i < magazine.length(); i++) {
            magazineList.add(magazine.charAt(i));
        }

        for (int j = 0; j < ransomNote.length(); j++) {
            if (magazineList.contains(ransomNote.charAt(j))) {
                magazineList.remove((Character) ransomNote.charAt(j));
            } else {
                return false;
            }
        }

        return true;
    }

}

package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [937] Reorder Data in Log Files
 *
 * @link https://leetcode.com/problems/reorder-data-in-log-files/description/
 */
public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        if (logs.length == 0) {
            return logs;
        }
        List<String> letterLogs = new ArrayList<>(), digitLogs = new ArrayList<>();
        separateLettersDigits(logs, letterLogs, digitLogs);
        sortLetterLogs(letterLogs);
        return generateOutput(letterLogs, digitLogs);
    }

    void separateLettersDigits(String[] input, List<String> letterLogs, List<String> digitLogs) {
        for (String log : input) {
            if (Character.isDigit(log.charAt(log.length() - 1))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
    }

    void sortLetterLogs(List<String> letterLogs) {
        Collections.sort(letterLogs, (o1, o2) -> {
                String s1 = o1.substring(o1.indexOf(" ") + 1);
                String s2 = o2.substring(o2.indexOf(" ") + 1);

                return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
            });
    }

    String[] generateOutput(List<String> letterLogs, List<String> digitLogs) {
        String[] output = new String[letterLogs.size() + digitLogs.size()];
        for (int i = 0; i < letterLogs.size(); i++) {
            output[i] = letterLogs.get(i);
        }
        for (int i = letterLogs.size(); i < output.length; i++) {
            output[i] = digitLogs.get(i - letterLogs.size());
        }
        return output;
    }

}

package com.leetcode;

/**
 * 557. Reverse Words in a String III
 * @link https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsInString3 {

	public static void main(String[] args) {
		System.out.println(new ReverseWordsInString3().reverseWords("Let's take LeetCode contest"));
	}

	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String[] sList = s.split(" ");
		StringBuilder result = new StringBuilder();
		for (String str: sList) {
			result.append(this.doReverseString(str));
			result.append(" ");
		}

		return result.toString().trim();
	}

	private String doReverseString(String s) {
		StringBuilder result = new StringBuilder();
		for (Character c: s.toCharArray()) {
			result.insert(0, c);
		}
		return result.toString();
	}

}

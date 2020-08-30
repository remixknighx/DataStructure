package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 1496. Path Crossing
 * @link https://leetcode.com/problems/path-crossing/
 */
public class PathCrossing {

	public static void main(String[] args) {
		System.out.println(new PathCrossing().isPathCrossing("NESWW"));
	}

	public boolean isPathCrossing(String path) {
		int[] position = {0, 0};
		Set<String> oldPosition = new HashSet<>();
		oldPosition.add(String.valueOf(position[0]) + String.valueOf(position[1]));
		for (int i = 0; i < path.length(); i++) {
			if (path.charAt(i) == 'N') {
				position[1] += 1;
			} else if (path.charAt(i) == 'E') {
				position[0] += 1;
			} else if (path.charAt(i) == 'W') {
				position[0] -= 1;
			} else {
				position[1] -= 1;
			}
			String positionStr = String.valueOf(position[0]) + String.valueOf(position[1]);
			if (oldPosition.contains(positionStr)) {
				return true;
			} else {
				oldPosition.add(positionStr);
			}
		}
		return false;
	}

}

package com.leetcode;

/**
 * 427. Construct Quad Tree
 * https://leetcode.com/problems/construct-quad-tree/
 *
 * @author wangjf
 * @date 2019/1/20 0020.
 */
public class ConstructQuadTree {

    public static void main(String[] args) {
        int[][] grid = new int[8][8];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j < 4) {
                    grid[i][j] = 1;
                } else {
                    if (i < 2 || i > 3) {
                        grid[i][j] = 0;
                    } else {
                        grid[i][j] = 1;
                    }
                }
            }
        }

        Node1 node = new ConstructQuadTree().construct(grid);
        System.out.println(node);
    }

    public Node1 construct(int[][] grid) {
        return build1(grid, 0, 0, grid.length);
    }

    private Node1 build1(int[][] grid, int x, int y, int length){
        if (length <= 0) {
            return null;
        }
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (grid[i][j] != grid[x][y]) {
                    return new Node1(true, false,
                            build1(grid, x, y, length / 2),
                            build1(grid, x, y + length / 2, length / 2),
                            build1(grid, x + length / 2, y, length / 2),
                            build1(grid, x + length / 2, y + length / 2, length / 2));
                }
            }
        }
        return new Node1(grid[x][y] == 1, true, null, null, null, null);
    }

}

class Node1 {
    public boolean val;
    public boolean isLeaf;
    public Node1 topLeft;
    public Node1 topRight;
    public Node1 bottomLeft;
    public Node1 bottomRight;

    public Node1() {}

    public Node1(boolean _val,boolean _isLeaf,Node1 _topLeft,Node1 _topRight,Node1 _bottomLeft,Node1 _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}
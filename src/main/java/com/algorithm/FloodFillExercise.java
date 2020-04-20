package com.algorithm;

/**
 * 遍历二维矩阵
 */
public class FloodFillExercise {

    public static void main(String[] args) {
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] result = new FloodFillExercise().floodFill(image, sr, sc, newColor);
        System.out.println(result);
    }

    /**
     * 将二维数组中的像素替换为新像素
     */
    int[][] floodFill(int[][] image,
                      int sr, int sc, int newColor) {

        int origColor = image[sr][sc];
        fill(image, sr, sc, origColor, newColor);
        return image;
    }

    void fill(int[][] image, int x, int y,
              int origColor, int newColor) {
        // 出界：超出边界索引
        if (!inArea(image, x, y)) return;
        // 碰壁：遇到其他颜色，超出 origColor 区域
        if (image[x][y] != origColor) return;
        // 已经探索过的origColor区域
        if (image[x][y] == newColor) return;

        image[x][y] = newColor;
        fill(image, x, y + 1, origColor, newColor);
        fill(image, x, y - 1, origColor, newColor);
        fill(image, x - 1, y, origColor, newColor);
        fill(image, x + 1, y, origColor, newColor);
    }

    boolean inArea(int[][] image, int x, int y) {
        return x >= 0 && x < image.length
                && y >= 0 && y < image[0].length;
    }
}

package UVA750;

import java.util.Arrays;

public class Solution {

    static String ans = "Impossible";
    static int[] arr = new int[5];

    public static void main(String[] args) {

        Boolean[][] grid = new Boolean[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(grid[i], false);
        }
        solve(0, 0, grid);
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                System.out.print(grid[i][j] + " ");
//            }
//            System.out.println("");
//        }

    }

    private static Boolean[][] solve(int r, int c, Boolean[][] grid) {
        if (r >= 8) {
            return grid;
        }
        for (int i = 0; i < 8; i++) {
            if (!grid[r][i]) {
                System.out.print(i + " ");
                solve(r + 1, i, mark(r, i, grid));
            }
        }
        return grid;
    }

    private static Boolean[][] mark(int r, int c, Boolean[][] grid) {
        int i, j;
        for (i = 0; i < 8; i++) {
            grid[r][i] = true;
        }
        for (i = 0; i < 8; i++) {
            grid[i][c] = true;
        }
        for (i = r, j = c; i < 8 && j < 8; i++, j++) {
            grid[i][j] = true;
        }
        for (i = r, j = c; i < 8 && j >= 0; i++, j--) {
            grid[i][j] = true;
        }
        for (i = r, j = c; i >= 0 && j < 8; i--, j++) {
            grid[i][j] = true;
        }
        for (i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            grid[i][j] = true;
        }
        return grid;
    }
}

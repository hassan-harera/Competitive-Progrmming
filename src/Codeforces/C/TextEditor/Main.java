/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.C.TextEditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Harera
 */
public class Main {

    static int R;
    static int rs, cs, re, ce;
    static int[][] moves = new int[][]{{0, 0, 1, -1}, {1, -1, 0, 0}};
    static int ans = Integer.MAX_VALUE;
    static int[] lines;
//    static 

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        R = in.nextInt();

        lines = new int[R];

        boolean[][] visited = new boolean[102][102];
        clear(visited);

        for (int i = 0; i < R; i++) {
            int cols = in.nextInt();
            lines[i] = cols;
        }

        rs = in.nextInt() - 1;
        cs = in.nextInt() - 1;
        re = in.nextInt() - 1;
        ce = in.nextInt() - 1;

//        visited[rs][cs] = true;
        solve(visited, rs, cs, 0);
        System.out.println(ans);
    }

    private static void solve(boolean[][] visited, int r, int c, int steps) {
        if (r == re && c == ce) {
            ans = Integer.min(ans, steps);
        }

        if (r < 0 || c < 0 || r >= R || c >= lines[r]) {
            return;
        }

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            solve(visited, r + moves[0][i], c + moves[1][i], steps + 1);
//            visitedvisited, [r + moves[0][i]][c + moves[1][i]
        }
    }

    private static void clear(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.C.TextEditor;

import java.util.Scanner;

public class Main {

    static int R, C;
    static int rs, cs, re, ce;
    static int[][] moves = new int[][]{{0, 0, 1, -1}, {1, -1, 0, 0}};
    static int[][] dis = new int[102][100002];
    static boolean[][] visited = new boolean[102][100002];
    static int ans = Integer.MAX_VALUE;
    static int[] lines;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        R = in.nextInt();
        lines = new int[R];

        clear();

        for (int i = 0; i < R; i++) {
            int cols = in.nextInt();
            lines[i] = cols;
        }

        rs = in.nextInt() - 1;
        cs = in.nextInt() - 1;
        re = in.nextInt() - 1;
        ce = in.nextInt() - 1;

        dis[rs][cs] = 0;
        visited[rs][cs] = true;

        solve(rs, cs);
        System.out.println(ans);
    }

    private static void solve(int r, int c) {
        if (r == re && c == ce) {
            ans = Integer.min(ans, dis[r][c]);
        }

        if (r > 0) {
            if (c <= lines[r - 1] && !visited[r - 1][c]) {
                dis[r - 1][c] = dis[r][c] + 1;
                visited[r - 1][c] = true;
                solve(r - 1, c);
            } else if (!visited[r - 1][lines[r - 1]]) {
                visited[r - 1][lines[r - 1]] = true;
                dis[r - 1][lines[r - 1]] = dis[r][c] + 1;
                solve(r - 1, lines[r - 1]);
            }
        }
        if (r < R - 1) {
            if (c <= lines[r + 1] && !visited[r + 1][c]) {
                visited[r + 1][c] = true;
                dis[r + 1][c] = dis[r][c] + 1;
                solve(r + 1, c);
            } else if (!visited[r + 1][lines[r + 1]]) {
                visited[r + 1][lines[r + 1]] = true;
                dis[r + 1][lines[r + 1]] = dis[r][c] + 1;
                solve(r + 1, lines[r + 1]);
            }
        }

        if (c < lines[r] - 1 && !visited[r][c + 1]) {
            visited[r][c + 1] = true;
            dis[r][c + 1] = dis[r][c] + 1;
            solve(r, c + 1);
        }
        if (c > 0 && !visited[r][c - 1]) {
            visited[r][c - 1] = true;
            dis[r][c - 1] = dis[r][c] + 1;
            solve(r, c - 1);
        }
    }

    private static void clear() {
        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis[0].length; j++) {
                dis[i][j] = Integer.MAX_VALUE;
                visited[i][j] = false;
            }
        }
    }
}

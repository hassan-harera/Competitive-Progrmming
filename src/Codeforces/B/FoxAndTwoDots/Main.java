package Codeforces.B.FoxAndTwoDots;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Boolean[][] vis;
    static char[][] grid;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());


        grid = new char[n][m];
        vis = new Boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        vis[k][l] = false;
                    }
                }
                if (solve(i, j, grid[i][j], i, j)) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");

    }

    private static boolean solve(int i, int j, char c, int pi, int pj) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return false;
        }

        if (grid[i][j] != c) {
            return false;
        }

        if (vis[i][j]) {
            return true;
        }

        vis[i][j] = true;
        Boolean ans = false;

        if (i == pi && j + 1 == pj && vis[pi][pj]) {
        } else {
            ans = ans || solve(i, j + 1, c, i, j);
        }
        if (i == pi && j - 1 == pj && vis[pi][pj]) {
        } else {
            ans = ans || solve(i, j - 1, c, i, j);
        }
        if (i + 1 == pi && j == pj && vis[pi][pj]) {
        } else {
            ans = ans || solve(i + 1, j, c, i, j);
        }
        if (i - 1 == pi && j == pj && vis[pi][pj]) {
        } else {
            ans = ans || solve(i - 1, j, c, i, j);
        }
        return ans;
    }
}

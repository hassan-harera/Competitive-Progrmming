package UVA.UVA11953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static char[][] grid;
    static Boolean[][] vis;
    static int n;
    static List<node> X;
    static int testcase;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        for (int T = 1; T <= N; T++) {
            StringTokenizer stk = new StringTokenizer(in.readLine());
            n = Integer.parseInt(stk.nextToken());

            testcase = T;
            X = new ArrayList<>();

            vis = new Boolean[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(vis[i], false);
            }
            
            grid = new char[n][n];
            for (int i = 0; i < n; i++) {
                String str = in.readLine();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = str.charAt(j);
                    if (grid[i][j] == 'x') {
                        X.add(new node(i, j));
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < X.size(); i++) {
                ans += solve(i);
            }
            System.out.print("Case " + T  + ": " + ans+"\n");
        }
    }

    private static int solve(int count) {
        if (vis[X.get(count).r][X.get(count).c]) {
            return 0;
        }
        mark(X.get(count).r, X.get(count).c);
        return 1;
    }

    static void mark(int r, int c) {
        if (vis[r][c]) {
            return;
        }
        vis[r][c] = true;
        if (c < n - 1 && grid[r][c + 1] == 'X') {
            mark(r, c + 1);
        }
        if (c >= 1 && grid[r][c - 1] == 'X') {
            mark(r, c - 1);
        }
        if (r >= 1 && grid[r - 1][c] == 'X') {
            mark(r - 1, c);
        }
        if (r < n - 1 && grid[r + 1][c] == 'X') {
            mark(r + 1, c);
        }

    }
}

class node {

    int r, c;

    public node(int r, int c) {
        this.r = r;
        this.c = c;
    }

}

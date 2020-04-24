package UVA.UVA11094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Boolean[][] vis;
    static char[][] grid;
    static int m, n;
    static char l;
    static int ans, res;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        /*
        5 5
wwwww
wwllw
wwwww
wllww
wwwww
1 3
 
        
 1 1
h
0 0

6 6
aaaaaa
bbaaab
aaaabb
abaaba
abbaaa
abbabb
5 5

6 6
aaaaaa
bbaaab
aaaabb
abaaba
abbaba
abbaba
5 4

6 6
abaaab
bbaaab
aaaaab
abaaba
abbaba
abbaba
5 4
         */
        grid = new char[m][n];
        vis = new Boolean[m][n];

        for (int i = 0; i < m; i++) {
            String str = in.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = false;
            }
        }

        stk = new StringTokenizer(in.readLine());
        int cur = Integer.parseInt(stk.nextToken());
        int cuc = Integer.parseInt(stk.nextToken());

        l = grid[cur][cuc];

        markLand(cur, cuc);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == l) {
                    ans = 0;
                    search(i, j, 0);
                    res = Integer.max(ans, res);
                }
            }
        }

        System.out.println(res);
    }

    public static void markLand(int r, int c) {
        if (r >= m || r < 0 || vis[r][c] || grid[r][c] != l) {
            return;
        }

        vis[r][c] = true;

        if (c == 0) {
            markLand(r, n - 1);
        } else {
            markLand(r, c - 1);
        }
        if (c == n - 1) {
            markLand(r, 0);
        } else {
            markLand(r, c + 1);
        }
        markLand(r + 1, c);
        markLand(r - 1, c);
    }

    public static void search(int r, int c, int total) {
        if (r >= m || r < 0 || vis[r][c] || grid[r][c] != l) {
            return;
        }

        vis[r][c] = true;

        ++ans;

//        ans = Integer.max(ans, total);
        search(r + 1, c, total);
        search(r - 1, c, total);

        if (c == 0) {
            search(r, n - 1, total);
        } else {
            search(r, c - 1, total);
        }
        if (c == n - 1) {
            search(r, 0, total);
        } else {
            search(r, c + 1, total);
        }

    }
}

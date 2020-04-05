package Codeforces.B.PresidentsOffice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n, m;
        char c;
        List<Desk> pres = new ArrayList<>();

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        c = stk.nextToken().charAt(0);

        String[] sts = new String[n];

        for (int i = 0; i < n; i++) {
            sts[i] = in.readLine();
        }
        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sts[i].charAt(j);
                if (grid[i][j] == c) {
                    pres.add(new Desk(i, j, c));
                }
            }
        }
        int res = 0;
        for (Desk pre : pres) {
            int max = 0;
            if (pre.c - 1 >= 0) {
                if (grid[pre.r][pre.c - 1] != '.' && grid[pre.r][pre.c - 1] != c) {
                    max++;
                }
            }
            if (pre.c + 1 < m) {
                if (grid[pre.r][pre.c + 1] != '.' && grid[pre.r][pre.c + 1] != c) {
                    max++;
                }
            }
            res = Integer.max(res, max);
            max = 0;
            if (pre.r - 1 >= 0) {
                if (grid[pre.r - 1][pre.c] != '.' && grid[pre.r - 1][pre.c] != c) {
                    max++;
                }
            }
            if (pre.r + 1 < n) {
                if (grid[pre.r + 1][pre.c] != '.' && grid[pre.r + 1][pre.c] != c) {
                    max++;
                }
            }
            res = Integer.max(res, max);
        }
        System.out.println(res);
    }
}

class Desk {

    int r, c;
    char color;

    public Desk(int r, int c, char color) {
        this.r = r;
        this.c = c;
        this.color = color;
    }

}
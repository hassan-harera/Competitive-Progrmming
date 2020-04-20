package Codeforces.C.Barcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m, x, y;
    static int ans;
    static int hashes[];
    static int dots[];
    static int[][][] sol = new int[1009][1009][3];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        x = Integer.parseInt(stk.nextToken());
        y = Integer.parseInt(stk.nextToken());
        ans = 0;

        int[][] grid = new int[n][m];
        hashes = new int[m];
        dots = new int[m];

        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = str.charAt(j);
                if (grid[i][j] == '#') {
                    hashes[j]++;
                } else {
                    dots[j]++;
                }
            }
        }
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                for (int k = 0; k < sol[0][0].length; k++) {
                    sol[i][j][k] = -1;
                }
            }
        }
        System.out.println(solve(0, 0, 0));

    }

    public static int solve(int c, int w, int l) {
        if (c >= m) {
            if (w < x || w > y) {
                return Integer.MAX_VALUE;
            }
            return 0;
        }

        if (sol[c][w][l] != -1) {
            return sol[c][w][l];
        }

        int ans = Integer.MAX_VALUE;
        int d = 0, h = 0;

        if (c == 0 || (l == 1 && w + 1 <= y) || (l == 2 && w >= x)) {
            h = hashes[c] + solve(c + 1, l == 1 ? w + 1 : 1, 1);
        }

        if (c == 0 || (l == 2 && w + 1 <= y) || (l == 1 && w >= x)) {
            d = dots[c] + solve(c + 1, l == 2 ? w + 1 : 1, 2);
        }

        ans = Integer.min(h, d);

        return sol[c][w][l] = ans;
    }
}

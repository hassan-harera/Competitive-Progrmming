package UVA.UVA10452;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static char[] ihova;
    static char[][] grid;
    static int m, n;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int F = Integer.parseInt(in.readLine());
        while (--F >= 0) {
            StringTokenizer stk = new StringTokenizer(in.readLine());

            String s = "IEHOVA#";
            ihova = s.toCharArray();
            m = Integer.parseInt(stk.nextToken());
            n = Integer.parseInt(stk.nextToken());
            int c = 0;
            grid = new char[m][n];
            for (int i = 0; i < m; i++) {
                String str = in.readLine();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = str.charAt(j);
                    if (i == m - 1 && grid[i][j] == '@') {
                        c = j;
                    }
                }
            }
            solve(m - 1, c, new ArrayList<>(), 0);
        }
    }

    private static void solve(int r, int c, List<String> list, int count) {
        if (count == ihova.length) {
            for (String string : list) {
                System.out.print(string + " ");
            }
            return;
        }
        if (c < n - 1 && grid[r][c + 1] == ihova[count]) {
            list.add("right");
            solve(r, c + 1, list, count + 1);
        } else if (c >= 1 && grid[r][c - 1] == ihova[count]) {
            list.add("left");
            solve(r, c - 1, list, count + 1);
        } else if (r >= 1 && grid[r - 1][c] == ihova[count]) {
            list.add("forth");
            solve(r - 1, c, list, count + 1);
        }

    }
}

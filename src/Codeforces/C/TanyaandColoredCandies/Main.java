package Codeforces.C.TanyaandColoredCandies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static char[] colors;
    static int n, s, k;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        n = Integer.parseInt(stk.nextToken());
        s = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        colors = new char[n + 1];

        stk = new StringTokenizer(in.readLine());

        int[][] dp = new int[n + 1][4];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Integer.parseInt(stk.nextToken());
        }

        String cols = in.readLine();
        for (int i = 1; i <= n; i++) {
            colors[i] = cols.charAt(i - 1);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 4; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        Boolean[] vis = new Boolean[n + 1];
        Arrays.fill(vis, false);
        vis[s] = true;

        int ans = solve(dp, s, 3, dp[s][0], 0, vis);
        if (ans == Integer.MAX_VALUE) {
            System.out.println("-1");
            return;
        }
        System.out.println(ans);
    }

    private static int solve(int[][] dp, int curr, int lastmove, int total, int moves, Boolean[] vis) {

        if (curr < 1 || curr >= dp.length - 1) {
            if (total >= k) {
                return moves;
            }
            return Integer.MAX_VALUE;
        }

        if (total >= k) {
            return dp[curr][3] = moves;
        }

        if (dp[curr][lastmove] != Integer.MAX_VALUE) {
            return dp[curr][lastmove];
        }
//        vis[curr] = true;

        if (curr == s) {
            vis[curr - 1] = true;
            dp[curr][1] = Integer.min(dp[curr][1], solve(dp, curr - 1, 1, total + dp[curr - 1][0], moves + 1, vis));
            vis[curr - 1] = false;
            vis[curr + 1] = true;
            dp[curr][2] = Integer.min(dp[curr][2], solve(dp, curr + 1, 2, total + dp[curr + 1][0], moves + 1, vis));
            vis[curr + 1] = false;

            return Integer.min(dp[curr][1], dp[curr][2]);
        }

        int movsDown = Integer.MAX_VALUE;
        if (colors[curr - 1] != colors[curr]) {
            vis[curr - 1] = true;
            movsDown = solve(dp, curr - 1, 1, vis[curr - 1] ? total : total + dp[curr - 1][0], lastmove == 1 ? moves + 1 : moves, vis);
            vis[curr - 1] = false;
        }

        int movsUp = Integer.MAX_VALUE;
        if (colors[curr + 1] != colors[curr]) {
            vis[curr + 1] = true;
            movsUp = solve(dp, curr + 1, 2, vis[curr + 1] ? total : total + dp[curr + 1][0], lastmove == 2 ? moves + 1 : moves, vis);
            vis[curr + 1] = false;
        }

        return dp[curr][3] = Integer.min(movsDown, movsUp);
    }
}

class Pair {

    int val;
    char col;

    public Pair(int val) {
        this.val = val;
    }

    public void setCol(char col) {
        this.col = col;
    }

}

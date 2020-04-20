package UVA.UVA10036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = null;

        /*
        2
4 7
17 5 -21 15
4 5
17 5 -21 15
         */
        int M = Integer.parseInt(in.readLine());
        while (M-- > 0) {

            StringTokenizer stk = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());

            int[][] dp = new int[n + 1][3];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = -1;
                }
            }

            dp[0][0] = 0;

            stk = new StringTokenizer(in.readLine());
            for (int i = 1; i <= n; i++) {
                dp[i][0] = Integer.parseInt(stk.nextToken());
            }
            if (solve(dp, 1, 1, 0, k)) {
                System.out.println("Divisible");
            } else {
                System.out.println("Not divisible");
            }

        }
    }

    private static Boolean solve(int[][] dp, int curr, int op, int total, int k) {
        if (curr >= dp.length) {
            return total % k == 0;
        }

        if (dp[curr][op] != -1) {
            return dp[curr][op] == 1;

        }

        if (solve(dp, curr + 1, 1, total + dp[curr][0], k)) {
            dp[curr][1] = 1;
        } else {
            dp[curr][1] = 0;
        }
        if (solve(dp, curr + 1, 2, total - dp[curr][0], k)) {
            dp[curr][2] = 1;
        } else {
            dp[curr][2] = 0;
        }

        return dp[curr][1] == 1 || dp[curr][2] == 1;
    }
}

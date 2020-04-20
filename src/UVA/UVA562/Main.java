package UVA.UVA562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            stk = new StringTokenizer(in.readLine());
            int[][] dp = new int[n + 1][n + 1];
            dp[0][0] = 0;
            int total = 0;
            for (int i = 1; i <= n; i++) {
                dp[0][i] = Integer.parseInt(stk.nextToken());
                total += dp[0][i];
            }
            for (int i = 0; i < n + 1; i++) {
                dp[i][0] = i;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == 1 || j == 1) {
                        dp[i][j] = Math.abs(total - (dp[i][0] * dp[0][j]) - (dp[i][0] * dp[0][j]));
                    } else {
                        int solve1 = dp[i-1][j];
                        int solve2 = dp[i][j - 1];
                        if (solve1 < solve2) {
                            dp[i][j] = dp[i-1][j];
                        } else {
                            dp[i][j] = dp[i][j - 1];
                        }
                    }
                }
            }
            sb.append(dp[n][n] + "\n");
        }
        System.out.print(sb);
    }
}

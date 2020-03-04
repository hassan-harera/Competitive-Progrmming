package UVA.UVA12148;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        String str;

        int n;
        while ((n = Integer.parseInt(in.readLine())) != 0) {
            int[][] g = new int[n][4];
            int days = 0;
            LocalDate l2 = null;
            int res = 0;
            for (int i = 0; i < n; i++) {
                stk = new StringTokenizer(in.readLine());
                g[i][0] = Integer.parseInt(stk.nextToken());
                g[i][1] = Integer.parseInt(stk.nextToken());
                g[i][2] = Integer.parseInt(stk.nextToken());
                g[i][3] = Integer.parseInt(stk.nextToken());
                if (i == 0) {
                } else {
                    LocalDate l1 = LocalDate.of(g[i][2], g[i][1], g[i][0]);
                    long def = ChronoUnit.DAYS.between(l2, l1);
                    if (def == 1) {
                        if (i >= 2) {
                            LocalDate l3 = LocalDate.of(g[i - 2][2], g[i - 2][1], g[i - 2][0]);
                            if (ChronoUnit.DAYS.between(l3, l2) == 1) {
                                days++;
                            } else {
                                days = 2;
                            }
                        }
                        res += Math.abs(g[i][3] - g[i - 1][3]);
                    }
                }
                l2 = LocalDate.of(g[i][2], g[i][1], g[i][0]);
            }
            sb.append(days + " " + res + "\n");
        }
        System.out.print(sb);
    }

}

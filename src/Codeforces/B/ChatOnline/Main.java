package Codeforces.B.ChatOnline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int p = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());

        Boolean[] T = new Boolean[1010];
        Arrays.fill(T, false);

        int[][] P = new int[p][2];
        for (int i = 0; i < p; i++) {
            stk = new StringTokenizer(in.readLine());
            P[i][0] = Integer.parseInt(stk.nextToken());
            P[i][1] = Integer.parseInt(stk.nextToken());
        }

        int[][] Q = new int[q][2];
        for (int i = 0; i < q; i++) {
            stk = new StringTokenizer(in.readLine());
            Q[i][0] = Integer.parseInt(stk.nextToken());
            Q[i][1] = Integer.parseInt(stk.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                int start = Integer.max(P[i][0] - Q[j][1], l);
                int end = Integer.min((P[i][1] - Q[j][0]), r);
                for (int k = start; k <= end; k++) {
                    if (!T[k]) {
                        T[k] = true;
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

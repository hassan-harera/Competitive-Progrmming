package Codeforces.B.Summerselloff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int f = Integer.parseInt(stk.nextToken());

        int p[] = new int[n];
        int c[] = new int[n];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(in.readLine());
            p[i] = Integer.parseInt(stk.nextToken());
            c[i] = Integer.parseInt(stk.nextToken());
        }

        int oldSell[] = new int[n];
        day days[] = new day[n];
        for (int i = 0; i < n; i++) {
            oldSell[i] = Integer.min(p[i], c[i]);
            int newSell = Integer.min(2 * p[i], c[i]);
            days[i] = new day(i, Math.abs(oldSell[i] - newSell), newSell);
        }

        Arrays.sort(days);
        long ans = 0;

        Boolean[] vis = new Boolean[n];
        Arrays.fill(vis, false);

        for (int i = 0; i < f; i++) {
            ans += days[i].totalSell;
            vis[days[i].idx] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans += oldSell[i];
            }
        }

        System.out.println(ans);
    }
}

class day implements Comparable<day> {

    int idx, increase, totalSell;

    public day(int idx, int increase, int totalSell) {
        this.idx = idx;
        this.increase = increase;
        this.totalSell = totalSell;
    }

    @Override
    public int compareTo(day t) {
        if (increase != t.increase) {
            return t.increase - increase;
        }
        return 0;
    }
}

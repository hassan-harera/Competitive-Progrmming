package Codeforces.C.AnyaandSmartphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] pos = new int[100005];
    static int[] idx = new int[100005];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        long ans = 0;

        int n = Integer.parseInt(stk.nextToken()),
                m = Integer.parseInt(stk.nextToken()),
                k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
            int c = Integer.parseInt(stk.nextToken());

            idx[i] = c;
            pos[c] = i;
        }

        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(stk.nextToken());

            int ap = pos[a];
            int bp = ap - 1;

            int b = idx[bp];

            ans += (ap / k);

            if (ap % k != 0) {
                ans++;
            }

            if (ap == 1) {
                continue;
            }

            pos[a] = bp;
            pos[b] = ap;

            idx[ap] = b;
            idx[bp] = a;
        }
        System.out.println(ans);
    }
}

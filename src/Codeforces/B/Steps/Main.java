package Codeforces.B.Steps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(in.readLine());

        int cr = Integer.parseInt(stk.nextToken());
        int cc = Integer.parseInt(stk.nextToken());

        int k = Integer.parseInt(in.readLine());

        long ans = 0;
        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            long le = 0, ri = 1000000000, mid = 0;
            long max = 0;
            while (le <= ri) {
                mid = (le + ri) / 2;
                if (cr + (mid * r) >= 1 && cr + (mid * r) <= n && cc + (mid * c) <= m && cc + (mid * c) >= 1) {
                    max = mid;
                    le = mid + 1;
                } else {
                    ri = mid - 1;
                }
            }
            cr += (int) (max * r);
            cc += (max * c);
            ans += max;
        }

        System.out.println(ans);

    }
}

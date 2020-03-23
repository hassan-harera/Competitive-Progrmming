package Codeforces.B.BurningMidnightOil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int left = k;
        int right = n;

        int ans = Integer.MAX_VALUE;
        int mid = 0;
        int fin = n;

        while (left < right) {
            mid = (left + right) / 2;
            int res = 0, j = - 1;
            double total;
            while ((total = mid / Math.pow(k, ++j)) > 0) {
                res += total;
            }
            if (res < n) {
                left = mid + 1;
            } else if (res == n) {
                System.out.println(mid);
                return;
            } else {
                right = mid;
                ans = Integer.min(res, ans);
                fin = Integer.min(mid, fin);
            }
        }
        System.out.println(fin);
    }
}

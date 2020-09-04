package Codeforces.D.Hasan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, x, y;
    static long ans;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        n = Integer.parseInt(stk.nextToken());
        x = Integer.parseInt(stk.nextToken());
        y = Integer.parseInt(stk.nextToken());

        int lowest = x < y ? x : y;

        long end = lowest * n;
        search(1, end);
        System.out.println(ans);
    }

    private static void search(long start, long end) {
        if (start == end) {
            ans = end;
            return;
        }

        long mid = (start + end) / 2;
        long comps = (mid / x) + (mid / y);
        if (comps < n) {
            search(mid + 1, end);
        } else {
            search(start, mid);
        }
    }
}

package Codeforces.C.GeometricProgression;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Long> m1 = new HashMap<Integer, Long>();
    private static Map<Integer, Long> m2 = new HashMap<Integer, Long>();
    private static int[] a = new int[200009];
    static int n, k;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        solve();
    }

    private static void solve() {
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int x = a[i];

            if (x % k == 0) {
                ans += m1.containsKey(x / k) ? m1.get(x / k) : 0;
                m1.put(x, m2.containsKey(x / k) ? m2.get(x / k) + (m1.containsKey(x) ? m1.get(x) : 0) : 0);
            }
            m2.put(x, m2.containsKey(x) ? m2.get(x) + 1 : 1);
        }
        System.out.println(ans);
    }
}

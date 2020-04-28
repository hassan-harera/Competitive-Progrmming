package Codeforces.B.TwoButtons;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int st2 = comp(n - i, m);
            if (st2 < ans) {
                ans = Integer.min(st2 + i, ans);
            } else {
                break;
            }
        }
        System.out.println(ans);
    }

    public static int comp(int n1, int m1) {
        int steps1 = 0;
        for (int i = 0; n1 < m1 && i < 10000; i++) {
            n1 *= 2;
            steps1++;
        }
        if (n1 != m1) {
            steps1 += (n1 - m1);
        }
        return steps1;
    }
}

package UVA10344;

import java.util.Scanner;

public class Solution {

    static String ans = "Impossible";
    static int[] arr = new int[5];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            arr[i] = in.nextInt();
        }
        solve(0, 0);
        System.out.println(ans);

    }

    private static void solve(int i, int a) {
        if (i == 4) {
            if (a == 23) {
                ans = "Possible";
            }
            return;
        }
        solve(i + 1, a + arr[i] + arr[i + 1]);
        solve(i + 1, a + arr[i] * arr[i + 1]);
        solve(i + 1, a + arr[i] - arr[i + 1]);
        solve(i + 1, a + arr[i] / arr[i + 1]);
    }
}

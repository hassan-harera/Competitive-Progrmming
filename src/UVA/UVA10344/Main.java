package UVA.UVA10344;

import java.util.Scanner;

public class Main {

    static String ans = "Impossible";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = in.nextInt();
        }

        Boolean[] vis = {false, false, false, false, false};
        solve(0, vis, true, 0, arr);
        System.out.println(ans);

    }

    private static void solve(int len, Boolean[] vis, Boolean first, int sum, int[] arr) {
        if (len >= 5) {
            if (sum == 23) {
                ans = "Possible";
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (vis[i]) {
                continue;
            }

            vis[i] = true;

            if (first) {
                solve(len + 1, vis, false, arr[i], arr);
            } else {
                solve(len + 1, vis, false, sum + arr[i], arr);
                solve(len + 1, vis, false, sum * arr[i], arr);
                solve(len + 1, vis, false, sum - arr[i], arr);
            }

            vis[i] = false;
        }
    }
}

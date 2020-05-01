package Codeforces.B.ValeraandContest;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        int sa = in.nextInt();
        int sk = in.nextInt();

        int[] ans = new int[n];

        int dis = sk / k;
        int rem = sk % k;
        for (int i = 0; i < k; i++) {
            ans[i] = dis;
            if (rem > 0) {
                ans[i]++;
                rem--;
            }
        }

        if (n - k != 0) {
            dis = (sa - sk) / (n - k);
            rem = (sa - sk) % (n - k);
        }

        for (int i = k; i < n; i++) {
            ans[i] = dis;
            if (rem > 0) {
                ans[i]++;
                rem--;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
//        long sum = 0;

//        for (int i = 0; i < n; i++) {
//            sum += ans[i];
//        }
//        System.out.println("");
//        System.out.println(sum);
    }
}

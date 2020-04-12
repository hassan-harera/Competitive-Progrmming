package Codeforces.B.Fence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        arr = new int[n + 1];

        stk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 1; i <= n - k + 1; i++) {
            int a = sum(i, i + k - 1);
            if (a < ans) {
                idx = i;
                ans = a;
            }
        }
        System.out.println(idx);
    }

    public static int sum(int s, int e) {
        return arr[e] - arr[s - 1];
    }

}

package Codeforces.B.MahmoudandaTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];

        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        for (int i = n - 1; i > 1; i--) {
            if (arr[i] >= arr[i - 1] && arr[i - 1] >= arr[i - 2]) {
                if (arr[i - 1] + arr[i - 2] > arr[i]) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}

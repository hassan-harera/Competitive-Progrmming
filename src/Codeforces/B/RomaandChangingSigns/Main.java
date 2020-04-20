package Codeforces.B.RomaandChangingSigns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int arr[] = new int[n];

        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());

        }
        Arrays.sort(arr);

        int ans = 0;
        for (int i = 0; i < n && k > 0; i++) {
            if (arr[i] < 0) {
                arr[i] *= -1;
                k--;
            }
        }

        if (k > 0) {
            for (int i = n - 1; i >= 0 && k > 0; i--) {
                if (k >= 2) {
                    k -= 2;
                } else {
                    arr[0] *= -1;
                    k--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            ans += arr[i];
        }
        System.out.println(ans);
    }
}

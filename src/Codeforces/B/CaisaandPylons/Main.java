package Codeforces.B.CaisaandPylons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int arr[] = new int[n + 1];
        int e = 0;
        int max = 0;
        int total = 0;

        arr[0] = 0;
        StringTokenizer stk = new StringTokenizer(in.readLine());
        for (int i = 1; i < n + 1; i++) {
            int curr = Integer.parseInt(stk.nextToken());
            arr[i] = curr;
            max = Integer.max(max, curr);
            if (e + (arr[i - 1] - arr[i]) >= 0) {
                e += (arr[i - 1] - arr[i]);
            } else if (e + (arr[i - 1] - arr[i]) < 0) {
                total += Math.abs(arr[i - 1] - arr[i]) - e;
                e = 0;
            }
        }
        if (max == 0) {
            System.out.println(0);
            return;
        }

        System.out.println(total);

    }
}

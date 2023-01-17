package LefthandersRighthandersandAmbidexters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int ans = 0, min = 0;
        min = Math.min(arr[0], arr[1]);

        ans += min * 2;
        arr[0] -= min;
        arr[1] -= min;

        while (arr[2] >= 1) {
            if (arr[0] == 0 && arr[1] == 0) {
                int c = arr[2] / 2;
                ans += c * 2;
                break;
            } else if (arr[0] == 0) {
                min = Integer.min(arr[1], arr[2]);
                ans += min * 2;
                arr[2] -= min;
                arr[1] -= min;
            } else if (arr[1] == 0) {
                min = Integer.min(arr[0], arr[2]);
                ans += min * 2;
                arr[2] -= min;
                arr[0] -= min;
            }
        }
        System.out.println(ans);
    }
}

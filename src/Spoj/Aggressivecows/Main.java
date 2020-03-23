package Spoj.Aggressivecows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int ans;
    static int arr[];
    static int n, c;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        ans = Integer.MAX_VALUE;

        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            stk = new StringTokenizer(in.readLine());

            n = Integer.parseInt(stk.nextToken());
            c = Integer.parseInt(stk.nextToken());

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(in.readLine());
            }

            Arrays.sort(arr);

            binarySearch();
            System.out.print(ans);
        }
    }

    static void binarySearch() {
        int min = 1, max = arr[arr.length - 1];

        int mid;

        while (min < max) {
            mid = ((min + max) / 2) + 1;
            if (solve(mid)) {
                return;
            } else {
                max = mid;
            }
        }
    }

    static Boolean solve(int val) {

        int first = 1, second = 0;
        int counter = 1;

        for (; first < arr.length; first++) {
            if (arr[first] - arr[second] >= val) {
                counter++;
                second = first;
            }
        }

        if (counter >= c) {
            ans = Integer.min(ans, val);
            return true;
        }
        return false;
    }

}

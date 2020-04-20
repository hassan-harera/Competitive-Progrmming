package Codeforces.C.Vacations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        arr = new int[n + 1];

        StringTokenizer stk = new StringTokenizer(in.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        System.out.println(solve(1, -1, 0));

    }

    public static int solve(int day, int lastChoice, int total) {
        if (day >= arr.length) {
            return total;
        }

        int ans = Integer.MAX_VALUE;

        if (arr[day] == 0) {
            ans = solve(day + 1, 0, total + 1);
        } else if (arr[day] == 3) {
            if (lastChoice == 1) {
                ans = solve(day + 1, 2, total);
            } else if (lastChoice == 2) {
                ans = solve(day + 1, 1, total);
            } else if (day < arr.length - 1 && arr[day + 1] == 2) {
                ans = Integer.min(ans, solve(day + 1, 1, total));
            } else if (day < arr.length - 1 && arr[day + 1] == 1) {
                ans = Integer.min(ans, solve(day + 1, 2, total));
            } else if (day < arr.length - 1 && arr[day + 1] == 0) {
                ans = Integer.min(ans, solve(day + 1, 1, total));
            } else {
                ans = Integer.min(ans, solve(day + 1, 2, total));
                ans = Integer.min(ans, solve(day + 1, 1, total));
            }
        } else {
            if (arr[day] == lastChoice) {
                ans = solve(day + 1, 0, total + 1);
            } else {
                ans = solve(day + 1, arr[day], total);
            }
        }
        return ans;
    }
}

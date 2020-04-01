package Codeforces.B.BearandFindingCriminals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());

        int arr[] = new int[n];
        int total = 0;
        int curr = Integer.parseInt(stk.nextToken()) - 1;

        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        if (arr[curr] == 1) {
            total++;
        }

        for (int i = 1; i < n; i++) {
            if (curr + i >= arr.length && curr - i < 0) {
                break;
            }
            if (curr + i < arr.length && curr - i >= 0) {
                if (arr[curr - i] == 1 && arr[curr + i] == 1) {
                    total += 2;
                }
            } else if (curr - i < 0) {
                if (arr[curr + i] == 1) {
                    total++;
                }
            } else if (curr + i >= arr.length) {
                if (arr[curr - i] == 1) {
                    total++;
                }
            }

        }
        System.out.println(total);

    }
}

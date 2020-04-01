package Codeforces.B.PetyaandCountryside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int arr[] = new int[n];
        int max = -1;

        StringTokenizer stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0; i < arr.length; i++) {
            int total = 1;
            int last = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= arr[last]) {
                    total++;
                    last = j;
                } else {
                    break;
                }
            }
            last = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] <= arr[last]) {
                    total++;
                    last = j;
                } else {
                    break;
                }
            }
            max = Integer.max(max, total);
        }
        System.out.println(max);

    }
}

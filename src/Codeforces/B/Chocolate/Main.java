package Codeforces.B.Chocolate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        StringTokenizer stk = new StringTokenizer(in.readLine());

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        long zeros = 1;
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                Boolean flag = false;
                int idx = i + 1;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] == 1) {
                        flag = arr[j] == 1;
                        idx = j;
                        break;
                    }
                }
                if (flag) {
                    zeros *= idx - i;
                }
                ones++;
            }
        }
        if (ones == 1) {
            System.out.println(1);
            return;
        }
        if (ones == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(zeros);
    }
}

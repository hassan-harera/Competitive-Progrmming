package Codeforces.A.Isitrated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] bef = new int[n + 1];
        int[] aft = new int[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            bef[i] = a;
            aft[i] = b;
            if (bef[i] != aft[i]) {
                System.out.println("rated");
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i >= 1 && bef[i] > bef[i - 1]) {
                System.out.println("unrated");
                return;
            }
        }
        System.out.println("maybe");
    }
}

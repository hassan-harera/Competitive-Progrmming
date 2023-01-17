package Codeforces.A.OlesyaandRodion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int t = Integer.parseInt(stk.nextToken());

        int num = 1, c = t;
        while (c > 0) {
            if (c / 10 > 0) {
                num++;
            }
            c /= 10;
        }
        if (num > n) {
            System.out.println("-1");
            return;
        }
        System.out.println("" + Math.pow(10, n - 1) * t);
    }
}

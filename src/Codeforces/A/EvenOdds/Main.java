package Codeforces.A.EvenOdds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        Boolean isEven = n % 2 == 0;
        long res = 0;

        if (isEven && k <= n / 2) {
            res = (2 * k - 1);
        } else if (isEven && k > n / 2) {
            res = ((k * 2) - 2 * (n / 2));
        } else if (!isEven && k <= n / 2 + 1) {
            res = (2 * k - 1);
        } else {
            res = ((k * 2) - 2 * (n / 2 + 1));
        }
        System.out.println(res);
    }
}

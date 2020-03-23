package Codeforces.A.AlyonaandNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int big = n > m ? n : m;
        int small = n <= m ? n : n;
        n = small;
        m = big;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 5 - (2 + i);
            while (true) {
                if (count < 0) {
                } else if (count >= m) {
                    break;
                } else {
                    ++ans;
                }
                count += 5 - (2 + i);
            }
        }

        System.out.println(ans);
    }
}

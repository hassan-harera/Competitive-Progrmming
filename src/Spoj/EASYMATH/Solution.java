package Spoj.EASYMATH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new  StringBuilder();
        StringTokenizer stk;
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            stk = new StringTokenizer(in.readLine());
            int N, M, A, D, Res = 0;
            N = Integer.parseInt(stk.nextToken());
            M = Integer.parseInt(stk.nextToken());
            A = Integer.parseInt(stk.nextToken());
            D = Integer.parseInt(stk.nextToken());

            for (int i = N; i <= M; i++) {
                if (i % A != 0 && i % (A + D) != 0 && i % (A + 2 * D) != 0 && i % (A + 3 * D) != 0 && i % (A + 4 * D) != 0) {
                    Res++;
                }
            }
            sb.append(Res).append("\n");
        }
        System.out.print(sb);
    }

}

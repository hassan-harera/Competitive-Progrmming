package UVA11231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        String str;

        while (!(str = in.readLine()).equals("0 0 0")) {
            stk = new StringTokenizer(str);
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            int C = Integer.parseInt(stk.nextToken());

            if (M == 8 && N == 8) {
                if (C == 1) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                continue;
            }
            int r = N - 8 + 1;
            int c = M - 8 + 1;
            sb.append((r*c)/2).append("\n");
        }
        System.out.print(sb);
    }

}

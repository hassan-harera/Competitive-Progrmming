package Codeforces.A.FancyFence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(in.readLine());
        f:
        while (t-- > 0) {
            int a = Integer.parseInt(in.readLine());
            double out = 180 - a;
            double num = 360 / out;
            int intNum = (int) num;
            if (num % 1 != 0) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }

        }
        System.out.print(sb);
    }
}

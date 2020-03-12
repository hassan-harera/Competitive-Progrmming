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
            Boolean isYes = false;
            for (int i = 3; i <= 8; i++) {
                double res = 180 * (i - 2) / i;
                if (res == a) {
                    sb.append("YES\n");
                    isYes = true;
                    break;
                }
            }
            if (!isYes) {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}

package A.DieRoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int Y = Integer.parseInt(stk.nextToken());
        int W = Integer.parseInt(stk.nextToken());

        int max = Math.max(Y, W);
        int ans = 6 - max + 1;

        if (ans == 1 || ans == 5) {
            System.out.println(ans + "/" + 6);
        } else if (ans == 2 || ans == 3 || ans == 6) {
            int simp = 6 / ans;
            System.out.println(1 + "/" + simp);
        } else {
            System.out.println(2 + "/" + 3);
        }
    }
}

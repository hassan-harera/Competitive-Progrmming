package A.BuyaShovel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int K = Integer.parseInt(stk.nextToken());
        int R = Integer.parseInt(stk.nextToken());

        int i = 1;
        for (i = 1; i <= 10000; i++) {
            if (K * i % 10 == R || K * i % 10 == 0) {
                break;
            }
        }
        System.out.println(i);

    }

}

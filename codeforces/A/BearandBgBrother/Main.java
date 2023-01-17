package A.BearandBgBrother;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int L = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        int i;
        for (i = 0; i < 10000; i++) {
            if (L > B) {
                break;
            }
            L *= 3;
            B *= 2;

        }
        System.out.println(i);

    }

}

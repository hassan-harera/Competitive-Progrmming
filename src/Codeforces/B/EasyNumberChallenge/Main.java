package Codeforces.B.EasyNumberChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        int[] divs = new int[1000009];
        Arrays.fill(divs, -1);
        long ans = 0;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    int cur = (i * j * k);
                    int co = 0;
                    if (divs[cur] != -1) {
                        co = divs[cur];
                    } else {
                        for (int l = 1; l <= Math.sqrt(cur); l++) {
                            if (cur % l == 0) {
                                if (cur / l == l) {
                                    co++;
                                } else {
                                    co += 2;
                                }
                            }
                        }
                        divs[cur] = co;
                    }
                    ans += co;
                }
            }
        }
        System.out.println(ans);
    }
}

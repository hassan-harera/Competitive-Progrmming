package UVA.UVA369;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str;
        while (!(str = in.readLine()).equals("0 0")) {

            StringTokenizer stk = new StringTokenizer(str);

            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            BigInteger nFac = new BigInteger("1");
            BigInteger mFac = new BigInteger("1");
            BigInteger nmFac = new BigInteger("1");
            int nm = n - m;

//            long timeBefore = System.nanoTime();
            for (int i = 2; i <= n; i++) {
                nFac = nFac.multiply(new BigInteger(i + ""));
            }
            for (int i = 2; i <= m; i++) {
                mFac = mFac.multiply(new BigInteger(i + ""));
            }
            for (int i = 2; i <= nm; i++) {
                nmFac = nmFac.multiply(new BigInteger(i + ""));
            }
            BigInteger res = nFac.divide(nmFac);
            res = res.divide(mFac);
//            long timeAfter = System.nanoTime();

// 100 things taken 6 at a time is 1192052400 exactly.

            sb.append(n + " things taken " + m + " at a time is " + res + " exactly.\n");
        }
        System.out.print(sb);
    }
}

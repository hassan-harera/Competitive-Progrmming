package Codeforces.A.PouringRain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static double B = 3.14;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        double d = Integer.parseInt(stk.nextToken());
        double h = Integer.parseInt(stk.nextToken());
        double v = Integer.parseInt(stk.nextToken());
        double e = Integer.parseInt(stk.nextToken());

        double oldVal = B * (d / 2) * (d / 2) * h, newVal;

        while (true) {
            double ne = B * (d / 2) * (d / 2) * (h + e);
            newVal = ne - v;
            if (newVal >= oldVal) {
                System.out.println("NO");
                return;
            }
            System.out.println("YES");
            System.out.println(oldVal/(oldVal-newVal));
            return;
        }
    }
}

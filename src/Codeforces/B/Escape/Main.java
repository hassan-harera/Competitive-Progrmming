package Codeforces.B.Escape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //  v p, v d, t, f and c,
        int vq = Integer.parseInt(in.readLine());
        int vd = Integer.parseInt(in.readLine());
        int t = Integer.parseInt(in.readLine());
        int f = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());

        double qplace = 0;
        double dplace = 0;

        qplace = (vq * t);

        int bijs = 0;
        for (int i = 1; i <= 100000; i++) {
            double hs = (dplace)/(vd -vq);
//            double qdist = hs * vq;
            double ddist = hs * vd;
            if (qplace >= c) {
                break;
            }
            dplace += ddist;
            qplace += qdist;
            if (dplace >= c) {
                break;
            }
            if (dplace >= qplace) {
                bijs++;
                double k = (f + (qplace / vd));
//                qplace += k;
                dplace = dplace/vd;
            }
        }

        System.out.println(bijs);
    }
}

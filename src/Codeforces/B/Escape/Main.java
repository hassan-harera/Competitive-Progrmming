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

        
        if(vq >= vd){
            System.out.println("0");
            return;
        }
        int bijs = 0;

        while (true) {
            double hs = (qplace - dplace) / (vd - vq);
            dplace += (hs * vd);
            qplace += (hs * vq);
            if (qplace < c) {
                bijs++;
                double k = ((dplace / vd) + f);
                qplace += (k * vq);
                dplace = 0;
            }else {
                break;
            }
        }

        System.out.println(bijs);
    }
}

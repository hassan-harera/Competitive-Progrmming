package Codeforces.B.DreamoonandWiFi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String sen = in.readLine();
        String rec = in.readLine();

        Boolean isPlus = true, isMin = true, allIsKnow = true;
        Boolean inplus = false, inmin = false;

        int numP1 = 0, numM1 = 0;
        int numP2 = 0, numM2 = 0, numQ = 0;
        for (int i = 0; i < sen.length(); i++) {
            char ch = sen.charAt(i);
            if (ch == '+') {
                numP1++;
                isMin = false;
            }
            if (ch == '-') {
                numM1++;
                isPlus = false;
            }
        }

        for (int i = 0; i < rec.length(); i++) {
            char ch = rec.charAt(i);
            if (ch == '?') {
                numQ++;
                allIsKnow = false;
            } else if (ch == '-') {
                numM2++;
                inmin = true;
            } else if (ch == '+') {
                numP2++;
                inplus = true;
            }
        }

        if (allIsKnow) {
            if (numM1 != numM2 || numP1 != numP2) {
                System.out.println((double) 0);
            } else {
                System.out.println((double) 1);
            }
            return;
        }

        if ((isPlus && inmin) || (isMin && inplus)) {
            System.out.println((double) 0);
            return;
        }
        double total = Math.pow(2, numQ);

        int difP = numQ-(numP1 - numP2);
        int difM = numQ-(numM1 - numM2);
        int numM = numM1 - numM2;
        int numP = numP1 - numP2;
        long numQfac = fac(numQ);
        long difPfac = fac(difP);
        long difMfac = fac(difM);
        long Mfac = fac(numM);
        long Pfac = fac(numP);
        
        double a = (numQfac / (difPfac*Pfac));
        double b = (numQfac / (difMfac*Mfac));
        double g = (a + b) / 2;
        double ans= g / total;
        System.out.println(ans);
    }

    public static long fac(long a) {
        if(a == 0)
            return 1;
        int t = 1;
        for (int i = 2; i <= a; i++) {
            t *= i;
        }
        return t;
    }

}

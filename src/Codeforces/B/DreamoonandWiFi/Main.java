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

        int difP = numP1 - numP2;
        int difM = numM1 - numM2;
        Double proP = 1.0 * difP / numQ;
        Double proM = 1.0 * difM / numQ;
        if (proM == 1 || proP == 1) {
            System.out.println(1 / total);
            return;
        }
        System.out.println((1.0 * proM / total + 1.0 * proP / total) / 0.5);
    }
}

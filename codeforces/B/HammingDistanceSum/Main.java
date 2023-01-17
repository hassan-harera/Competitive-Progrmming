package Codeforces.B.HammingDistanceSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str1 = in.readLine();
        String str2 = in.readLine();

        StringBuilder small = new StringBuilder();
        StringBuilder big = new StringBuilder();

        if (str1.length() <= str2.length()) {
            small.append(str1);
            big.append(str2);
        } else {
            small.append(str2);
            big.append(str1);
        }

        int ans = 0;
        for (int i = 0; i <= big.length() - small.length(); i++) {
            for (int k = 0; k < small.length(); k++) {
                int c2 = Integer.parseInt(big.charAt(i+k) + "");
                int c1 = Integer.parseInt(small.charAt(k) + "");
                ans += Math.abs(c1 - c2);
            }
        }
        System.out.println(ans);
    }
}

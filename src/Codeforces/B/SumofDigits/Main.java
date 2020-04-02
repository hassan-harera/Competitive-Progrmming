package Codeforces.B.SumofDigits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String num = in.readLine();

        if (num.length() <= 0) {
            System.out.println("0");
            return;
        }

        int times = 0;
        while (num.length() > 1) {
            int n = 0;
            for (int i = 0; i < num.length(); i++) {
                n += Integer.parseInt("" + num.charAt(i));
            }
            num = n + "";
            times++;
        }
        
        System.out.println(times);
    }
}

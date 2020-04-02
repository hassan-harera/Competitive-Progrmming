package Codeforces.B.EasterEggs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] words = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};

        int n = Integer.parseInt(in.readLine());

        String res = "";

        for (int i = 0; i < 7; i++) {
            res += words[Math.abs((i % 7))].charAt(0);
        }
        n -= 7;
        while (n > 0) {
            for (int i = 3; n > 0 && i <= 6; i++) {
                res += words[Math.abs((i % 7))].charAt(0);
                n--;
            }
        }
        System.out.println(res);
    }
}

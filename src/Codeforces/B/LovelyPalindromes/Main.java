package Codeforces.B.LovelyPalindromes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String number = in.readLine();
        StringBuilder palNumber = new StringBuilder(number);

        for (int i = number.length()-1 ; i >= 0; i--) {
            palNumber.append(number.charAt(i));
        }
        System.out.println(palNumber);
    }
}

package LovelyPalindromes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));;
        String str = bf.readLine();
        StringBuilder N = new StringBuilder(str);

        for (int i = str.length() - 1; i >= 0; i--) {
            N.append(str.charAt(i));
        }

        System.out.println(N);

    }
}

package Codeforces.B.Decoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());


        String str = in.readLine();

        String res = "";

        res += str.charAt(0);
            
        Boolean left;
        left = n % 2 == 1;
        
        for (int i = 1; i < n; i++) {
            if (left) {
                String s = str.charAt(i) + res;
                res = s;
                left = !left;
            } else {
                String s = res + str.charAt(i);
                res = s;
                left = !left;
            }
        }
        System.out.println(res);
    }
}

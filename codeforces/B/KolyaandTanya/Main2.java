package Codeforces.B.KolyaandTanya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        long ans = 1, mod = 1000000007, min = 1;

        for (int i = 0; i < 3 * n; i++) {
            ans = (3 * ans) % mod;
        }
        
        for (int i = 0; i < n; i++) {
            min  = (min * 7) % mod;
        }
        long res = (ans - min + mod) % mod;
        System.out.println(res);
    }
}
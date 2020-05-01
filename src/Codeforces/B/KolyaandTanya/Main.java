package Codeforces.B.KolyaandTanya;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    final static long mod = 1000000007;

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long pos = 1;
        for (int i = 0; i < n*3; i++) {
            pos = (pos * 3) % mod;
        }
        long out = 1;
        for (int i = 0; i < n; i++) {
            out = (out * 7) % mod;
        }
        
        long ans = (pos - out + mod) % mod;
        
        System.out.println(ans);
        
    }
}
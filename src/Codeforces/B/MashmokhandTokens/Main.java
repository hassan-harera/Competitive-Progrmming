package Codeforces.B.MashmokhandTokens;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        for (int i = 0; i < n; i++) {

            long w = in.nextLong();

            long mod = (w * a) % b;

            long k0 = mod / a;

            System.out.print(k0 + " ");
        }

    }
}

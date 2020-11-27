package Codeforces.C.LittleGirllandMaximumSum;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int q = in.nextInt();

        int[] NS = new int[n];
        int[] FREQ = new int[n + 1];

        for (int i = 0; i < NS.length; i++) {
            NS[i] = in.nextInt();
        }

        Arrays.sort(NS);

        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
            int r = in.nextInt();

            FREQ[l - 1]++;
            FREQ[r]--;
        }

        for (int i = 1; i < FREQ.length; i++) {
            FREQ[i] = FREQ[i] + FREQ[i - 1];
        }

        Arrays.sort(FREQ);
        
        BigInteger ans = new BigInteger("0");
        for (int i = 0; i < NS.length; i++) {
            ans = ans.add(new BigInteger("" + (FREQ[i+1] * NS[i])));
        }

        System.out.println(ans);
    }

}

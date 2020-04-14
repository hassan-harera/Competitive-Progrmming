package Codeforces.B.OlympicMedal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(in.readLine());
        int r = Integer.parseInt(stk.nextToken());
        int[] Rs = new int[r];
        for (int i = 0; i < r; i++) {
            Rs[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(in.readLine());
        int p1 = Integer.parseInt(stk.nextToken());
        int[] Ps1 = new int[p1];
        for (int i = 0; i < p1; i++) {
            Ps1[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(in.readLine());
        int p2 = Integer.parseInt(stk.nextToken());
        int[] Ps2 = new int[p2];
        for (int i = 0; i < p2; i++) {
            Ps2[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());

        Arrays.sort(Rs);
        Arrays.sort(Ps1);
        Arrays.sort(Ps2);
        int R1 = Rs[r - 1];
        int P1 = Ps1[p1 - 1];
        int P2 = Ps2[0];

        double ans = Math.sqrt((B * P1 * Math.pow(R1, 2)) / ((A * P2) + (B * P1)));
        
        System.out.println(ans);
    }
}

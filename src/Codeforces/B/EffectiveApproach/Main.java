package Codeforces.B.EffectiveApproach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];

        StringTokenizer stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int m = Integer.parseInt(in.readLine());
        int[] ques = new int[m];

        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; i++) {
            ques[i] = Integer.parseInt(stk.nextToken());
        }

        int va  = 0, pe = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] == ques[i]) {
                    pe += n - j;
                    va  += j + 1;
                    break;
                }
            }
        }

        System.out.println(va  + " " + pe);
    }
}

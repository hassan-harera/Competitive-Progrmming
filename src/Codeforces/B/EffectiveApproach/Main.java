package Codeforces.B.EffectiveApproach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
//        int[] arr = new int[n

        Map<Integer, Integer> map = new HashMap();

        StringTokenizer stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(stk.nextToken()), i + 1);
        }

        int m = Integer.parseInt(in.readLine());
        int[] ques = new int[m];

        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; i++) {
            ques[i] = Integer.parseInt(stk.nextToken());
        }

        long va  = 0, pe = 0;

        for (int i = 0; i < m; i++) {
            int c = map.get(ques[i]);
            va  += c;
            pe += (n - c + 1);
        }

        System.out.println(va  + " " + pe);
    }
}

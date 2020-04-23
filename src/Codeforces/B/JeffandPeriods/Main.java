package Codeforces.B.JeffandPeriods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());
 
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
 
        int[] income = new int[n + 1];
        int[] outcome = new int[n + 1];
 
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(in.readLine());
 
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
 
            income[a] += c;
            outcome[b] += c;
        }
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            ans += Integer.max(income[i] - outcome[i], 0);
        }
        System.out.println(ans);
 
    }
}
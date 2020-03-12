package Codeforces.B.Pipeline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.StringTokenizer;

public class Main {

    static Long n, k;
    static Long min;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        n = Long.parseLong(stk.nextToken());
        k = Long.parseLong(stk.nextToken());

        min = Long.MAX_VALUE;
        
        if(n==1){
            System.out.println("0");
            return;
        }
        
        solve(Long.valueOf(2), Long.valueOf(0), Long.valueOf(0));
        if (min == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

    }

    static void solve(Long curr, Long total, Long num) {
        if (total > n) {
            return;
        }
        if (total == n) {
            min = Math.min(min, num);
            return;
        }
        if (curr > k) {
            return;
        }
        if (num == 0) {
            solve(curr + 1, total + curr, num + 1);
            solve(curr + 1, total, num);
        } else {
            solve(curr + 1, total + curr - 1, num + 1);
            solve(curr + 1, total, num);
        }
    }

}

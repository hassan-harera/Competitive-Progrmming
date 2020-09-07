package Codeforces.B.FindTheBone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        Boolean[] holes = new Boolean[n + 1];
        Arrays.fill(holes, false);

        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; i++) {
            holes[Integer.parseInt(stk.nextToken())] = true;
        }

        int bonePos = 1;

        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            
            if (holes[bonePos]) {
                System.out.println(bonePos);
                return;
            }
            
            if (u == bonePos) {
                bonePos = v;
            } else if (v == bonePos) {
                bonePos = u;
            }
        }
        System.out.println(bonePos);
    }
}
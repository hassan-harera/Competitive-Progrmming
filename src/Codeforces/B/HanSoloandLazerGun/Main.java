package Codeforces.B.HanSoloandLazerGun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int x0 = Integer.parseInt(stk.nextToken());
        int y0 = Integer.parseInt(stk.nextToken());

        Set<Double> map = new HashSet();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            
            if (y == y0) {
                ans = 1;
            } else {
                map.add((double) (x0 - x) / (y0 - y));
            }
        }
        
        System.out.println(map.size() + ans);

    }
}

package Codeforces.B.WetSharkandBishops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(in.readLine());

        Map<Integer, Integer> plus = new HashMap();
        Map<Integer, Integer> mins = new HashMap();

        long ans = 0;

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            if (plus.containsKey(a + b)) {
                int val = plus.get(a + b);
                plus.remove(a + b);
                plus.put(a + b, val + 1);
            } else {
                plus.put(a + b, 1);
            }

            if (mins.containsKey(a - b)) {
                int val = mins.get(a - b);
                mins.remove(a - b);
                mins.put(a - b, val + 1);
            } else {
                mins.put(a - b, 1);
            }
        }

        for (Integer i : plus.keySet()) {
            int cur = plus.get(i);
            if (cur >= 2) {
                ans += cur * (cur - 1) / 2;
            }
        }

        for (Integer i : mins.keySet()) {
            int cur = mins.get(i);
            if (cur >= 2) {
                ans += cur * (cur - 1) / 2;
            }
        }
        
        System.out.println(ans);
        
    }
}

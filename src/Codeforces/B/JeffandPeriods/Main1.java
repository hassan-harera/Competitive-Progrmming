package Codeforces.B.JeffandPeriods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[] arr = new int[n];
        StringTokenizer stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Map<Integer, X> map = new HashMap();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                X x = map.get(arr[i]);
                x.dif = i - x.pos;
                x.pos = i;
                map.replace(arr[i], x);
            } else {
                X x = new X();
                x.pos = i;
                x.val = arr[i];
                map.put(arr[i], x);
            }
        }

        System.out.println(map.size());
        StringBuilder sb = new StringBuilder();
        for (Integer i : map.keySet()) {
            sb.append(i + " " + map.get(i).dif);
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

    class X {
        int pos, val, dif;
        
        public X() {
            dif = 0;
        }

        public boolean equals(X x) {
            return x.pos == pos;
        }
    }
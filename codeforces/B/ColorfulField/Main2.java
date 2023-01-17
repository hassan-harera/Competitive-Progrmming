package Codeforces.B.ColorfulField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();
        final String[] CKG = {"Carrots", "Kiwis", "Grapes"};

        int n = Integer.parseInt(stk.nextToken()),
                m = Integer.parseInt(stk.nextToken()),
                k = Integer.parseInt(stk.nextToken()),
                t = Integer.parseInt(stk.nextToken());

        int rows[] = new int[n+1];
        Arrays.fill(rows, 0);
        Map<Integer, Boolean> map = new HashMap();
        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            map.put((a - 1) * m + b, true);
            rows[a]++;
        }
        
        for (int i = 1; i < rows.length; i++) {
            rows[i] += rows[i-1];
        }

        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if (map.containsKey((a - 1) * m + b)) {
                sb.append("Waste").append("\n");
            } else {
                int wasts = a == 1 ? 0 : rows[a-1];
                for (int j = b-1; j > 0; j--) {
                    if (map.containsKey((a - 1) * m + j)) {
                        wasts++;
                    }
                }
                int idx = (((a - 1) * m + b) - wasts)%3;
                idx-=1;
                idx+=3;
                idx%=3;
                sb.append(CKG[idx]).append("\n");
            }
        }
        System.out.print(sb);
    }
}

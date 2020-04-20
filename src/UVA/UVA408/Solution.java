package UVA408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        String str;
        
        while (!(str = in.readLine()).equals("")) {
            stk = new StringTokenizer(str);
            int Step = Integer.parseInt(stk.nextToken());
            int Mod = Integer.parseInt(stk.nextToken());

            Map<Integer, Integer> m = new HashMap<>();
            int i = 0;
            while (true) {
                int res = i % Mod;
                if (!m.containsKey(res)) {
                    m.put(res, i);
                } else {
                    break;
                }
                i = res + Step;
            }
            if (m.size() >= Mod) {
                sb.append("Good Choice\n");
            } else {
                sb.append("Bad Choice\n");
            }
        }
        System.out.print(sb);
    }

}

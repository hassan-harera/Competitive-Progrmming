package Codeforces.A.GoodNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int ans = 0;
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            Boolean[] is = new Boolean[k + 1];
            Arrays.fill(is, false);
            Map<Character, Integer> map = new HashMap<>();

            for (int j = 0; j < str.length(); j++) {
                if (!map.containsKey(str.charAt(j))) {
                    int curr = Integer.parseInt(str.charAt(j) + "");
                    if (curr <= k) {
                        map.put(str.charAt(j), curr);
                        is[curr] = true;
                    }
                }
            }
            for (int j = 0; j < k + 1; j++) {
                if (!is[j]) {
                    break;
                }
                if (j >= k) {
                    ans++;
                }
            }
        }
        System.out.print(ans);
    }

}

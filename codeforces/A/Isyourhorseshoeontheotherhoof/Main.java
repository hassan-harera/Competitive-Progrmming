package A.Isyourhorseshoeontheotherhoof;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());
        Map<Integer, Integer> m = new HashMap<>(4);

        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int A = Integer.parseInt(stk.nextToken());
            if (m.containsKey(A)) {
                ans++;
            } else {
                m.put(A, i);
            }
        }
        System.out.println(ans);
    }
}

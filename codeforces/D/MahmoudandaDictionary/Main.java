package D.MahmoudandaDictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[] map;
    static Map<String, Integer> m;

    public static void main(String[] rags) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());

        map = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            map[i] = i;
        }

        m = new HashMap<>(n);
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            String str = stk.nextToken();
            m.put(str, i);
        }

        while (r-- > 0) {
            stk = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(stk.nextToken());
            String w1 = stk.nextToken();
            String w2 = stk.nextToken();
            int a1 = find(m.get(w1));
            int a2 = find(m.get(w1) + n);
            int b1 = find(m.get(w2));
            int b2 = find(m.get(w2) + n);
            if (N == 1) {
                if (a1 == b2 || a2 == b1) {
                    out.append("NO\n");
                    continue;
                } else {
                    map[a1] = b1;
                    map[a2] = b2;
                }
            } else {
                if (a1 == b1 || a2 == b2) {
                    out.append("NO\n");
                    continue;
                } else {
                    map[a1] = b2;
                    map[a2] = b1;
                }
            }
            out.append("YES\n");
        }
        while (q-- > 0) {
            stk = new StringTokenizer(bf.readLine());
            String w1 = stk.nextToken();
            String w2 = stk.nextToken();
            int a1 = find(m.get(w1));
            int a2 = find(m.get(w1) + n);
            int b1 = find(m.get(w2));
            int b2 = find(m.get(w2) + n);
            if (a1 == b2 || a2 == b1) {
                out.append("2\n");
                continue;
            } else if (a1 == b1 || a2 == b2) {
                out.append("1\n");
                continue;
            } else {
                out.append("3\n");
            }
        }

        System.out.println(out);

    }

    static int find(int a) {
        if (map[a] == a) {
            return a;
        }
        return map[a] = find(map[a]);
    }

}

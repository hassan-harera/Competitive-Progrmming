package MahmoudAndDictionary;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int w, n, m;
    static List<Integer>[] graph;
    static int[] root;
    static Map<String, Integer> words;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();

        w = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        root = new int[w * 2];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }

        graph = new List[w * 2];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        words = new HashMap<>(w);
        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < w; i++) {
            words.put(stk.nextToken(), i);
        }

        while (n-- > 0) {
            stk = new StringTokenizer(in.readLine());
            int c = Integer.parseInt(stk.nextToken());
            int w1 = words.get(stk.nextToken());
            int w2 = words.get(stk.nextToken());
            int a1 = find(w1);
            int a2 = find(w1 + w);
            int b1 = find(w2);
            int b2 = find(w2 + w);
            if (c == 1) {
                if (a1 != b2 && a2 != b1) {
                    root[a1] = b1;
                    root[a2] = b2;
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            } else {
                if (a1 != b1 && a2 != b2) {
                    root[a1] = b2;
                    root[a2] = b1;
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        while (m-- > 0) {
            stk = new StringTokenizer(in.readLine());
            int w1 = words.get(stk.nextToken());
            int w2 = words.get(stk.nextToken());
            int a1 = find(w1);
            int a2 = find(w1 + w);
            int b1 = find(w2);
            int b2 = find(w2 + w);
            if (a1 == b2 || a2 == b1) {
                sb.append("2\n");
            } else if (a1 == b1 || a2 == b2) {
                sb.append("1\n");
            } else {
                sb.append("3\n");
            }
        }
        System.out.println(sb);
    }

    static int find(int k) {
        if (k == root[k]) {
            return k;
        }
        return root[k] = find(root[k]);
    }
}

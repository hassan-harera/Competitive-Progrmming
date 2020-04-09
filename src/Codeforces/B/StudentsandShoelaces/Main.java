package Codeforces.B.StudentsandShoelaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Map<Integer, Integer>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n, m;

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        graph = new HashMap[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new HashMap<>();
        }

        Map<Integer, Integer> Ms = new HashMap();

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if (!Ms.containsKey(a)) {
                Ms.put(a, i + a);
            }
            if (!Ms.containsKey(b)) {
                Ms.put(b, i + b);
            }
            graph[a].put(b, i);
            graph[b].put(a, i);
        }

        int ans = 0;

        if (m > 0) {
            Set<Integer> list = Ms.keySet();

            Boolean[] vis = new Boolean[n + 1];
            Arrays.fill(vis, false);

//            int max = -1;
//            for (int i = 1; i <= n; i++) {
//                int j = graph[i].keySet().size();
//                if(j == 1){
//                    max = i;
//                    break;
//                }
//            }

            for (Integer v : graph[1].keySet()) {
                graph[v].remove(1);
                vis[1] = true;
            }
            ans++;

            for (Integer integer : list) {
                if (!vis[integer] && graph[integer].keySet().size() <= 1) {
                    ans++;
                    vis[integer] = true;
                    for (Integer v : graph[integer].keySet()) {
                        graph[v].remove(integer);
                    }
                }
            }
        } else {
            System.out.println(0);
            return;
        }
        System.out.println(n - ans);
    }
}

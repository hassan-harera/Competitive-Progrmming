package UVA.UVA193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static int N;
    static Map<Integer, Character> colors = new HashMap();

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            stk = new StringTokenizer(in.readLine());
            int k = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            N = k + 1;

            graph = new List[k + 1];
            for (int i = 0; i <= k; i++) {
                graph[i] = new ArrayList();
            }

            int min = Integer.MAX_VALUE;
            int s = -1;

            while (m-- > 0) {
                stk = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            for (int i = 1; i <= k; i++) {
                if (graph[i].size() < min) {
                    min = graph[i].size();
                    s = i;
                }
            }

            List<Integer> ans = solve(s);
            System.out.println(ans.size());
            for (Integer an : ans) {
                System.out.print(an + " ");
            }
        }
    }

    static List<Integer> solve(int s) {
        List<Integer> ans = new ArrayList();
        ans.add(s);

        Queue<Integer> q = new LinkedList();

        q.add(s);
        colors.put(s, 'b');

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer i : graph[cur]) {
                if (colors.containsKey(i)) {
                    continue;
                }
                q.add(i);

                Boolean isBlck = false;
                for (Integer in : graph[i]) {
                    if (colors.containsKey(in) && colors.get(in) == 'b') {
                        isBlck = true;
                        break;
                    }
                }
                if (isBlck) {
                    colors.put(i, 'w');
                } else {
                    colors.put(i, 'b');
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}

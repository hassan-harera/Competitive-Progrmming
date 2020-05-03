package UVA.UVA11503;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static int[] parents, rank;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            parents = new int[n * 2 + 1];
            rank = new int[n * 2 + 1];
            for (int i = 1; i < n + 1; i++) {
                parents[i] = i;
                rank[i] = 1;
            }

            Map<String, Integer> map = new HashMap();
            int idx = 1;
            for (int i = 0; i < n; i++) {
                String f1 = sc.next();
                String f2 = sc.next();
                if (!map.containsKey(f1)) {
                    map.put(f1, idx);
                    idx++;
                }
                if (!map.containsKey(f2)) {
                    map.put(f2, idx);
                    idx++;
                }
                int a = map.get(f1);
                int b = map.get(f2);

                System.out.println(union(a, b));
            }

        }
    }

//    public static int solve(Queue<Integer> q, int a, int b) {
//        Boolean[] vis = new Boolean[graph.length];
//        Arrays.fill(vis, false);
//        vis[a] = true;
//        vis[b] = true;
//        q.add(a);
//        q.add(b);
//        int ans = 2;
//        while (!q.isEmpty()) {
//            int curr = q.poll();
//            for (Integer i : graph[curr]) {
//                if (!vis[i]) {
//                    q.add(i);
//                    vis[i] = true;
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }
    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    public static int union(int a, int b) {
        int ap = find(a);
        int bp = find(b);
        if (rank[ap] <= rank[bp]) {
            parents[bp] = ap;
            rank[bp] += rank[ap];
        } else {
            parents[ap] = bp;
            rank[ap] += rank[bp];
        }
        return Integer.max(rank[ap], rank[bp]);
    }

}

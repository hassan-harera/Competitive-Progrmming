package UVA.UVA10600;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int parents[];

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            parents = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                parents[i] = i;
            }

            PriorityQueue<Edge> pq = new PriorityQueue();
            List<Edge> list = new ArrayList();

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                Edge e = new Edge(a, b, c);
                pq.add(e);
                list.add(e);
            }
            int ans = 0;
            Map<Edge, Integer> map = new HashMap();
            int na = 0;
            while (!pq.isEmpty()) {
                Edge curr = pq.poll();
                if (union(curr.from, curr.to)) {
                    ans += curr.cost;
                    map.put(curr, 1);
                    na++;
                }
            }
            System.out.print(ans);
            int secCosr = Integer.MAX_VALUE;
            for (Edge e : map.keySet()) {

                parents = new int[n + 1];
                for (int i = 0; i < n + 1; i++) {
                    parents[i] = i;
                }
                pq = new PriorityQueue();
                for (Edge eg : list) {
                    if (!eg.equals(e)) {
                        pq.add(eg);
                    }
                }
                int cost = 0;
                int num = 0;
                while (!pq.isEmpty()) {
                    Edge curr = pq.poll();
                    if (union(curr.from, curr.to)) {
                        cost += curr.cost;
                        num++;
                    }
                }
                if (cost >= ans && num == na) {
                    secCosr = Integer.min(secCosr, cost);
                }
            }
            System.out.print(" " + secCosr + "\n");
            /*
                    for(i = 0; i < idx; i++) {
            cost = 0;
            E[ontree[i]].enable = 1;
            init(n);
            int cnt = 0;
            for(j = 0; j < m; j++) {
                if(!E[j].enable && joint(E[j].x, E[j].y)) {
                    cost += E[j].v;
                    cnt++;
                }
            }
            E[ontree[i]].enable = 0;
            if(mincost > cost && cnt == n-1) // cnt important
                mincost = cost;
        }
        printf("%d\n", mincost);
             */

        }
    }

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    public static Boolean union(int a, int b) {
        int bParent = find(b);
        int aParent = find(a);

        if (bParent != aParent) {
            parents[bParent] = aParent;
            return true;
        }

        return false;
    }
}

class Edge implements Comparable<Edge> {

    int from, to, cost;
    Boolean del;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
        del = false;
    }

    @Override
    public int compareTo(Edge o) {
        return cost - o.cost;
    }

    public boolean equals(Edge e) {
        if (from == e.from && e.cost == cost && e.to == to) {
            return true;
        }
        return false;
    }

}

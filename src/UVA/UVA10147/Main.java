package UVA.UVA10147;

import java.awt.Point;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int parents[];

    public static void main(String[] args) throws IOException {

//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            Point[] points = new Point[n];

            for (int i = 0; i < n; i++) {
                points[i] = new Point(sc.nextInt(), sc.nextInt());
            }

            parents = new int[n + 1];

            for (int i = 0; i < n + 1; i++) {
                parents[i] = i;
            }
            int number_of_railways = 0;
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (union(a, b)) {
                    number_of_railways++;
                }
            }
            if (number_of_railways == n - 1) {
                System.out.println("No new highways need");
                return;
            }
            PriorityQueue<Edge> pq = new PriorityQueue();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        int distance = (int) Math.pow(points[i].x - points[j].x, 2) + (int) Math.pow(points[i].y - points[j].y, 2);
                        pq.add(new Edge(i + 1, j + 1, distance));
                    }
                }
            }
            while (!pq.isEmpty()) {
                Edge curr = pq.poll();
                if (union(curr.from, curr.to)) {
                    System.out.println(curr.from + " " + curr.to);
                }
            }

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

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return cost - o.cost;
    }

}

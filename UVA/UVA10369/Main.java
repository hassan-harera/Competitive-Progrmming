package UVA.UVA10369;

import java.awt.Point;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

// 1 2 4 0 100 0 300 0 600 150 750
public class Main {

    static int parents[];

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int s = sc.nextInt();
            int p = sc.nextInt();

            Point[] points = new Point[p];

            for (int i = 0; i < p; i++) {
                points[i] = new Point(sc.nextInt(), sc.nextInt());
            }

            parents = new int[p + 1];

            for (int i = 0; i < p + 1; i++) {
                parents[i] = i;
            }

            PriorityQueue<Edge> pq = new PriorityQueue();
            for (int i = 0; i < p; i++) {
                for (int j = 0; j < p; j++) {
                    if (i != j) {
                        double distance = Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));
                        pq.add(new Edge(i + 1, j + 1, distance));
                    }
                }
            }

            Stack<Double> S = new Stack();

            while (!pq.isEmpty()) {
                Edge curr = pq.poll();
                if (union(curr.from, curr.to)) {
                    S.add(curr.cost);
                }
            }

            for (int i = 0; i < (s - 1); i++) {
                S.pop();
            }

            System.out.println(S.pop());

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

    int from, to;
    double cost;

    public Edge(int from, int to, double cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return (int) cost - (int) o.cost;
    }

}
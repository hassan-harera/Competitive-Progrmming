package Spoj.Bitmap;

import java.awt.Point;
import static java.lang.Math.abs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main3 {

    static int[][] pixels;
    static int[][] cost;
    static int[][] moves = {{0, 0, 1, -1}, {1, -1, 0, 0}};
    static int n, m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            n = in.nextInt();
            m = in.nextInt();

            pixels = new int[n][m];
            cost = new int[n][m];
            for (int i = 0; i < n; i++) {
                String line = in.next();
                for (int j = 0; j < m; j++) {
                    if (line.charAt(j) == '1') {
                        pixels[i][j] = 1;
                    } else {
                        pixels[i][j] = 0;
                    }
                }
            }

            clear();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (pixels[i][j] == 1) {
                        cost[i][j] = 0;
                        BFS(i, j);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append(cost[i][j]).append(" ");
                }
                sb.append("\n");
            }

            System.out.print(sb);
        }
    }

    static void BFS(int i, int j) {
        Queue<Point> q = new LinkedList();
        q.add(new Point(i, j));

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int k = 0; k < 4; k++) {
                Point c = new Point(p.x + moves[0][k], p.y + moves[1][k]);
                if (c.x > -1 && c.y > -1 && c.x < n && c.y < m && pixels[c.x][c.y] != 1 && cost[p.x][p.y] + 1 < cost[c.x][c.y]) {
                    q.add(c);
                    cost[c.x][c.y] = cost[p.x][p.y] + 1;
                }
            }
        }
    }

    private static void clear() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}

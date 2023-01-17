package Spoj.Bitmap;

import java.awt.Point;
import static java.lang.Math.abs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {

    static int compR, compC;
    static int[][] pixels;
    static int[][] moves = {{0, 0, 1, -1}, {1, -1, 0, 0}};
    static int n, m;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            n = in.nextInt();
            m = in.nextInt();

            pixels = new int[n][m];
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

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    clear();
                    sb.append(BFS(i, j, visited)).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }

    static int BFS(int i, int j, boolean[][] visited) {
        Queue<Point> q = new LinkedList();

        q.add(new Point(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (pixels[p.x][p.y] == 1) {
                return abs(p.x - i) + abs(p.y - j);
            }
            for (int k = 0; k < 4; k++) {
                Point c = new Point(p.x + moves[0][k], p.y + moves[1][k]);
                if (c.x > -1 && c.y > -1 && c.x < n && c.y < m && !visited[c.x][c.y]) {
                    q.add(c);
                    visited[c.x][c.y] = true;
                }
            }
        }
        return 0;
    }

    private static void clear() {
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
    }

    static class Pixel implements Comparable<Pixel> {

        int r, c;

        public Pixel(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Pixel o) {
            int oDif = Math.abs(o.r - compR) + Math.abs(o.c - compC);
            int thisDif = Math.abs(r - compR) + Math.abs(c - compC);

            return thisDif - oDif;
        }
    }
}

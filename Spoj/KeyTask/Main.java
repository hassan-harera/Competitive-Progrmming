package Spoj.KeyTask;

import java.util.BitSet;
import java.util.Scanner;

public class Main {

    static char[][] grid;
    static int[] movesR = {0, 0, -1, 1};
    static int[] movesC = {1, -1, 0, 0};
    static int ans;
    static int R, C, startR, startC;
    private static boolean[][][] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        R = in.nextInt();
        C = in.nextInt();

        grid = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = in.next();

            for (int j = 0; j < line.length(); j++) {
                grid[i][j] = line.charAt(j);

                if (grid[i][j] == '*') {
                    startR = i;
                    startC = j;
                }
            }
        }

        visited = new boolean[R][C][12];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < visited[0][0].length; k++) {
                    visited[i][j][k] = false;
                }
            }
        }

        ans = Integer.MAX_VALUE;
        visited[startR][startC][0] = true;
        BFS(startR, startC, 0, new char[]{'0', '0', '0', '0'});

        if (ans != Integer.MAX_VALUE) {
            System.out.println("Escape possible in " + ans + " steps.");
        } else {
            System.out.println("The poor student is trapped!");
        }
    }

    private static void BFS(int r, int c, int steps, char[] keys) {
        if (grid[r][c] == 'X') {
            ans = Integer.min(ans, steps);
            return;
        }

        if (grid[r][c] == 'R' && keys[0] != '1') {
            return;
        } else if (grid[r][c] == 'G' && keys[1] != '1') {
            return;
        } else if (grid[r][c] == 'Y' && keys[2] != '1') {
            System.out.print("");
            return;
        } else if (grid[r][c] == 'B' && keys[3] != '1') {
            return;
        }

        if (grid[r][c] == 'r') {
            keys[0] = '1';
        } else if (grid[r][c] == 'g') {
            keys[1] = '1';
        } else if (grid[r][c] == 'y') {
            keys[2] = '1';
        } else if (grid[r][c] == 'b') {
            keys[3] = '1';
        }

        for (int i = 0; i < movesR.length; i++) {
            int nextR = r + movesR[i];
            int nextC = c + movesC[i];

            if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || grid[nextR][nextC] == '#') {
                continue;
            }
            
            int k0 = Integer.parseInt("" + keys[0]) * 1;
            int k1 = Integer.parseInt("" + keys[1]) * 2;
            int k2 = Integer.parseInt("" + keys[2]) * 3;
            int k3 = Integer.parseInt("" + keys[3]) * 4;
            if (!visited[nextR][nextC][k0 + k1 + k2 + k3]) {
                visited[nextR][nextC][k0 + k1 + k2 + k3] = true;
                BFS(nextR, nextC, steps + 1, keys);
            }
        }
    }
}

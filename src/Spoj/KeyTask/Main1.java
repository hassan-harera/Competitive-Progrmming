package Spoj.KeyTask;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main1 {

    static char[][] grid;
    static int[] movesR = {0, 0, -1, 1};
    static int[] movesC = {1, -1, 0, 0};
    static int ans;
    static int R, C, startR, startC;
    static char[] keyList = {'.', 'b', 'r', 'g', 'y'};

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

        int[][][] cost = new int[R][C][150];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < 150; k++) {
                    cost[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        ans = Integer.MAX_VALUE;
        cost[startR][startC]['.'] = 0;
        BFS(startR, startC, cost, new HashSet<Character>(), '.');

        if (ans != Integer.MAX_VALUE) {
            System.out.println("Escape possible in " + ans + " steps.");
        } else {
            System.out.println("The poor student is trapped!");
        }
    }

    private static void BFS(int r, int c, int[][][] cost, HashSet<Character> keys, char key) {
        if (r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == '#') {
            return;
        }

        if (grid[r][c] == 'X') {
            ans = Integer.min(ans, cost[r][c][key]);
        }

        if (grid[r][c] == 'R' || grid[r][c] == 'G' || grid[r][c] == 'Y' || grid[r][c] == 'B') {
            if (Character.toLowerCase(grid[r][c]) != key) {
                return;
            }
        }

        if (grid[r][c] == 'r' || grid[r][c] == 'g' || grid[r][c] == 'y' || grid[r][c] == 'b') {
            keys.add(grid[r][c]);
            char k = grid[r][c];
            cost[r][c][k] = cost[r][c][key];
            key = k;
        }

        for (int i = 0; i < movesR.length; i++) {
            int nextR = r + movesR[i];
            int nextC = c + movesC[i];
            if (cost[r][c][key] + 1 < cost[nextR][nextC][key]) {
                cost[nextR][nextC][key] = cost[r][c][key] + 1;
                BFS(nextR, nextC, cost, keys, key);
            }
        }
    }
}

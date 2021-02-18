package Spoj.KeyTask;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static char[][] grid;
    static int[] movesX = {0, 0, -1, 1};
    static int[] movesY = {1, -1, 0, 0};
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

        int[][][] visited = new int[R][C][5];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        int ans = BFS(visited, startR, startC, 0, 0);

        if (ans != Integer.MAX_VALUE) {
            System.out.println("Escape possible in " + ans + " steps.");
        } else {
            System.out.println("The poor student is trapped!");
        }
    }

    private static int BFS(int[][][] cost, int r, int c, int steps, int key) {
        if (r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == '#'){
            return Integer.MAX_VALUE;
        }
        
        if(grid[r][c] == 'X'){
            return cost[r][c][key];
        }
            
        if (!checkKeyDoor(r, c, key)) {
            return Integer.MAX_VALUE;
        }

        key = getKey(r, c, key);

        if (isDoor(r, c, key)) {
            key = 0;
        }

        if (grid[r][c] == 'X') {
            return steps;
        }

        cost[r][c][key] = true;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < movesX.length; i++) {
            int nextR = r + movesX[i];
            int nextC = c + movesY[i];

            min = Integer.min(min, BFS(cost, nextR, nextC, steps + 1, key));
        }

        return min;
    }

    private static int getKey(int r, int c, int key) {
        for (int i = 1; i < keyList.length; i++) {
            if (grid[r][c] == keyList[i]) {
                return i;
            }
        }
        return key;
    }

    private static Boolean checkKeyDoor(int r, int c, int key) {
//            static char[] keyList = {'.', 'b', 'r', 'g', 'y'};

        if (grid[r][c] == 'G' && key != 3) {
            return false;
        } else if (grid[r][c] == 'B' && key != 1) {
            return false;
        } else if (grid[r][c] == 'R' && key != 2) {
            return false;
        } else if (grid[r][c] == 'Y' && key != 4) {
            return false;
        }
        return true;
    }

    private static Boolean isDoor(int r, int c, int key) {
        if (Character.toUpperCase(key) == grid[r][c]) {
            return true;
        }
        return false;
    }
}

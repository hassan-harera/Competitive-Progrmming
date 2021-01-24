/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.C.Maze;

import java.util.Scanner;

/**
 *
 * @author Harera
 */
public class Main {

    static Boolean vis[][], choosed[][];
    static char[][] grid;
    static int n, m, k;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        k = -k;

        vis = new Boolean[n][m];
        choosed = new Boolean[n][m];
        grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = in.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);

                if (grid[i][j] == '.') {
                    k++;
                }
            }
        }

        clearVis();

        solve:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && !vis[i][j]) {
                    clear();
                    if (solve(i, j, 0)) {
                        break solve;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && !choosed[i][j]) {
                    grid[i][j] = 'X';
                }
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean solve(int i, int j, int sum) {
        if (sum == k) {
            return true;
        }

        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }

        if (grid[i][j] != '.' || vis[i][j]) {
            choosed[i][j] = false;
            return false;
        }

        vis[i][j] = true;
        choosed[i][j] = true;

        if (solve(i, j + 1, sum + 1)) {
            return true;
        }
        if (solve(i + 1, j, sum + 1)) {
            return true;
        }
        if (solve(i - 1, j, sum + 1)) {
            return true;
        }

        return solve(i, j - 1, sum + 1);
    }

    private static void clear() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                choosed[i][j] = false;
            }
        }
    }

    private static void clearVis() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = false;
            }
        }
    }
}

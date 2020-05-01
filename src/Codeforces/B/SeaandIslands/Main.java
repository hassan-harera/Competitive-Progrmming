package Codeforces.B.SeaandIslands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 'S';
            }
        }
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j += 2) {
                    if (k > 0) {
                        grid[i][j] = 'L';
                        k--;
                    }
                }
            } else {
                for (int j = 1; j < n; j += 2) {
                    if (k > 0) {
                        grid[i][j] = 'L';
                        k--;
                    }
                }
            }
        }
        if (k > 0) {
            System.out.println("NO");
        } else {
            String ans = "";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ans += grid[i][j];
                }
                ans += "\n";
            }
            System.out.println(ans);
        }
    }
}

package Codeforces.B.InnaandNewMatrixofCandies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] dwarf = new int[n];
        int[] sweet = new int[n];

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'G') {
                    dwarf[i] = j;
                } else if (grid[i][j] == 'S') {
                    sweet[i] = j;
                }
            }
        }

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            if (dwarf[i] == m - 1) {
                System.out.println("-1");
                return;
            }
            if (sweet[i] < dwarf[i]) {
                System.out.println("-1");
                return;
            } else {
                map.put(sweet[i] - dwarf[i], i);
            }
        }

        System.out.println(map.keySet().size());
    }
}

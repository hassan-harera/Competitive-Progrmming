package UVA.UVA750;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static List<int[]> ans = new ArrayList();
    static boolean[] mainDiagonal = new boolean[18];
    static boolean[] secondDiagonal = new boolean[18];
    static boolean[] rows = new boolean[9];
    static boolean[] cols = new boolean[9];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            ans = new ArrayList();
            Arrays.fill(mainDiagonal, false);
            Arrays.fill(secondDiagonal, false);
            Arrays.fill(rows, false);

            int r = in.nextInt();
            int c = in.nextInt();

            rows[r] = mainDiagonal[c + r] = secondDiagonal[c - r + 8] = true;

            int[] start = new int[9];
            Arrays.fill(start, -1);

            solve(1, 0, start);

            System.out.println("1 2 3 4 5 6 7 8");
            for (int[] an : ans) {
                for (int i : an) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }

    private static void solve(int c, int count, int[] row) {
        if (c > 8) {
            if (count >= 8) {
                ans.add(row);
            }
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!rows[i] && !mainDiagonal[c + i] && !secondDiagonal[c - i + 8]) {
                rows[i] = mainDiagonal[c + i] = secondDiagonal[c - i + 8] = true;
                row[c] = i;
                solve(c + 1, count + 1, row);
                rows[i] = mainDiagonal[c + i] = secondDiagonal[c - i + 8] = false;
            }
        }
    }
}

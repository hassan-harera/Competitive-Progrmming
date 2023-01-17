package UVA.UVA750;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static List<int[]> ans = new ArrayList();
    static int r;
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
            Arrays.fill(cols, false);

            r = in.nextInt();
            int c = in.nextInt();

            rows[r] = cols[c] = mainDiagonal[c + r] = secondDiagonal[c - r + 8] = true;

            int[] start = new int[9];
            Arrays.fill(start, -1);
            start[c] = r;

            solve(1, "");

            System.out.println("1 2 3 4 5 6 7 8");
        }
    }

    private static void solve(int c, String ans) {
        if (c > 8) {
            System.out.println(ans);
            return;
        }
        if (cols[c]) {
            solve(c + 1, ans + (r) + " ");
            return;
        }
        for (int i = 1; i < 9; i++) {
            if (!rows[i] && !mainDiagonal[c + i] && !secondDiagonal[c - i + 8]) {
                rows[i] = true;
                mainDiagonal[c + i] = true;
                secondDiagonal[c - i + 8] = true;
                solve(c + 1, ans + i + " ");
                rows[i] = false;
                mainDiagonal[c + i] = false;
                secondDiagonal[c - i + 8] = false;
            }
        }
    }
}
